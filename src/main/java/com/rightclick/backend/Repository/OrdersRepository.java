package com.rightclick.backend.Repository;


import com.rightclick.backend.Entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity,Integer> {

      Optional<OrdersEntity> findById(Integer id) ;

      List<OrdersEntity> findAllByCustomerId( Integer userId);


}
