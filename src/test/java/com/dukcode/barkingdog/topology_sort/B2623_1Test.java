package com.dukcode.barkingdog.topology_sort;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B2623_1Test extends ProblemSolvingTest {

  public B2623_1Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                6 3
                3 1 4 3
                4 6 2 5 4
                2 2 3
                """,
            """
                1
                6
                2
                5
                4
                3
                """),
        Arguments.of(
            """
                3 3
                2 1 2
                2 2 3
                2 2 3
                """,
            """
                1
                2
                3
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B2623_1.main(new String[]{});
  }

}