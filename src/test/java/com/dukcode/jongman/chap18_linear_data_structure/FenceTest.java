package com.dukcode.jongman.chap18_linear_data_structure;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class FenceTest extends ProblemSolvingTest {

  public FenceTest() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                3
                7
                7 1 5 9 6 7 3
                7
                1 4 4 4 4 1 1
                4
                1 8 2 2
                """,
            """
                20
                16
                8
                """),
        Arguments.of(
            """
                1
                1
                100
                """,
            """
                100
                """),
        Arguments.of(
            """
                1
                5
                5 5 5 5 5
                """,
            """
                25
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    Fence.main(new String[]{});
  }

}