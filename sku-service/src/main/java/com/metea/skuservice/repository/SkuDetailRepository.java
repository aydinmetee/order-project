package com.metea.skuservice.repository;

import com.metea.skuservice.domain.SkuDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Mete Aydin
 * @date 17.10.2021
 */
public interface SkuDetailRepository extends JpaRepository<SkuDetail, Long>, JpaSpecificationExecutor<SkuDetail> {
}
