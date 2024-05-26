package com.dukcode.ps.dfs.cut_vertex;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B11266Test extends ProblemSolvingTest {

  public B11266Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                7 7
                1 4
                4 5
                5 1
                1 6
                6 7
                2 7
                7 3
                """,
            """
                3
                1 6 7
                """),
        Arguments.of(
            """
                2 0
                """,
            """
                0
                """),
        Arguments.of(
            """
                4 2
                1 2
                2 3
                """,
            """
                1
                2
                """),
        Arguments.of(
            """
                3 3
                1 2
                2 3
                3 1
                """,
            """
                0
                """),
        Arguments.of(
            """
                6 7
                1 2
                2 3
                3 4
                4 5
                5 1
                5 6
                6 2
                """,
            """
                0
                """),
        Arguments.of(
            """
                6 7
                1 2
                2 3
                3 4
                4 1
                4 5
                5 6
                6 4
                """,
            """
                1
                4
                """),
        Arguments.of(
            """
                4 4
                 1 2
                 2 4
                 1 3
                 3 4
                """,
            """
                0
                """),
        Arguments.of(
            """
                20 15
                6 2
                16 1
                6 1
                14 3
                20 19
                8 17
                3 7
                1 9
                14 20
                2 20
                19 7
                2 16
                11 8
                6 18
                15 11
                """,
            """
                6
                1 2 6 8 11 20
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B11266.main(new String[]{});
  }

}