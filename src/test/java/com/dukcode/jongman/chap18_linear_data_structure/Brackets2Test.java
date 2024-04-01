package com.dukcode.jongman.chap18_linear_data_structure;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class Brackets2Test extends ProblemSolvingTest {

  public Brackets2Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                3
                ()()
                ({[}])
                ({}[(){}])
                """,
            """
                YES
                NO
                YES
                """),
        Arguments.of(
            """
                4
                (
                )
                ())
                ()(
                """,
            """
                NO
                NO
                NO
                NO
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    Brackets2.main(new String[]{});
  }

}