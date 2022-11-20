package com.igor.nvpc.utils;

import com.igor.nvpc.operations.Filter;
import com.igor.nvpc.operations.Order;

import java.util.Arrays;

public class GetEnum {
    public static Filter filter(final String filter) {
        return Arrays.stream(Filter.values()).filter(
                f -> f.getValue().equalsIgnoreCase(filter)
        ).findFirst().orElse(Filter.ACTIVE);
    }

    public static Order order(final String order) {
        return Arrays.stream(Order.values()).filter(
                f -> f.getValue().equalsIgnoreCase(order)
        ).findFirst().orElse(Order.ALPHABETICAL);
    }
}
