package com.fullcycle.admin.catalogo.infrastructure.category.presenters;

import com.fullcycle.admin.catalogo.application.category.retrieve.get.CategoryOutput;
import com.fullcycle.admin.catalogo.application.category.retrieve.list.CategoryListOutput;
import com.fullcycle.admin.catalogo.infrastructure.category.models.CategoryResponse;
import com.fullcycle.admin.catalogo.infrastructure.category.models.CategoryListResponse;

public interface CategoryApiPresenter {

    static CategoryResponse present (final CategoryOutput categoryOutput) {
        return new CategoryResponse(
                categoryOutput.id().getValue(),
                categoryOutput.name(),
                categoryOutput.description(),
                categoryOutput.isActive(),
                categoryOutput.createdAt(),
                categoryOutput.updatedAt(),
                categoryOutput.deletedAt() != null ? categoryOutput.deletedAt() : null
        );
    }

    static CategoryListResponse present (final CategoryListOutput categoryOutput) {
        return new CategoryListResponse(
                categoryOutput.id().getValue(),
                categoryOutput.name(),
                categoryOutput.description(),
                categoryOutput.isActive(),
                categoryOutput.createdAt(),
                categoryOutput.deletedAt() != null ? categoryOutput.deletedAt() : null
        );
    }
}
