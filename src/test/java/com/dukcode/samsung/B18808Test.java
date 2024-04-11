package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B18808Test extends ProblemSolvingTest {

  public B18808Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                5 4 4
                3 3
                1 0 1
                1 1 1
                1 0 1
                2 5
                1 1 1 1 1
                0 0 0 1 0
                2 3
                1 1 1
                1 0 1
                3 3
                1 0 0
                1 1 1
                1 0 0
                """,
            """
                18
                """),
        Arguments.of(
            """
                1 3 3
                2 3
                1 0 0
                1 1 1
                1 1
                1
                3 1
                1
                1
                1
                """,
            """
                1
                """),
        Arguments.of(
            """
                2 3 3
                2 3
                1 1 1
                1 0 0
                2 1
                1
                1
                2 2
                1 0
                1 1
                """,
            """
                6
                """),
        Arguments.of(
            """
                4 5 4
                3 3
                1 0 1
                1 1 1
                0 1 0
                2 4
                1 1 1 1
                0 1 0 1
                1 4
                1 1 1 1
                4 2
                1 0
                1 1
                0 1
                0 1
                """,
            """
                17
                """),
        Arguments.of(
            """
                2 2 3
                3 1
                1
                1
                1
                2 3
                1 0 1
                1 1 1
                2 4
                1 0 1 1
                1 1 1 0
                """,
            """
                0
                """),
        Arguments.of(
            """
                6 7 5
                4 6
                1 0 0 1 0 1
                1 1 0 1 0 1
                1 1 1 1 1 1
                0 0 0 1 0 0
                4 3
                0 1 0
                1 1 1
                0 1 1
                1 1 0
                3 6
                1 1 1 1 1 1
                0 0 1 0 0 0
                0 0 1 0 0 0
                6 6
                0 0 1 1 0 0
                1 1 1 1 0 1
                0 0 1 1 1 1
                0 0 1 1 1 1
                1 1 1 0 1 1
                0 1 0 0 1 0
                4 4
                1 1 1 1
                0 0 0 1
                0 0 1 1
                0 0 0 1
                """,
            """
                30
                """),
        Arguments.of(
            """
                6 8 3
                4 5
                0 0 1 1 1
                1 1 1 0 1
                0 0 1 0 1
                0 0 1 0 0
                5 4
                0 0 1 0
                1 1 1 1
                1 1 0 1
                1 1 0 0
                1 1 0 0
                5 6
                0 0 1 1 1 1
                1 1 1 1 0 0
                1 1 1 1 1 0
                0 1 0 1 0 0
                0 1 0 1 0 0
                """,
            """
                22
                """),
        Arguments.of(
            """
                8 6 6
                3 5
                0 1 0 0 0
                1 1 1 1 1
                0 1 0 0 1
                6 3
                0 0 1
                0 0 1
                0 0 1
                1 1 1
                1 0 1
                1 1 1
                6 3
                1 1 0
                1 0 0
                1 1 1
                1 0 1
                1 0 0
                1 0 0
                6 6
                0 0 0 0 1 0
                0 0 1 0 1 0
                0 0 1 0 1 0
                0 1 1 1 1 0
                0 1 1 0 1 1
                1 1 1 0 0 0
                4 5
                0 0 0 0 1
                1 0 0 1 1
                1 1 1 1 0
                1 1 0 1 0
                4 3
                1 1 0
                1 0 0
                1 1 1
                1 1 1
                """,
            """
                29
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B18808.main(new String[]{});
  }

}