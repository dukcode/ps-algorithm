package com.dukcode.barkingdog.stack_advanced;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B2054Test extends ProblemSolvingTest {

  public B2054Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of("(()[[]])([])", "28"),
        Arguments.of("[][]((])", "0"),
        Arguments.of("[][]()", "8"),
        Arguments.of("[[]][]()", "14"),
        Arguments.of("()", "2"),
        Arguments.of("[]", "3"),
        Arguments.of("]", "0"),
        Arguments.of(")", "0"),
        Arguments.of("[", "0"),
        Arguments.of("(", "0"),
        Arguments.of("((((()))))", "32"),
        Arguments.of("(((((())))))", "64")
    );
  }

  @Override
  protected void runMain() throws Exception {
    B2054.main(new String[]{});
  }

}