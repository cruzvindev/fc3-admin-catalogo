package genre;

import com.fullcycle.admin.catalogo.domain.exceptions.DomainException;
import com.fullcycle.admin.catalogo.domain.genre.Genre;
import com.fullcycle.admin.catalogo.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenreTest {

    @Test
    public void givenValidParams_whenCallNewGenre_shouldInstantiateAGenre(){
        final var expectedName = "Action";
        final var expectedIsActive = true;
        final var expectedCategories = 0;

        final var actualGenre = Genre.newGenre(expectedName, expectedIsActive);

        Assertions.assertNotNull(actualGenre);
        Assertions.assertNotNull(actualGenre.getId());
        Assertions.assertEquals(expectedName, actualGenre.getName());
        Assertions.assertEquals(expectedIsActive, actualGenre.isActive());
        Assertions.assertEquals(expectedCategories, actualGenre.getCategories().size());
        Assertions.assertNotNull(actualGenre.getCreatedAt());
        Assertions.assertNotNull(actualGenre.getUpdatedAt());
        Assertions.assertNull(actualGenre.getDeletedAt());
    }

    @Test
    public void givenInvalidNullName_whenCallNewGenreAndValidate_shouldReceiveError(){
        final String expectedName = null;
        final var expectedIsActive = true;
        final var expectedErrorCount = 0;
        final var expectedErrorMessage = "'name' should not be null";

        final var actualGenre = Genre.newGenre(expectedName, expectedIsActive);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> {
            actualGenre.validate(new ThrowsValidationHandler());
        });

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());
    }

    @Test
    public void givenInvalidEmptyName_whenCallNewGenreAndValidate_shouldReceiveError(){
        final String expectedName = " ";
        final var expectedIsActive = true;
        final var expectedErrorCount = 0;
        final var expectedErrorMessage = "'name' should not be empty";

        final var actualGenre = Genre.newGenre(expectedName, expectedIsActive);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> {
            actualGenre.validate(new ThrowsValidationHandler());
        });

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());
    }

    @Test
    public void givenInvalidNameWithLengthGreaterThan255_whenCallNewGenreAndValidate_shouldReceiveError(){
        final String expectedName = """
                Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se a estrutura atual da organização
                auxilia a preparação e a composição dos índices pretendidos. No entanto, não podemos esquecer que o início 
                da atividade geral de formação de atitudes facilita a criação das novas proposições. As experiências acumuladas
                demonstram que a hegemonia do ambiente político pode nos levar a considerar a reestruturação do levantamento das 
                variáveis envolvidas. Nunca é demais lembrar o peso e o significado destes problemas, uma vez que a constante divulgação 
                das informações obstaculiza a apreciação da importância do processo de comunicação como um todo.
                """;
        final var expectedIsActive = true;
        final var expectedErrorCount = 0;
        final var expectedErrorMessage = "'name' must be between 1 and 255 characters";

        final var actualGenre = Genre.newGenre(expectedName, expectedIsActive);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> {
            actualGenre.validate(new ThrowsValidationHandler());
        });

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());
    }
}
