package com.dukcode.barkingdog.linked_list;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B1406Test extends ProblemSolvingTest {

  public B1406Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                abcd
                3
                P x
                L
                P y
                """,
            """
                abcdyx
                """),
        Arguments.of(
            """
                abc
                9
                L
                L
                L
                L
                L
                P x
                L
                B
                P y
                """,
            """
                yxabc
                """),
        Arguments.of(
            """
                dmih
                11
                B
                B
                P x
                L
                B
                B
                B
                P y
                D
                D
                P z
                """,
            """
                yxz
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B1406.main(new String[]{});
  }

}