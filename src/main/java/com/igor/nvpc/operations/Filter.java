package com.igor.nvpc.operations;

import com.igor.nvpc.jsons.Root;

import java.util.List;
import java.util.stream.Collectors;

public enum Filter {
    ARCHIVED("archived") {
        @Override
        public List<Root> execute(final List<Root> root) {
            return root.stream().filter(r -> Boolean.TRUE.equals(r.archived)).collect(Collectors.toList());
        }
    }, ACTIVE("active") {
        @Override
        public List<Root> execute(final List<Root> root) {
            return root.stream().filter(r -> Boolean.FALSE.equals(r.disabled)).collect(Collectors.toList());
        }
    };

    private final String value;

    Filter(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract List<Root> execute(final List<Root> root);
}
