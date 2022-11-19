package com.igor.nvpc.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiDto {

    @JsonProperty("archived")
    private boolean archived;
    @JsonProperty("disabled")
    private boolean disabled;
    @JsonProperty("updatedAt")
    private String updatedAt;

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
