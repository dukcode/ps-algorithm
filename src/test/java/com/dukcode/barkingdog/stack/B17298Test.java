package com.dukcode.barkingdog.stack;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B17298Test extends ProblemSolvingTest {

  public B17298Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                4
                5 4 3 2
                """,
            """
                -1 -1 -1 -1
                """),
        Arguments.of(
            """
                4
                2 3 4 5
                """,
            """
                3 4 5 -1
                """),
        Arguments.of(
            """
                4
                3 5 2 7
                """,
            """
                5 7 7 -1
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B17298.main(new String[]{});
  }

}