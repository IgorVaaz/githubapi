package com.igor.nvpc.models;

import java.util.List;
import java.util.stream.Collectors;

public enum Filter {

    ARCHIVED("archived") {
        @Override
        public List<Root> filter(final List<Root> root) {
            return root.stream().filter(r -> Boolean.TRUE.equals(r.archived)).collect(Collectors.toList());
        }
    }, ACTIVE("active") {
        @Override
        public List<Root> filter(final List<Root> root) {
            return root.stream().filter(r -> Boolean.FALSE.equals(r.disabled)).collect(Collectors.toList());
        }
    };

    Filter(final String value) {

    }

    public abstract List<Root> filter(final List<Root> root);
}
