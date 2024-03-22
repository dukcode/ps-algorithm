package com.dukcode.baekjoon;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B10926Test extends ProblemSolvingTest {

  public B10926Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of("joonas", "joonas??!"),
        Arguments.of("baekjoon", "baekjoon??!")
    );
  }

  @Override
  protected void runMain() throws Exception {
    B10926.main(new String[]{});
  }

}