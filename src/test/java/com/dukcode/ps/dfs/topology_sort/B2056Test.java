package com.dukcode.ps.dfs.topology_sort;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B2056Test extends ProblemSolvingTest {

  public B2056Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                7
                5 0
                1 1 1
                3 1 2
                6 1 1
                1 2 2 4
                8 2 2 4
                4 3 3 5 6
                """,
            """
                23
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B2056.main(new String[]{});
  }

}