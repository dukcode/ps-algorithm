package com.dukcode.barkingdog.stack;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B3015Test extends ProblemSolvingTest {

  public B3015Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of("""
                6
                1
                1
                1
                1
                1
                5
                """,
            "15"),
        Arguments.of("""
                6
                5
                5
                5
                5
                5
                1
                """,
            "11"),
        Arguments.of(
            """
                5
                1
                1
                1
                1
                1
                """,
            """
                10
                """),
        Arguments.of(
            """
                5
                5
                1
                2
                3
                4
                """,
            """
                7
                """),
        Arguments.of(
            """
                6
                5
                1
                2
                3
                4
                5
                """,
            """
                9
                """),
        Arguments.of("500000\n" + "1\n".repeat(500000), "124999750000"),
        Arguments.of("1\n1", "0")
    );
  }

  @Override
  protected void runMain() throws Exception {
    B3015.main(new String[]{});
  }

}