package com.dukcode.barkingdog.array.counting_characters_algorithm;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B1475Test extends ProblemSolvingTest {

  public B1475Test() {
    super(2);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of("9999", "2"),
        Arguments.of("122", "2"),
        Arguments.of("888888", "6"),
        Arguments.of("1000000", "6"),
        Arguments.of("999999", "3"),
        Arguments.of("666666", "3"),
        Arguments.of("1", "1")
    );
  }

  @Override
  protected void runMain() throws Exception {
    B1475.main(new String[]{});
  }

}