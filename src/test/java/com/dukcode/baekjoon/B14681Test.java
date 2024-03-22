package com.dukcode.baekjoon;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B14681Test extends ProblemSolvingTest {

  public B14681Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                12
                5
                """,
            """
                1
                """),
        Arguments.of(
            """
                9
                -13""",
            """
                4
                """),
        Arguments.of(
            """
                1000
                1000""",
            """
                1
                """),
        Arguments.of(
            """
                -1000
                1000""",
            """
                2
                """),
        Arguments.of(
            """
                -1000
                -1000""",
            """
                3
                """),
        Arguments.of(
            """
                1000
                -1000""",
            """
                4
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B14681.main(new String[]{});
  }

}