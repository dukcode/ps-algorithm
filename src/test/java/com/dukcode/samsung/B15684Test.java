package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B15684Test extends ProblemSolvingTest {

  public B15684Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                2 0 3
                """,
            """
                0
                """),
        Arguments.of(
            """
                2 1 3
                1 1
                """,
            """
                1
                """),
        Arguments.of(
            """
                5 5 6
                1 1
                3 2
                2 3
                5 1
                5 4
                """,
            """
                3
                """),
        Arguments.of(
            """
                6 5 6
                1 1
                3 2
                1 3
                2 5
                5 5
                """,
            """
                3
                """),
        Arguments.of(
            """
                5 8 6
                1 1
                2 2
                3 3
                4 4
                3 1
                4 2
                5 3
                6 4
                """,
            """
                -1
                """),
        Arguments.of(
            """
                5 12 6
                1 1
                1 3
                2 2
                2 4
                3 1
                3 3
                4 2
                4 4
                5 1
                5 3
                6 2
                6 4
                """,
            """
                -1
                """),
        Arguments.of(
            """
                5 6 6
                1 1
                3 1
                5 2
                4 3
                2 3
                1 4
                """,
            """
                2
                """),
        Arguments.of(
            """
                4 3 4
                1 1
                2 2
                1 3
                """,
            """
                3
                """),
        Arguments.of(
            """
                4 6 7
                1 1
                3 3
                4 2
                5 3
                7 1
                7 3
                """,
            """
                2
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B15684.main(new String[]{});
  }

}