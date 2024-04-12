package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B14889Test extends ProblemSolvingTest {

  public B14889Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(

        Arguments.of(
            """
                4
                0 1 2 3
                4 0 5 6
                7 1 0 2
                3 4 5 0
                """,
            """
                0
                """),
        Arguments.of(
            """
                6
                0 1 2 3 4 5
                1 0 2 3 4 5
                1 2 0 3 4 5
                1 2 3 0 4 5
                1 2 3 4 0 5
                1 2 3 4 5 0
                """,
            """
                2
                """),
        Arguments.of(
            """
                8
                0 5 4 5 4 5 4 5
                4 0 5 1 2 3 4 5
                9 8 0 1 2 3 1 2
                9 9 9 0 9 9 9 9
                1 1 1 1 0 1 1 1
                8 7 6 5 4 0 3 2
                9 1 9 1 9 1 0 9
                6 5 4 3 2 1 9 0
                """,
            """
                1
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B14889.main(new String[]{});
  }

}