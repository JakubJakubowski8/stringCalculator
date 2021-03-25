package jj;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;


public class StringCalculatorTest {

  private StringCalculator stringCalculator = new StringCalculator();

  @Test
  public void shouldReturn0ForEmptyInput() {

    String input = "";
    int expectedResult = 0;

    int result = stringCalculator.add(input);

    assertThat(result).isEqualTo(expectedResult);
  }

  @Test
  public void shouldReturn1ForInput1() {

    String input = "1";
    int expectedResult = 1;

    int result = stringCalculator.add(input);

    assertThat(result).isEqualTo(expectedResult);
  }

  @Test
  public void shouldReturn2ForInput2() {

    String input = "2";
    int expectedResult = 2;

    int result = stringCalculator.add(input);

    assertThat(result).isEqualTo(expectedResult);
  }

  @Test
  public void shouldReturn3ForInput1Coma2() {

    String input = "1,2";
    int expectedResult = 3;

    int result = stringCalculator.add(input);

    assertThat(result).isEqualTo(expectedResult);
  }

  @Test
  public void shouldReturn7ForLongComaSeparatedString() {

    String input = "1,2,2,1,1";
    int expectedResult = 7;

    int result = stringCalculator.add(input);

    assertThat(result).isEqualTo(expectedResult);
  }

  @Test
  public void shouldReturn3For1NewLine2() {

    String input = "1\n2";
    int expectedResult = 3;

    int result = stringCalculator.add(input);

    assertThat(result).isEqualTo(expectedResult);
  }

  @Test
  public void shouldReturn6For1NewLine2Coma3() {

    String input = "1\n2,3";
    int expectedResult = 6;

    int result = stringCalculator.add(input);

    assertThat(result).isEqualTo(expectedResult);
  }

  @Test
  public void shouldReturn6ForStringBlock() {

    String input = """
                    1
                    2,3 
                    """;
    int expectedResult = 6;

    int result = stringCalculator.add(input);

    assertThat(result).isEqualTo(expectedResult);
  }
}

