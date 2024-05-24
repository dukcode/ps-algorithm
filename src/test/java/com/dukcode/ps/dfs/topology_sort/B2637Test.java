package com.dukcode.ps.dfs.topology_sort;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B2637Test extends ProblemSolvingTest {

  public B2637Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                7
                8
                5 1 2
                5 2 2
                7 5 2
                6 5 2
                6 3 3
                6 4 4
                7 6 3
                7 4 5
                """,
            """
                1 16
                2 16
                3 9
                4 17
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B2637.main(new String[]{});
  }

}