package com.rightclick.backend.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phonepe.sdk.pg.Env;
import com.phonepe.sdk.pg.common.http.PhonePeResponse;
import com.phonepe.sdk.pg.payments.PhonePePaymentClient;
import com.phonepe.sdk.pg.payments.models.requestV1.PgPayRequest;
import com.phonepe.sdk.pg.payments.models.responseV1.PayPageInstrumentResponse;
import com.phonepe.sdk.pg.payments.models.responseV1.PgPayResponse;
import com.rightclick.backend.constants.AppConstants;
import com.rightclick.backend.model.*;
import com.rightclick.backend.service.services.PaymentService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import okhttp3.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;


@Service
public class PaymentServiceImpl implements PaymentService {

    AppConstants appConstants;

    @Override
    public ResponseDTO preparePayment(PaymentRequest paymentRequest) {
        System.out.println("starting service");
        OkHttpClient client = new OkHttpClient();
         ResponseDTO responseDTO=new ResponseDTO();
         String base64Encoded=jsonToBase64(createJsonPayload());
        System.out.println(base64Encoded);
        // Define the JSON request body
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"request\":\""+ base64Encoded +"\"}");
        System.out.println("create a request");

        String xVerifier=xverfier("ewogICJtZXJjaGFudElkIjogIlBHVEVTVFBBWVVBVCIsCiAgIm1lcmNoYW50VHJhbnNhY3Rpb25JZCI6ICJNVDc4NTA1OTAwNjgxODgxMDQiLAogICJtZXJjaGFudFVzZXJJZCI6ICJNVUlEMTIzIiwKICAiYW1vdW50IjogMTAwMDAsCiAgInJlZGlyZWN0VXJsIjogImh0dHBzOi8vd2ViaG9vay5zaXRlL3JlZGlyZWN0LXVybCIsCiAgInJlZGlyZWN0TW9kZSI6ICJSRURJUkVDVCIsCiAgImNhbGxiYWNrVXJsIjogImh0dHBzOi8vd2ViaG9vay5zaXRlL2NhbGxiYWNrLXVybCIsCiAgIm1vYmlsZU51bWJlciI6ICI5OTk5OTk5OTk5IiwKICAicGF5bWVudEluc3RydW1lbnQiOiB7CiAgICAidHlwZSI6ICJQQVlfUEFHRSIKICB9Cn0=");
        // Create the HTTP request
        Request request = new Request.Builder()
                .url("https://api-preprod.phonepe.com/apis/pg-sandbox/pg/v1/pay")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("X-VERIFY", xVerifier)
                .build();

        try {
            // Execute the HTTP request
            System.out.println("start try block");
            Response response = client.newCall(request).execute();
            System.out.println(response+"response");
            if (response.isSuccessful()) {
                // Parse the JSON response to extract the redirect URL
                String responseBody = response.body().string();
                JSONObject jsonResponse = new JSONObject(responseBody);
                System.out.println(jsonResponse + "jsonResponse");

                // Create an ObjectMapper to deserialize the JSON
                ObjectMapper objectMapper = new ObjectMapper();

                // Deserialize the JSON response into the DataResponse class
                DataResponse dataResponse = objectMapper.readValue(jsonResponse.toString(), DataResponse.class);

                responseDTO.setHttpStatusCode(HttpStatus.OK);
                responseDTO.setMessage(appConstants.successMsg);
                responseDTO.setPayload(dataResponse);
            }

            } catch (Exception e){
                e.printStackTrace();
                responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                responseDTO.setMessage(appConstants.failureMsg);
                responseDTO.setPayload(null);
            }

        return responseDTO;

    }

    private String xverfier(String enCodedPayload) {
        String saltKey =  "099eb0cd-02cf-4e2a-8aca-3e6c6aff0399";// Replace with your actual salt key
        int saltIndex = 1; // Replace with your actual salt index
        String convertedSHA = calculateSHA256(enCodedPayload + "/pg/v1/pay" + saltKey);
        System.out.println(convertedSHA+"convertedSHA");
        String url = convertedSHA + "###" + saltIndex;
        System.out.println(url+"url");
        return url;
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

    public static String createJsonPayload() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Create the JSON payload
            PaymentRequest paymentRequest = new PaymentRequest(
                    "PGTESTPAYUAT",
                    "MT7850590068188104",
                    "MUID123",
                    10000,
                    "https://webhook.site/redirect-url",
                    "REDIRECT",
                    "https://webhook.site/callback-url",
                    "9999999999",
                    new PaymentInstrument("PAY_PAGE")
            );

            // Convert the payload to a JSON string
            String jsonPayload = objectMapper.writeValueAsString(paymentRequest);

            return jsonPayload;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating JSON payload";
        }
    }
    public static String jsonToBase64( String jsonPayload) {
        try {
            // Encode the JSON payload to Base64
            String base64Encoded = Base64.getEncoder().encodeToString(jsonPayload.getBytes());
            return base64Encoded;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error converting JSON to Base64";
        }
    }
}