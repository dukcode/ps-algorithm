package com.dukcode.barkingdog.deque;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B10866Test extends ProblemSolvingTest {

  public B10866Test() {
    super(1);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                15
                push_back 1
                push_front 2
                front
                back
                size
                empty
                pop_front
                pop_back
                pop_front
                size
                empty
                pop_back
                push_front 3
                empty
                front
                """,
            """
                2
                1
                2
                0
                2
                1
                -1
                0
                1
                -1
                0
                3
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B10866.main(new String[]{});
  }

}