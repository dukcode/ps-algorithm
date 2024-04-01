package com.dukcode.barkingdog.stack_advanced;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B3986Test extends ProblemSolvingTest {

  public B3986Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                3
                ABAB
                AABB
                ABBA
                """,
            """
                2
                """),
        Arguments.of(
            """
                3
                AAA
                AA
                AB
                """,
            """
                1
                """),
        Arguments.of(
            """
                1
                ABBABB
                """,
            """
                1
                """),
        Arguments.of(
            """
                1
                A
                """,
            """
                0
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B3986.main(new String[]{});
  }

}