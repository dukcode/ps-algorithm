package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B15683Test extends ProblemSolvingTest {

  public B15683Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                4 6
                0 0 0 0 0 0
                0 0 0 0 0 0
                0 0 1 0 6 0
                0 0 0 0 0 0
                """,
            """
                20
                """),
        Arguments.of(
            """
                6 6
                0 0 0 0 0 0
                0 2 0 0 0 0
                0 0 0 0 6 0
                0 6 0 0 2 0
                0 0 0 0 0 0
                0 0 0 0 0 5
                """,
            """
                15
                """),
        Arguments.of(
            """
                6 6
                1 0 0 0 0 0
                0 1 0 0 0 0
                0 0 1 0 0 0
                0 0 0 1 0 0
                0 0 0 0 1 0
                0 0 0 0 0 1
                """,
            """
                6
                """),
        Arguments.of(
            """
                6 6
                1 0 0 0 0 0
                0 1 0 0 0 0
                0 0 1 5 0 0
                0 0 5 1 0 0
                0 0 0 0 1 0
                0 0 0 0 0 1
                """,
            """
                2
                """),
        Arguments.of(
            """
                1 7
                0 1 2 3 4 5 6
                """,
            """
                0
                """),
        Arguments.of(
            """
                3 7
                4 0 0 0 0 0 0
                0 0 0 2 0 0 0
                0 0 0 0 0 0 4
                """,
            """
                0
                """),
        Arguments.of(
            """
                5 5
                0 0 0 0 0
                0 0 0 0 0
                0 0 1 0 0
                0 0 0 0 0
                0 0 0 0 0
                """,
            """
                22
                """),
        Arguments.of(
            """
                5 5
                0 0 0 0 0
                0 0 0 0 0
                0 0 2 0 0
                0 0 0 0 0
                0 0 0 0 0
                """,
            """
                20
                """),
        Arguments.of(
            """
                5 5
                0 0 0 0 0
                0 0 0 0 0
                0 0 3 0 0
                0 0 0 0 0
                0 0 0 0 0
                """,
            """
                20
                """),
        Arguments.of(
            """
                5 5
                0 0 0 0 0
                0 0 0 0 0
                0 0 4 0 0
                0 0 0 0 0
                0 0 0 0 0
                """,
            """
                18
                """),
        Arguments.of(
            """
                5 5
                0 0 0 0 0
                0 0 0 0 0
                0 0 5 0 0
                0 0 0 0 0
                0 0 0 0 0
                """,
            """
                16
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B15683.main(new String[]{});
  }

}