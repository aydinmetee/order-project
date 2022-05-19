package com.metea.skuservice.dto;

import com.metea.skuservice.domain.SkuDetail;
import com.metea.skuservice.util.SearchCriteria;
import com.metea.skuservice.util.SearchCriteriaOptions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author Mete Aydin
 * @date 17.10.2021
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class SkuDetailSearchCriteriaDTO extends SkuDetailReadDTO {
    private BigDecimal minValue;
    private BigDecimal maxValue;

    public SearchCriteriaOptions<SkuDetail> SkuDetailSearchCriteriaFieldMapper(SkuDetailSearchCriteriaDTO filter) {
        final var searchCriteriaOptions = new SearchCriteriaOptions<SkuDetail>();
        searchCriteriaOptions.add(new SearchCriteria("id", filter.getId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("skuMaster/id", filter.getSkuMasterId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("valid", filter.getValid(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("skuMaster/name", filter.getName(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("skuMaster/code", filter.getCode(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("value", filter.getMaxValue(), SearchCriteria.SearchOperation.LESS_THAN_EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("value", filter.getMinValue(), SearchCriteria.SearchOperation.GREATER_THAN_EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("quantity", filter.getQuantity(), SearchCriteria.SearchOperation.EQUAL));

        return searchCriteriaOptions;
    }
}
