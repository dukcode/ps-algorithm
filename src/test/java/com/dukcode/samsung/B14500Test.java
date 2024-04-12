package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B14500Test extends ProblemSolvingTest {

  public B14500Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                5 5
                1 2 3 4 5
                5 4 3 2 1
                2 3 4 5 6
                6 5 4 3 2
                1 2 1 2 1
                """,
            """
                19
                """),
        Arguments.of(
            """
                4 5
                1 2 3 4 5
                1 2 3 4 5
                1 2 3 4 5
                1 2 3 4 5
                """,
            """
                20
                """),
        Arguments.of(
            """
                4 10
                1 2 1 2 1 2 1 2 1 2
                2 1 2 1 2 1 2 1 2 1
                1 2 1 2 1 2 1 2 1 2
                2 1 2 1 2 1 2 1 2 1
                """,
            """
                7
                """),
        Arguments.of(
            """
                4 4
                1 1 1 1
                1 1 9 1
                1 1 9 1
                1 1 9 9
                """,
            """
                36
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B14500.main(new String[]{});
  }

}