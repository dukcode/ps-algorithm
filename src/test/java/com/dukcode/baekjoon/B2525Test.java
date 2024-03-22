package com.dukcode.baekjoon;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B2525Test extends ProblemSolvingTest {

  public B2525Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                14 30
                20""",
            """
                14 50
                """),
        Arguments.of(
            """
                17 40
                80""",
            """
                19 0
                """),
        Arguments.of(
            """
                23 48
                25""",
            """
                0 13
                """),
        Arguments.of(
            """
                23 48
                1000""",
            """
                16 28
                """)

    );
  }

  @Override
  protected void runMain() throws Exception {
    B2525.main(new String[]{});
  }

}