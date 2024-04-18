package com.dukcode.barkingdog.bfs;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B1926Test extends ProblemSolvingTest {

  public B1926Test() {
    super(2);
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
                """),
        Arguments.of(
            """
                1 1
                1
                """,
            """
                1
                1
                """),
        Arguments.of(
            """
                1 1
                0
                """,
            """
                0
                0
                """),
        Arguments.of(
            """
                2 2
                1 0
                0 1
                """,
            """
                2
                1
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B1926.main(new String[]{});
  }

}