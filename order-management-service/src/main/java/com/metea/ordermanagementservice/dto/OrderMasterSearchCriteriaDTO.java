package com.metea.ordermanagementservice.dto;

import com.metea.ordermanagementservice.domain.OrderMaster;
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
public class OrderMasterSearchCriteriaDTO extends OrderMasterReadDTO {
    public SearchCriteriaOptions<OrderMaster> OrderMasterSearchCriteriaFieldMapper(OrderMasterSearchCriteriaDTO filter) {
        final var searchCriteriaOptions = new SearchCriteriaOptions<OrderMaster>();
        searchCriteriaOptions.add(new SearchCriteria("id", filter.getId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("customerId", filter.getCustomerId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("status", filter.getStatus(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("amount", filter.getAmount(), SearchCriteria.SearchOperation.EQUAL));


        return searchCriteriaOptions;
    }
}
