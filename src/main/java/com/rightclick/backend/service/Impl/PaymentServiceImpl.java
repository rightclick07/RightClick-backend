package com.rightclick.backend.service.Impl;

import com.rightclick.backend.model.PaymentRequest;
import com.rightclick.backend.model.PaymentRequestDTO;
import com.rightclick.backend.service.services.PaymentService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void preparePayment(PaymentRequest paymentRequest) {
        String url = "https://api-preprod.phonepe.com/apis/pg-sandbox/pg/v1/pay";
        // Serialize the object to a byte array
        byte[] serializedObject = serializeObject(paymentRequest);

        // Encode the byte array as Base64
        String payloadBase64 = encodeBase64(serializedObject);
       // String payloadBase64 = encodeToBase64(paymentRequest.toString());
        String xverifier =  xverfier(payloadBase64);

        PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
        paymentRequestDTO.setRequest(payloadBase64);

        HttpHeaders httpHeaders = new HttpHeaders();

        // Set the Content-Type header to JSON if the payload is JSON
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("X-VERIFY", xverifier);
        httpHeaders.set("accept", "application/json");



        // Create the HttpEntity with the payload and headers
        HttpEntity<PaymentRequestDTO> httpEntity = new HttpEntity<>(paymentRequestDTO, httpHeaders);

        ResponseEntity<String> responseEntity= exchange(url, HttpMethod.POST, httpEntity);

        System.out.println(responseEntity);

    }

    private String xverfier(String enCodedPayload) {
        String saltKey =  "612ff945-2855-4b16-a63f-b4b5eb9827ec";// Replace with your actual salt key
        int saltIndex = 1; // Replace with your actual salt index
        String convertedSHA = calculateSHA256(enCodedPayload + "/pg/v1/pay" + saltKey);
        String url = convertedSHA + "###" + saltIndex;
        return url;
    }

    public ResponseEntity<String> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, method, requestEntity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            // Successful response
            String responseBody = response.getBody();
            return ResponseEntity.ok(responseBody);
        } else {
            // Handle other HTTP status codes or errors as needed
            // For example, you can throw an exception or return an appropriate response.
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }

    private static byte[] serializeObject(Object obj) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            objectOutputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    private static String encodeBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public static String calculateSHA256(String input) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");

            // Convert the input string to bytes
            byte[] bytes = input.getBytes();

            // Calculate the SHA-256 hash
            byte[] hashBytes = sha256.digest(bytes);

            // Convert the hash bytes to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
