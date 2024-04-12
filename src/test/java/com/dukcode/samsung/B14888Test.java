package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B14888Test extends ProblemSolvingTest {

  public B14888Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                2
                5 6
                0 0 1 0
                """,
            """
                30
                30
                """),
        Arguments.of(
            """
                3
                3 4 5
                1 0 1 0
                """,
            """
                35
                17
                """),

        Arguments.of(
            """
                6
                1 2 3 4 5 6
                2 1 1 1
                """,
            """
                54
                -24
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B14888.main(new String[]{});
  }

}