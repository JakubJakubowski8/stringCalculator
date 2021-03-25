package jj;

import java.util.regex.Pattern;

public class StringCalculator {

  private final String REGEX = ",";


  public int add(String input) {

    if (input == null || input.isEmpty()) {
      return 0;
    }

    return sumString(input);
  }

  private int sumString(String input) {

    return Pattern.compile(REGEX)
        .splitAsStream(input)
        .mapToInt(Integer::parseInt).sum();

  }
}
