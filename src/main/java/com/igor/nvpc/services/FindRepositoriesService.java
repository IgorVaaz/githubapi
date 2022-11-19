package com.igor.nvpc.services;

import com.igor.nvpc.models.Filter;
import com.igor.nvpc.models.Order;
import com.igor.nvpc.models.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
public class FindRepositoriesService {

    private final FindRepositoriesServiceRest findRepositoriesServiceRest;

    public FindRepositoriesService(FindRepositoriesServiceRest findRepositoriesServiceRest) {
        this.findRepositoriesServiceRest = findRepositoriesServiceRest;
    }

    public Collection<Root> execute(final String user, final String filter, final String order){
        final var filterOperation = getFilter(filter);
        final var orderOperation = getOrder(order);
        final var root = findRepositoriesServiceRest.execute(user);
        final var rootFiltered = filterOperation.filter(root);
        return orderOperation.order(rootFiltered);
    }

    private Filter getFilter(final String filter){
        try{
            return Filter.valueOf(filter);
        } catch (final Exception exception){
            log.error("Filter not found: {}", exception.getMessage()); //usando lombock
            return Filter.ACTIVE;
        }
    }

    private Order getOrder(final String order){
        try {
            return Order.valueOf(order);
        } catch (final Exception exception){
            log.error("Order not found: {}", exception.getMessage());
            return Order.ALPHABETICAL;
        }
    }

}
