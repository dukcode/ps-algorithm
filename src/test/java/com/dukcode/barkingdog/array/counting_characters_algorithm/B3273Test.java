package com.dukcode.barkingdog.array.counting_characters_algorithm;

import com.dukcode.barkingdog.array.counting_characters_algorithm.B3273;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B3273Test extends ProblemSolvingTest {

  public B3273Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                9
                5 12 7 10 9 1 2 3 11
                13
                """,
            """
                3
                """),
        Arguments.of(
            """
                3
                1 1 100
                101
                """,
            """
                2
                """),
        Arguments.of(
            """
                3
                100 101 102
                101
                """,
            """
                0
                """),
        Arguments.of(
            """
                5
                1 2 3 4 5
                2
                """,
            """
                0
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B3273.main(new String[]{});
  }

}