package com.dukcode.baekjoon;

import com.dukcode.baekjoon.day240322.B4101;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B4101Test extends ProblemSolvingTest {

  public B4101Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                1 19
                4 4
                23 14
                0 0
                """,
            """
                No
                No
                Yes
                """),
        Arguments.of(
            """
                0 0
                """,
            """
                """),

        Arguments.of(
            """
                1000000 1000000
                1000000 999999
                1 1
                0 0
                """,
            """
                No
                Yes
                No
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B4101.main(new String[]{});
  }

}