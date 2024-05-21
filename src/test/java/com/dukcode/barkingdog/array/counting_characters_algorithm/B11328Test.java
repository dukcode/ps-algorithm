package com.dukcode.barkingdog.array.counting_characters_algorithm;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B11328Test extends ProblemSolvingTest {

  public B11328Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                5
                a a
                ab ba
                ring gnir
                newt twan
                aaaa aaaa
                """,
            """
                Possible
                Possible
                Possible
                Impossible
                Possible
                """)

    );
  }

  @Override
  protected void runMain() throws Exception {
    B11328.main(new String[]{});
  }

}