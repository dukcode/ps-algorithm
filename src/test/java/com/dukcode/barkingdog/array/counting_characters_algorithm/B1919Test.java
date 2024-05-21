package com.dukcode.barkingdog.array.counting_characters_algorithm;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B1919Test extends ProblemSolvingTest {

  public B1919Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                aabbcc
                xxyybb
                """,
            """
                8
                """),
        Arguments.of(
            """
                bbbbbb
                aaaaaa
                """,
            """
                12
                """),
        Arguments.of(
            """
                a
                a
                """,
            """
                0
                """),
        Arguments.of(
            """
                a
                b
                """,
            """
                2
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B1919.main(new String[]{});
  }

}