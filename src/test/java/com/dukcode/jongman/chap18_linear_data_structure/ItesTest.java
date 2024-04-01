package com.dukcode.jongman.chap18_linear_data_structure;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class ItesTest extends ProblemSolvingTest {

  public ItesTest() {
    super(10);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                3
                8791 20
                5265 5000
                3578452 5000000
                """,
            """
                1
                4
                1049
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    Ites.main(new String[]{});
  }

}