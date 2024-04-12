package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B14501Test extends ProblemSolvingTest {

  public B14501Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                7
                3 10
                5 20
                1 10
                1 20
                2 15
                4 40
                2 200
                """,
            """
                45
                """),
        Arguments.of(
            """
                10
                1 1
                1 2
                1 3
                1 4
                1 5
                1 6
                1 7
                1 8
                1 9
                1 10
                """,
            """
                55
                """),
        Arguments.of(
            """
                10
                5 10
                5 9
                5 8
                5 7
                5 6
                5 10
                5 9
                5 8
                5 7
                5 6
                """,
            """
                20
                """),
        Arguments.of(
            """
                10
                5 50
                4 40
                3 30
                2 21
                1 10
                1 10
                2 20
                3 30
                4 40
                5 50
                """,
            """
                90
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B14501.main(new String[]{});
  }

}