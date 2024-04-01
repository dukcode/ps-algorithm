package com.dukcode.barkingdog.deque;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B1021Test extends ProblemSolvingTest {

  public B1021Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                10 3
                1 2 3
                """,
            """
                0
                """),
        Arguments.of(
            """
                10 3
                2 9 5
                """,
            """
                8
                """),
        Arguments.of(
            """
                32 6
                27 16 30 11 6 23
                """,
            """
                59
                """),
        Arguments.of(
            """
                10 10
                1 6 3 2 7 9 8 4 10 5
                """,
            """
                14
                """),
        Arguments.of(
            """
                10 10
                1 10 2 9 3 8 4 6 5 7
                """,
            """
                5
                """),
        Arguments.of(
            """
                10 10
                1 2 3 4 5 6 7 8 9 10
                """,
            """
                0
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B1021.main(new String[]{});
  }

}