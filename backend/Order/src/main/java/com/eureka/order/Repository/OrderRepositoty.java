package com.eureka.order.Repository;

import com.eureka.order.Entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface OrderRepositoty extends JpaRepository<OrderEntity,String> {
    Page<OrderEntity> findAllByUserId(String userid, Pageable pageable);
    List<OrderEntity> findAllByUserId(String userid);
//    Page<OrderEntity> findAllByUserId(String userid);
    Page<OrderEntity> findAllBySellerId(String sellerid,Pageable pageable);
    List<OrderEntity> findAllBySellerId(String sellerid);
}