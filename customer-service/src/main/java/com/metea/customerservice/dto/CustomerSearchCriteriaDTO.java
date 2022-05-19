package com.metea.customerservice.dto;

import com.metea.customerservice.domain.Customer;
import com.metea.customerservice.util.SearchCriteria;
import com.metea.customerservice.util.SearchCriteriaOptions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class CustomerSearchCriteriaDTO extends CustomerReadDTO {
    public SearchCriteriaOptions<Customer> CustomerSearchCriteriaFieldMapper(CustomerSearchCriteriaDTO filter) {
        final var searchCriteriaOptions = new SearchCriteriaOptions<Customer>();
        searchCriteriaOptions.add(new SearchCriteria("id", filter.getId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("valid", filter.getValid(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("name", filter.getName(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("surname", filter.getSurname(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("phone", filter.getPhone(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("legalId", filter.getLegalId(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("orderAuthorization", filter.getOrderAuthorization(), SearchCriteria.SearchOperation.EQUAL));

        return searchCriteriaOptions;
    }
}
