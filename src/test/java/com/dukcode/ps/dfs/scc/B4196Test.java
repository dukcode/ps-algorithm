package com.dukcode.ps.dfs.scc;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B4196Test extends ProblemSolvingTest {

  public B4196Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                1
                3 2
                1 2
                2 3
                """,
            """
                1
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B4196.main(new String[]{});
  }

}