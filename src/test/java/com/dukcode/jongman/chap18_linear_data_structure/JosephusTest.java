package com.dukcode.jongman.chap18_linear_data_structure;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class JosephusTest extends ProblemSolvingTest {

  public JosephusTest() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                6
                6 3
                40 3
                2 100
                2 99
                3 1
                3 2
                """,
            """
                3 5
                11 26
                1 2
                1 2
                2 3
                2 3
                """)

    );
  }

  @Override
  protected void runMain() throws Exception {
    Josephus.main(new String[]{});
  }

}