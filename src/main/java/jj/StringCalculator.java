package jj;

import java.util.Arrays;
import java.util.regex.Matcher;
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
        .mapToInt(Integer::parseInt)
        .filter(n -> n <= 1000)
        .sum();
  }

  private boolean isCustomDelimiter(String input) {

    return input.startsWith("//");
  }

  private String createNewDelimiter(String str) {

    StringBuilder sb = new StringBuilder();

    Pattern p = Pattern.compile("\\[(.*?)\\]");
    Matcher m = p.matcher(str);

    while(m.find()) {
      sb.append(m.group(1)).append("|");
    }
    sb.append(REGEX);

    return sb.toString();
  }
}
