package com.igor.nvpc.operations;

import com.igor.nvpc.jsons.Root;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;

public enum Order {
    ALPHABETICAL("alphabetical") {
        @Override
        public List<Root> execute(final List<Root> root) {
            root.sort(Comparator.comparing(o -> o.name));
            return root;
        }
    }, LAST_COMMIT("lastCommit") {
        @Override
        public List<Root> execute(final List<Root> root) {
            root.sort((o1, o2) -> {
                final var localDateO1 = ZonedDateTime.parse(o1.updated_at).toLocalDateTime();
                final var localDateO2 = ZonedDateTime.parse(o2.updated_at).toLocalDateTime();
                return localDateO2.compareTo(localDateO1);
            });
            return root;
        }
    };

    private final String value;

    Order(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract List<Root> execute(final List<Root> root);
}
