package com.dukcode.barkingdog.stack;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B6549Test extends ProblemSolvingTest {

  public B6549Test() {
    super(1);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                7 2 1 4 5 1 3 3
                4 1000 1000 1000 1000
                0
                """,
            """
                8
                4000
                """),
        Arguments.of(
            """
                5 1 1 1 1 1
                0
                """,
            """
                5
                """),
        Arguments.of(
            """
                1 1
                0
                """,
            """
                1
                """),
        Arguments.of(
            "100000 " + "1000000000 ".repeat(100000) + "\n0",
            "100000000000000"
        ),
        Arguments.of(
            """
                1 10
                0""",
            """
                10"""
        ),
        Arguments.of(
            """
                5 1 2 3 4 5
                0""",
            """
                9"""
        ),
        Arguments.of(
            """
                5 1 2 3 2 1
                0""",
            """
                6"""
        ),
        Arguments.of(
            """
                5 1 2 0 2 1
                0""",
            """
                2"""
        ),

        Arguments.of(
            """
                5 10000000 1 1 1 1
                0""",
            """
                10000000"""
        )
    );
  }

  @Override
  protected void runMain() throws Exception {
    B6549.main(new String[]{});
  }

}