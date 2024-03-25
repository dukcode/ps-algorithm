package com.dukcode.barkingdog.stack;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B1874Test extends ProblemSolvingTest {

  public B1874Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                8
                4
                3
                6
                8
                7
                5
                2
                1
                """,
            """
                +
                +
                +
                +
                -
                -
                +
                +
                -
                +
                +
                -
                -
                -
                -
                -
                """),

        Arguments.of(
            """
                5
                1
                2
                5
                3
                4
                """,
            """
                NO
                """)

    );
  }

  @Override
  protected void runMain() throws Exception {
    B1874.main(new String[]{});
  }

}