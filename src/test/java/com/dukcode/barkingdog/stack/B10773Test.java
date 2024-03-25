package com.dukcode.barkingdog.stack;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B10773Test extends ProblemSolvingTest {

  public B10773Test() {
    super(1);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                4
                3
                0
                4
                0
                """,
            """
                0
                """),

        Arguments.of(
            """
                10
                1
                3
                5
                4
                0
                0
                7
                0
                0
                6
                """,
            """
                7
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B10773.main(new String[]{});
  }

}