package com.dukcode.barkingdog.stack;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B10828Test extends ProblemSolvingTest {

  public B10828Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                14
                push 1
                push 2
                top
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
                top
                """,
            """
                2
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
                """),
        Arguments.of(
            """
                7
                pop
                top
                push 123
                top
                pop
                top
                pop
                """,
            """
                -1
                -1
                123
                123
                -1
                -1
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B10828.main(new String[]{});
  }

}