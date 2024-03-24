package com.dukcode.barkingdog.linked_list;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B5397Test extends ProblemSolvingTest {

  public B5397Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                2
                <<BP<A>>Cd-
                ThIsIsS3Cr3t
                """,
            """
                BAPC
                ThIsIsS3Cr3t
                """)

    );
  }

  @Override
  protected void runMain() throws Exception {
    B5397.main(new String[]{});
  }

}