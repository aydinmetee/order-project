package com.metea.ordermanagementservice.repository;

import com.metea.ordermanagementservice.domain.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, Long>, JpaSpecificationExecutor<OrderMaster> {
}
