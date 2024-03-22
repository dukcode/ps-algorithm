package com.dukcode.baekjoon;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B2558Test extends ProblemSolvingTest {

  public B2558Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                1
                2""",
            """
                3
                """),
        Arguments.of(
            """
                1
                1""",
            """
                2
                """),
        Arguments.of(
            """
                1
                9""",
            """
                10
                """),
        Arguments.of(
            """
                9
                1""",
            """
                10
                """),
        Arguments.of(
            """
                9
                9""",
            """
                18
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B2558.main(new String[]{});
  }

}