package com.dukcode.baekjoon.day240323;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B10807Test extends ProblemSolvingTest {

  public B10807Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                11
                1 4 1 2 4 2 4 2 3 4 4
                2
                """,
            """
                3
                """),
        Arguments.of(
            """
                11
                1 4 1 2 4 2 4 2 3 4 4
                5
                """,
            """
                0
                """),
        Arguments.of(
            """
                1
                1
                1
                """,
            """
                1
                """),
        Arguments.of(
            """
                1
                -100
                -100
                """,
            """
                1
                """),
        Arguments.of(
            """
                1
                -100
                -100
                """,
            """
                1
                """),
        Arguments.of(
            """
                1
                100
                100
                """,
            """
                1
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B10807.main(new String[]{});
  }

}