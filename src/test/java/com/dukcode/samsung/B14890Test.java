package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B14890Test extends ProblemSolvingTest {

  public B14890Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                6 2
                3 3 3 3 3 3
                2 3 3 3 3 3
                2 2 2 3 2 3
                1 1 1 2 2 2
                1 1 1 3 3 1
                1 1 2 3 3 2
                """,
            """
                3
                """),
        Arguments.of(
            """
                6 2
                3 2 1 1 2 3
                3 2 2 1 2 3
                3 2 2 2 3 3
                3 3 3 3 3 3
                3 3 3 3 2 2
                3 3 3 3 2 2
                """,
            """
                7
                """),
        Arguments.of(
            """
                6 3
                3 2 1 1 2 3
                3 2 2 1 2 3
                3 2 2 2 3 3
                3 3 3 3 3 3
                3 3 3 3 2 2
                3 3 3 3 2 2
                """,
            """
                3
                """),
        Arguments.of(
            """
                6 1
                3 2 1 1 2 3
                3 2 2 1 2 3
                3 2 2 2 3 3
                3 3 3 3 3 3
                3 3 3 3 2 2
                3 3 3 3 2 2
                """,
            """
                11
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B14890.main(new String[]{});
  }

}