package infrastructure;

import org.example.infrastructure.stub_creator.Problem;
import org.junit.gen5.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

public class ProblemTest {
    private static Stream<Arguments> provideCasesForNameGeneration() {
        //noinspection SpellCheckingInspection
        return Stream.of(
            Arguments.of("Test Name", "TestNameTest", "test_name"),
            Arguments.of("Test 123 Name", "Test123NameTest", "test_123_name"),
            Arguments.of("123 test Name", "Problem123TestNameTest", "_123_test_name"),
            Arguments.of("abbreviation HTML", "AbbreviationHtmlTest", "abbreviation_html"),
            Arguments.of("O N e LetterTest", "ONELettertestTest", "o_n_e_lettertest")
        );
    }

    @ParameterizedTest
    @MethodSource("provideCasesForNameGeneration")
    public void testNameGeneration(String title, String expectedTestClassName, String expectedPackageName) throws MalformedURLException {
        URL url = new URL("https://test.test");
        Problem p = new Problem(title, url);

        Assertions.assertTrue(expectedPackageName.equals(p.getPackageName()), p.getPackageName());
        Assertions.assertTrue(expectedTestClassName.equals(p.getTestClassName()), p.getTestClassName());
    }
}
