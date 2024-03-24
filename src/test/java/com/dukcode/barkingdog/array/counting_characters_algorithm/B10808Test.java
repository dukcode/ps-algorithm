package com.dukcode.barkingdog.array.counting_characters_algorithm;

import com.dukcode.barkingdog.array.counting_characters_algorithm.B10808;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B10808Test extends ProblemSolvingTest {

  public B10808Test() {
    super(1);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of("baekjoon",
            "1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0"),
        Arguments.of("abcdefghijklmnopqrstuvwxyz",
            "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1")
    );
  }

  @Override
  protected void runMain() throws Exception {
    B10808.main(new String[]{});
  }

}