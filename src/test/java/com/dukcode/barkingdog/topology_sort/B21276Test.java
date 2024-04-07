package com.dukcode.barkingdog.topology_sort;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B21276Test extends ProblemSolvingTest {

  public B21276Test() {
    super(1);
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
    B21276.main(new String[]{});
  }

}