package com.dukcode.barkingdog.deque;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B5430Test extends ProblemSolvingTest {

  public B5430Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                1
                R
                2
                [1,2]
                """,
            """
                [2,1]
                """),
        Arguments.of(
            """
                4
                RDD
                4
                [1,2,3,4]
                DD
                1
                [42]
                RRD
                6
                [1,1,2,3,5,8]
                D
                0
                []
                """,
            """
                [2,1]
                error
                [1,2,3,5,8]
                error
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B5430.main(new String[]{});
  }

}