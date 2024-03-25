package com.dukcode.barkingdog.stack;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B2493Test extends ProblemSolvingTest {

  public B2493Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                5
                6 9 5 7 4
                """,
            """
                0 0 2 2 4
                """),
        Arguments.of(
            """
                8
                1 2 3 4 5 6 7 8
                """,
            """
                0 0 0 0 0 0 0 0
                """),
        Arguments.of(
            """
                2
                2 2
                """,
            """
                0 0
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B2493.main(new String[]{});
  }

}