package com.dukcode.barkingdog.stack_advanced;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B9012Test extends ProblemSolvingTest {

  public B9012Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                6
                (())())
                (((()())()
                (()())((()))
                ((()()(()))(((())))()
                ()()()()(()()())()
                (()((())()(
                """,
            """
                NO
                NO
                YES
                NO
                YES
                NO
                """),
        Arguments.of(
            """
                3
                ((
                ))
                ())(()
                """,
            """
                NO
                NO
                NO
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B9012.main(new String[]{});
  }

}