package com.fullcycle.admin.catalogo.infrastructure.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryApiOutput(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name,
    @JsonProperty("description")String description,
    @JsonProperty("is_active")boolean isActive,
    @JsonProperty("created_at")String createdAt,
    @JsonProperty("updated_at")String updatedAt,
    @JsonProperty("deleted_at")String deletedAt
){}


