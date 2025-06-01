package com.fullcycle.admin.catalogo.application.category.delete;

import com.fullcycle.admin.catalogo.IntegrationTest;
import com.fullcycle.admin.catalogo.domain.category.Category;
import com.fullcycle.admin.catalogo.domain.category.CategoryGateway;
import com.fullcycle.admin.catalogo.domain.category.CategoryID;
import com.fullcycle.admin.catalogo.infrastructure.category.persistence.CategoryJpaEntity;
import com.fullcycle.admin.catalogo.infrastructure.category.persistence.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@IntegrationTest
public class DeleteCategoryUseCaseIT {

    @Autowired
    private DeleteCategoryUseCase useCase;

    @Autowired
    private CategoryRepository categoryRepository;

    @MockitoSpyBean
    private CategoryGateway categoryGateway;

    @Test
    public void givenAValidId_whenCallsDeleteCategory_shouldBeOk(){
        final var aCategory = Category.newCategory("Filmes", "A categoria mais assistida", true);
        final var expectedId = aCategory.getId();

        save(aCategory);

        assertEquals(1, categoryRepository.count());

        assertDoesNotThrow(() -> useCase.execute(expectedId.getValue()));

        assertEquals(0, categoryRepository.count());
    }

    @Test
    public void givenAInvalidId_whenCallsDeleteCategory_shouldBeOk(){
        final var expectedId = CategoryID.from("123");

        assertEquals(0, categoryRepository.count());
        assertDoesNotThrow(() -> useCase.execute(expectedId.getValue()));
        assertEquals(0, categoryRepository.count());
    }

    @Test
    public void givenAValidId_whenGatewayThrowsError_shouldBeReturnException(){
        final var aCategory = Category.newCategory("Filmes", "A categoria mais assistida", true);
        final var expectedId = aCategory.getId();

        doThrow(new IllegalStateException("Gateway error"))
                .when(categoryGateway).deleteById(eq(expectedId));

        assertThrows(IllegalStateException.class, () -> useCase.execute(expectedId.getValue()));
        verify(categoryGateway, times(1)).deleteById(eq(expectedId));

    }

    private void save(final Category... aCategory) {
        categoryRepository.saveAllAndFlush(
                Arrays.stream(aCategory)
                        .map(CategoryJpaEntity::from)
                        .toList()
        );
    }

    private Instant truncateDate(final Instant instant) {
        return instant.truncatedTo(ChronoUnit.SECONDS);
    }
}
