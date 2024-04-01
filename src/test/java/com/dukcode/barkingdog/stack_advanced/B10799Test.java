package com.dukcode.barkingdog.stack_advanced;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B10799Test extends ProblemSolvingTest {

  public B10799Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of("()(((()())(())()))(())", "17"),
        Arguments.of("(((()(()()))(())()))(()())", "24"),
        Arguments.of("()", "0"),
        Arguments.of("(())", "2"),
        Arguments.of("((()))", "4"),
        Arguments.of("((())())", "5")
    );
  }

  @Override
  protected void runMain() throws Exception {
    B10799.main(new String[]{});
  }

}