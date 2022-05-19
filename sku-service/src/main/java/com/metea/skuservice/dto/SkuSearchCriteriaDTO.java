package com.metea.skuservice.dto;

import com.metea.skuservice.domain.Sku;
import com.metea.skuservice.util.SearchCriteria;
import com.metea.skuservice.util.SearchCriteriaOptions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mete Aydin
 * @date 17.10.2021
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class SkuSearchCriteriaDTO extends SkuReadDTO {
    public SearchCriteriaOptions<Sku> SkuSearchCriteriaFieldMapper(SkuSearchCriteriaDTO filter) {
        final var searchCriteriaOptions = new SearchCriteriaOptions<Sku>();
        searchCriteriaOptions.add(new SearchCriteria("id", filter.getId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("valid", filter.getValid(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("name", filter.getName(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("code", filter.getCode(), SearchCriteria.SearchOperation.LIKE));

        return searchCriteriaOptions;
    }
}
