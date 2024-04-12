package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B14503Test extends ProblemSolvingTest {

  public B14503Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                3 3
                1 1 0
                1 1 1
                1 0 1
                1 1 1
                """,
            """
                1
                """),
        Arguments.of(
            """
                11 10
                7 4 0
                1 1 1 1 1 1 1 1 1 1
                1 0 0 0 0 0 0 0 0 1
                1 0 0 0 1 1 1 1 0 1
                1 0 0 1 1 0 0 0 0 1
                1 0 1 1 0 0 0 0 0 1
                1 0 0 0 0 0 0 0 0 1
                1 0 0 0 0 0 0 1 0 1
                1 0 0 0 0 0 1 1 0 1
                1 0 0 0 0 0 1 1 0 1
                1 0 0 0 0 0 0 0 0 1
                1 1 1 1 1 1 1 1 1 1
                """,
            """
                57
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B14503.main(new String[]{});
  }

}