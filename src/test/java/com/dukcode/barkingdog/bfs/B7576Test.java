package com.dukcode.barkingdog.bfs;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B7576Test extends ProblemSolvingTest {

  public B7576Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                6 4
                0 0 0 0 0 0
                0 0 0 0 0 0
                0 0 0 0 0 0
                0 0 0 0 0 1
                """,
            """
                8
                """),
        Arguments.of(
            """
                6 4
                0 -1 0 0 0 0
                -1 0 0 0 0 0
                0 0 0 0 0 0
                0 0 0 0 0 1
                """,
            """
                -1
                """),
        Arguments.of(
            """
                6 4
                1 -1 0 0 0 0
                0 -1 0 0 0 0
                0 0 0 0 -1 0
                0 0 0 0 -1 1
                """,
            """
                6
                """),
        Arguments.of(
            """
                5 5
                -1 1 0 0 0
                0 -1 -1 -1 0
                0 -1 -1 -1 0
                0 -1 -1 -1 0
                0 0 0 0 0
                """,
            """
                14
                """),
        Arguments.of(
            """
                2 2
                1 -1
                -1 1
                """,
            """
                0
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B7576.main(new String[]{});
  }

}