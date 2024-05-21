package com.dukcode.barkingdog.array.counting_characters_algorithm;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B2577Test extends ProblemSolvingTest {

  public B2577Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                150
                266
                427
                                
                """,
            """
                3
                1
                0
                2
                0
                0
                0
                2
                0
                0
                """),
        Arguments.of(
            """
                100
                100
                100
                                
                """,
            """
                6
                1
                0
                0
                0
                0
                0
                0
                0
                0
                """),
        Arguments.of(
            """
                999
                999
                999
                                
                """,
            """
                2
                0
                1
                0
                0
                0
                0
                1
                0
                5
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B2577.main(new String[]{});
  }

}