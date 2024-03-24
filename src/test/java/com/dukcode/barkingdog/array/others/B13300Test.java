package com.dukcode.barkingdog.array.others;

import com.dukcode.barkingdog.array.others.B13300;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B13300Test extends ProblemSolvingTest {

  public B13300Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                16 2
                1 1
                0 1
                1 1
                0 2
                1 2
                0 2
                0 3
                1 3
                1 4
                1 3
                1 3
                0 6
                1 5
                0 5
                1 5
                1 6
                """,
            """
                12
                """),
        Arguments.of(
            """
                3 3
                0 3
                1 5
                0 6
                """,
            """
                3
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B13300.main(new String[]{});
  }

}