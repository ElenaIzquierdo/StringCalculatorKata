package converters;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ListStringNumbersToListIntNumbersConverterTest {

    private final ListStringNumbersToListIntNumbersConverter converter = new ListStringNumbersToListIntNumbersConverter();

    @Test
    void shouldReturnListOfIntegersFromNumbersSeparatedByComa() {
        List<Integer> result = converter.convertFrom("1,2,3");

        assertEquals(List.of(1,2,3), result);
    }

    @Test
    void shouldIgnoreNewLine() {
        List<Integer> result = converter.convertFrom("1\n2,3");

        assertEquals(List.of(1,2,3), result);
    }

    @Test
    void shouldAcceptOtherDelimeters()  {
        List<Integer> result = converter.convertFrom("//[;]\\n1;2");

        assertEquals(List.of(1,2), result);
    }

    @Test
    void shouldAcceptDelimetersLongerThanOneCharacter()  {
        List<Integer> result = converter.convertFrom("//[***]\\n1***2***3");

        assertEquals(List.of(1,2,3), result);
    }
}