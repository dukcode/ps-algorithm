package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B14502Test extends ProblemSolvingTest {

  public B14502Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                7 7
                2 0 0 0 1 1 0
                0 0 1 0 1 2 0
                0 1 1 0 1 0 0
                0 1 0 0 0 0 0
                0 0 0 0 0 1 1
                0 1 0 0 0 0 0
                0 1 0 0 0 0 0
                """,
            """
                27
                """),
        Arguments.of(
            """
                4 6
                0 0 0 0 0 0
                1 0 0 0 0 2
                1 1 1 0 0 2
                0 0 0 0 0 2
                """,
            """
                9
                """),
        Arguments.of(
            """
                8 8
                2 0 0 0 0 0 0 2
                2 0 0 0 0 0 0 2
                2 0 0 0 0 0 0 2
                2 0 0 0 0 0 0 2
                2 0 0 0 0 0 0 2
                0 0 0 0 0 0 0 0
                0 0 0 0 0 0 0 0
                0 0 0 0 0 0 0 0
                """,
            """
                3
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B14502.main(new String[]{});
  }

}