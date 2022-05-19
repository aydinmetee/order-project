package com.metea.skuservice.repository;

import com.metea.skuservice.domain.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mete Aydin
 * @date 17.10.2021
 */
public interface SkuRepository extends JpaRepository<Sku, Long>, JpaSpecificationExecutor<Sku> {

}
