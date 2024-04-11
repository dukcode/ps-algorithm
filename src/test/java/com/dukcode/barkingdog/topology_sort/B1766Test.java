package com.dukcode.barkingdog.topology_sort;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B1766Test extends ProblemSolvingTest {

  public B1766Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                4 2
                4 2
                3 1
                """,
            """
                3 1 4 2
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B1766.main(new String[]{});
  }

}