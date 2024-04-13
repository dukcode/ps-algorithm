package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B15685Test extends ProblemSolvingTest {

  public B15685Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                3
                3 3 0 1
                4 2 1 3
                4 2 2 1
                """,
            """
                4
                """),
        Arguments.of(
            """
                4
                3 3 0 1
                4 2 1 3
                4 2 2 1
                2 7 3 4
                """,
            """
                11
                """),
        Arguments.of(
            """
                10
                5 5 0 0
                5 6 0 0
                5 7 0 0
                5 8 0 0
                5 9 0 0
                6 5 0 0
                6 6 0 0
                6 7 0 0
                6 8 0 0
                6 9 0 0
                """,
            """
                8
                """),
        Arguments.of(
            """
                4
                50 50 0 10
                50 50 1 10
                50 50 2 10
                50 50 3 10
                """,
            """
                1992
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B15685.main(new String[]{});
  }

}