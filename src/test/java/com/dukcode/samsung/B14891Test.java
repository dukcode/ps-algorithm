package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B14891Test extends ProblemSolvingTest {

  public B14891Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                10101111
                01111101
                11001110
                00000010
                2
                3 -1
                1 1
                """,
            """
                7
                """),
        Arguments.of(
            """
                11111111
                11111111
                11111111
                11111111
                3
                1 1
                2 1
                3 1
                """,
            """
                15
                """),
        Arguments.of(
            """
                10001011
                10000011
                01011011
                00111101
                5
                1 1
                2 1
                3 1
                4 1
                1 -1
                """,
            """
                6
                """),
        Arguments.of(
            """
                10010011
                01010011
                11100011
                01010101
                8
                1 1
                2 1
                3 1
                4 1
                1 -1
                2 -1
                3 -1
                4 -1
                """,
            """
                5
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B14891.main(new String[]{});
  }

}