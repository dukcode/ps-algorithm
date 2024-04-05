package com.dukcode.barkingdog.topology_sort;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B2252Test extends ProblemSolvingTest {

  public B2252Test() {
    super(2);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                3 2
                1 3
                2 3
                """,
            """
                2 1 3
                """),
        Arguments.of(
            """
                4 2
                4 2
                3 1
                """,
            """
                4 3 2 1
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B2252.main(new String[]{});
  }

}