package jj;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {

  private final String REGEX = "[,\n]";

  public int add(String input) {

    String delimiter = REGEX;

    if (input == null || input.isEmpty()) {
      return 0;
    }

    if (isCustomDelimiter(input)) {
      String[] stringArray = Arrays.stream(input.split("[\n]", 2))
          .toArray(String[]::new);

      delimiter = createNewDelimiter(stringArray[0]);
      input = stringArray[1];
    }

    return add(input, delimiter);
  }

  private int add(String input, String delimiter) {

    return Pattern.compile(delimiter)
        .splitAsStream(input)
        .mapToInt(Integer::parseInt).sum();
  }

  private boolean isCustomDelimiter(String input) {

    return input.startsWith("//");
  }

  private String createNewDelimiter(String str) {
    StringBuffer sb = new StringBuffer(str);

    sb.delete(str.length() - 1, str.length());
    sb.delete(0, 3);

    sb.append("|" + REGEX);

    return sb.toString();
  }
}
