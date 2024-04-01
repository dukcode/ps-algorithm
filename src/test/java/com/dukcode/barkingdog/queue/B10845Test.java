package com.dukcode.barkingdog.queue;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B10845Test extends ProblemSolvingTest {

  public B10845Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                15
                push 1
                push 2
                front
                back
                size
                empty
                pop
                pop
                pop
                size
                empty
                pop
                push 3
                empty
                front
                """,
            """
                1
                2
                2
                0
                1
                2
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
    B10845.main(new String[]{});
  }

}