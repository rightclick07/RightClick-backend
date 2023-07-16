package com.rightclick.backend.Repository;

import com.rightclick.backend.Entity.OrderItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity,Integer> {


    Optional<List<OrderItemsEntity>> findByOrderId(Integer integer);
}
