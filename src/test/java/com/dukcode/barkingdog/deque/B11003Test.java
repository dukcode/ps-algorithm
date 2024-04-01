package com.dukcode.barkingdog.deque;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B11003Test extends ProblemSolvingTest {

  public B11003Test() {
    super(2);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                12 3
                1 5 2 3 6 2 3 7 3 5 2 6
                """,
            """
                1 1 1 2 2 2 2 2 3 3 2 2
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B11003.main(new String[]{});
  }

}