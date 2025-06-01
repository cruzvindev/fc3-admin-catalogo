//package com.fullcycle.admin.catalogo.infrastructure.category;
//
//import com.fullcycle.admin.catalogo.domain.category.Category;
//import com.fullcycle.admin.catalogo.MySQLGatewayTest;
//import com.fullcycle.admin.catalogo.infrastructure.TestContainerSetup;
//import com.fullcycle.admin.catalogo.infrastructure.category.persistence.CategoryRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.testcontainers.context.ImportTestcontainers;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@MySQLGatewayTest
//@ImportTestcontainers(TestContainerSetup.class)
//public class CategoryMySQLGatewayTest {
//
//    @Autowired
//    private CategoryMySQLGateway categoryGateway;
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Test
//    @DisplayName("Testando injeção de dependências")
//    public void testInjectDependencies() {
//        assertNotNull(categoryGateway);
//        assertNotNull(categoryRepository);
//    }
//
//    @Test
//    public void givenAValidCategory_whenCallsCreate_shouldReturnANewCategory() {
//        final var expectedName = "Filmes";
//        final var expectedDescription = "A categoria mais assistida";
//        final var expectedIsActive = true;
//
//        final var aCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);
//
//        assertEquals(0, categoryRepository.count());
//
//        final var actualCategory = categoryGateway.create(aCategory);
//
//        assertEquals(aCategory.getId(), actualCategory.getId());
//        assertEquals(1, categoryRepository.count());
//        assertEquals(expectedName, actualCategory.getName());
//        assertEquals(expectedDescription, actualCategory.getDescription());
//        assertEquals(expectedIsActive, actualCategory.active());
//        assertEquals(aCategory.getCreatedAt(), actualCategory.getCreatedAt());
//        assertEquals(aCategory.getUpdatedAt(), actualCategory.getUpdatedAt());
//        assertEquals(aCategory.getDeletedAt(), actualCategory.getDeletedAt());
//        assertNull(actualCategory.getDeletedAt());
//
//        final var actualEntity = categoryRepository.findById(aCategory.getId().getValue()).get();
//
//        assertEquals(aCategory.getId().getValue(), actualEntity.getId());
//        assertEquals(1, categoryRepository.count());
//        assertEquals(expectedName, actualEntity.getName());
//        assertEquals(expectedDescription, actualEntity.getDescription());
//        assertEquals(expectedIsActive, actualEntity.active());
//        assertEquals(aCategory.getCreatedAt(), actualEntity.getCreatedAt());
//        assertEquals(aCategory.getUpdatedAt(), actualEntity.getUpdatedAt());
//        assertEquals(aCategory.getDeletedAt(), actualEntity.getDeletedAt());
//        assertNull(actualEntity.getDeletedAt());
//    }
//
//}
//
//
