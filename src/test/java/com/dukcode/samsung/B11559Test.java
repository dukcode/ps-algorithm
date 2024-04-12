package com.dukcode.samsung;

import com.dukcode.barkingdog.simulation.B11559;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B11559Test extends ProblemSolvingTest {

  public B11559Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                ......
                ......
                ......
                ......
                ......
                ......
                ......
                ......
                .Y....
                .YG...
                RRYG..
                RRYGG.
                """,
            """
                3
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B11559.main(new String[]{});
  }

}