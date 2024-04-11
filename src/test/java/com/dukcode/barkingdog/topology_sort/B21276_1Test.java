package com.dukcode.barkingdog.topology_sort;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B21276_1Test extends ProblemSolvingTest {

  public B21276_1Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                3
                a b c
                3
                a b
                a c
                b c
                """,
            """
                1
                c
                a 0
                b 1 a
                c 1 b
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B21276_1.main(new String[]{});
  }

}