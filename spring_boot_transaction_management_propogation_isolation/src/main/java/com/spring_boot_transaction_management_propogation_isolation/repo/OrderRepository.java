package com.spring_boot_transaction_management_propogation_isolation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring_boot_transaction_management_propogation_isolation.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}