package com.dukcode.ps.dfs.scc;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B2150Test extends ProblemSolvingTest {

  public B2150Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                7 9
                1 4
                4 5
                5 1
                1 6
                6 7
                2 7
                7 3
                3 7
                7 2
                """,
            """
                3
                1 4 5 -1
                2 3 7 -1
                6 -1
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B2150.main(new String[]{});
  }

}