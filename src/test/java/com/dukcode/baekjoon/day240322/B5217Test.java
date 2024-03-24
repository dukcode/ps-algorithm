package com.dukcode.baekjoon.day240322;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B5217Test extends ProblemSolvingTest {

  public B5217Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                4
                2
                3
                4
                5
                """,
            """
                Pairs for 2:
                Pairs for 3: 1 2
                Pairs for 4: 1 3
                Pairs for 5: 1 4, 2 3
                """)

    );
  }

  @Override
  protected void runMain() throws Exception {
    B5217.main(new String[]{});
  }

}