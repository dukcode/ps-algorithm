package com.dukcode.barkingdog.bfs;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B2178Test extends ProblemSolvingTest {

  public B2178Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                4 6
                101111
                101010
                101011
                111011
                """,
            """
                15
                """),
        Arguments.of(
            """
                4 6
                110110
                110110
                111111
                111101
                """,
            """
                9
                """),
        Arguments.of(
            """
                2 2
                11
                11
                """,
            """
                3
                """),
        Arguments.of(
            """
                2 3
                111
                001
                """,
            """
                4
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B2178.main(new String[]{});
  }

}