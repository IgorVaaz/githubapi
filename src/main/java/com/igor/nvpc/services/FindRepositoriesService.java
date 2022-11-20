package com.igor.nvpc.services;

import com.igor.nvpc.exceptions.RestTemplateErrorException;
import com.igor.nvpc.jsons.Root;
import com.igor.nvpc.operations.Filter;
import com.igor.nvpc.operations.Order;
import com.igor.nvpc.rest.FindRepositoriesServiceRest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FindRepositoriesService {

    private final FindRepositoriesServiceRest findRepositoriesServiceRest;

    public FindRepositoriesService(final FindRepositoriesServiceRest findRepositoriesServiceRest) {
        this.findRepositoriesServiceRest = findRepositoriesServiceRest;
    }

    public Collection<Root> execute(final String user, final Filter filter, final Order order, final String search) throws RestTemplateErrorException {
        final var root = findRepositoriesServiceRest.execute(user);
        final var rootFilteredAndOrderly = filterAndOrderRoot(root, filter, order);
        return searchInList(search, rootFilteredAndOrderly);
    }

    private List<Root> filterAndOrderRoot(final List<Root> root, final Filter filter, final Order order) {
        log.info("Filter: {}", filter.getValue());
        log.info("Order: {}", order.getValue());
        final var rootFiltered = filter.execute(root);
        return order.execute(rootFiltered);
    }

    private List<Root> searchInList(final String search, final List<Root> rootFilteredAndOrderly) {
        if (StringUtils.isBlank(search)) {
            return rootFilteredAndOrderly;
        }
        log.info("Search: {}", search);
        return rootFilteredAndOrderly.stream().filter(r -> r.name.toUpperCase(Locale.ROOT).contains(search.toUpperCase(Locale.ROOT))).collect(Collectors.toList());
    }

}