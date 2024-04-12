package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B13458Test extends ProblemSolvingTest {

  public B13458Test() {
    super(2);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                1
                1
                1 1
                """,
            """
                1
                """),
        Arguments.of(
            """
                3
                3 4 5
                2 2
                """,
            """
                7
                """),
        Arguments.of(
            """
                5
                1000000 1000000 1000000 1000000 1000000
                5 7
                """,
            """
                714290
                """),
        Arguments.of(
            """
                5
                10 9 10 9 10
                7 20
                """,
            """
                10
                """),
        Arguments.of(
            """
                5
                10 9 10 9 10
                7 2
                """,
            """
                13
                """),
        Arguments.of(
            """
                1
                1
                99 100
                """,
            """
                1
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B13458.main(new String[]{});
  }

}