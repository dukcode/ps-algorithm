package com.dukcode.baekjoon.others;

import com.dukcode.baekjoon.others.B1330;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B1330Test extends ProblemSolvingTest {

  public B1330Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of("1 2", "<"),
        Arguments.of("10 2", ">"),
        Arguments.of("-10000 -10000", "=="),
        Arguments.of("10000 10000", "=="),
        Arguments.of("5 5", "==")
    );
  }

  @Override
  protected void runMain() throws Exception {
    B1330.main(new String[]{});
  }

}