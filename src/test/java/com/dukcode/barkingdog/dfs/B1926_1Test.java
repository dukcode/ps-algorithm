package com.dukcode.barkingdog.dfs;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B1926_1Test extends ProblemSolvingTest {

  public B1926_1Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                6 5
                1 1 0 1 1
                0 1 1 0 0
                0 0 0 0 0
                1 0 1 1 1
                0 0 1 1 1
                0 0 1 1 1
                """,
            """
                4
                9
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B1926_1.main(new String[]{});
  }

}