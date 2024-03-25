package com.dukcode.barkingdog.stack;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B6198Test extends ProblemSolvingTest {

  public B6198Test() {
    super(1);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                5
                1
                2
                3
                4
                5
                """,
            """
                0
                """
        ),
        Arguments.of(
            """
                5
                5
                4
                3
                2
                1
                """,
            """
                10
                """
        ),
        Arguments.of(
            """
                1
                1
                """,
            """
                0
                """
        ),
        Arguments.of(
            """
                6
                10
                3
                7
                4
                12
                2
                """,
            """
                5
                """
        ),
        Arguments.of(
            """
                1
                1000000000
                """,
            """
                0
                """
        ),
        Arguments.of("80000\n" + IntStream.rangeClosed(1, 80000)
                .map(i -> 80000 - i + 1).mapToObj(String::valueOf)
                .reduce((str1, str2) -> str1 + "\n" + str2).get(),
            """
                3199960000"""
        )
    );
  }

  @Override
  protected void runMain() throws Exception {
    B6198.main(new String[]{});
  }

}