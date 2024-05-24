package com.dukcode.ps.dfs.topology_sort;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B1005Test extends ProblemSolvingTest {

  public B1005Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                2
                4 4
                10 1 100 10
                1 2
                1 3
                2 4
                3 4
                4
                8 8
                10 20 1 5 8 7 1 43
                1 2
                1 3
                2 4
                2 5
                3 6
                5 7
                6 7
                7 8
                7
                """,
            """
                120
                39
                """),
        Arguments.of(
            """
                5
                3 2
                1 2 3
                3 2
                2 1
                1
                4 3
                5 5 5 5
                1 2
                1 3
                2 3
                4
                5 10
                100000 99999 99997 99994 99990
                4 5
                3 5
                3 4
                2 5
                2 4
                2 3
                1 5
                1 4
                1 3
                1 2
                4
                4 3
                1 1 1 1
                1 2
                3 2
                1 4
                4
                7 8
                0 0 0 0 0 0 0
                1 2
                1 3
                2 4
                3 4
                4 5
                4 6
                5 7
                6 7
                7
                """,
            """
                6
                5
                399990
                2
                0
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B1005.main(new String[]{});
  }

}