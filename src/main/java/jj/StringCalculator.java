package jj;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

  private final String REGEX = "[,\n]";

  public int add(String input) {

    String delimiter = REGEX;

    if (input == null || input.isEmpty()) {
      return 0;
    }

    if (isCustomDelimiter(input)) {
      String[] splitted = splitString(input);

      delimiter = createNewDelimiter(splitted[0]);
      input = splitted[1];
    }

    findNegatives(input, delimiter);

    return add(input, delimiter);
  }

  private int add(String input, String delimiter) {

    return Pattern.compile(delimiter)
        .splitAsStream(input)
        .mapToInt(Integer::parseInt)
        .filter(n -> n >= 0 & n <= 1000)
        .sum();
  }

  private void findNegatives(String input, String delimiter) {

    List<Integer> negatives = Pattern.compile(delimiter)
        .splitAsStream(input)
        .mapToInt(Integer::parseInt)
        .filter(n -> n < 0)
        .boxed()
        .collect(Collectors.toList());

    if (!negatives.isEmpty()) {
      throw new IllegalArgumentException(
          "Negatives are not allowed " + String.join(",", negatives.toString()));
    }

  }

  private boolean isCustomDelimiter(String input) {

    return input.startsWith("//");
  }

  private String[] splitString(String input) {
    return Arrays.stream(input.split("[\n]", 2))
        .toArray(String[]::new);
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
