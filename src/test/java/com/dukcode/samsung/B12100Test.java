package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B12100Test extends ProblemSolvingTest {

  public B12100Test() {
    super(1);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                3
                2 2 2
                4 4 4
                8 8 8
                """,
            """
                16
                """),
        Arguments.of(
            """
                4
                32 64 0 0
                4 128 256 0
                128 4 16 2
                4 128 32 32
                """,
            """
                256
                """),
        Arguments.of(
            """
                4
                2 16 16 0
                32 16 4 1
                4 16 32 0
                2 0 8 8
                """,
            """
                128
                """),
        Arguments.of(
            """
                4
                0 8 1 1
                8 0 1 4
                8 0 8 32
                1 32 32 0
                """,
            """
                128
                """),
        Arguments.of(
            """
                4
                2 32 16 8
                4 0 4 4
                0 1 8 4
                32 32 0 32
                """,
            """
                64
                """),
        Arguments.of(
            """
                4
                0 64 2 1024
                2 512 8 0
                0 32 512 256
                64 64 8 2
                """,
            """
                2048
                """),
        Arguments.of(
            """
                10
                0 0 64 32 32 0 0 0 0 0
                0 32 32 64 0 0 0 0 0 0
                0 0 128 0 0 0 0 0 0 0
                64 64 128 0 0 0 0 0 0 0
                0 0 64 32 32 0 0 0 0 0
                0 32 32 64 0 0 0 0 0 0
                0 0 128 0 0 0 0 0 0 0
                64 64 128 0 0 0 0 0 0 0
                128 32 0 0 0 0 0 0 0 0
                0 0 128 0 0 0 0 0 0 0
                """,
            """
                1024
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B12100.main(new String[]{});
  }

}