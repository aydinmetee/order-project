package com.metea.ordermanagementservice.dto;

import com.metea.ordermanagementservice.domain.OrderDetail;
import com.metea.ordermanagementservice.util.SearchCriteria;
import com.metea.ordermanagementservice.util.SearchCriteriaOptions;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Getter
@Setter
public class OrderDetailSearchCriteriaDTO extends OrderDetailReadDTO {
    public SearchCriteriaOptions<OrderDetail> OrderDetailSearchCriteriaFieldMapper(OrderDetailSearchCriteriaDTO filter) {
        final var searchCriteriaOptions = new SearchCriteriaOptions<OrderDetail>();
        searchCriteriaOptions.add(new SearchCriteria("id", filter.getId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("skuId", filter.getSkuId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("value", filter.getValue(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("quantity", filter.getQuantity(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("orderMaster/id", filter.getOrderMasterId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("valid", filter.getValid(), SearchCriteria.SearchOperation.EQUAL));


        return searchCriteriaOptions;
    }
}
