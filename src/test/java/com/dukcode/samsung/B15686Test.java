package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B15686Test extends ProblemSolvingTest {

  public B15686Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                5 3
                0 0 1 0 0
                0 0 2 0 1
                0 1 2 0 0
                0 0 1 0 0
                0 0 0 0 2
                """,
            """
                5
                """),
        Arguments.of(
            """
                5 2
                0 2 0 1 0
                1 0 1 0 0
                0 0 0 0 0
                2 0 0 1 1
                2 2 0 1 2
                """,
            """
                10
                """),
        Arguments.of(
            """
                5 1
                1 2 0 0 0
                1 2 0 0 0
                1 2 0 0 0
                1 2 0 0 0
                1 2 0 0 0
                """,
            """
                11
                """),
        Arguments.of(
            """
                5 1
                1 2 0 2 1
                1 2 0 2 1
                1 2 0 2 1
                1 2 0 2 1
                1 2 0 2 1
                """,
            """
                32
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B15686.main(new String[]{});
  }

}