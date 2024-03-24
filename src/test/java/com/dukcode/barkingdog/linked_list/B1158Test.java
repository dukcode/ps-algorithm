package com.dukcode.barkingdog.linked_list;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B1158Test extends ProblemSolvingTest {

  public B1158Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of("7 3", "<3, 6, 2, 7, 5, 1, 4>"),
        Arguments.of("1 3", "<1>"),
        Arguments.of("2 1", "<1, 2>"),
        Arguments.of("2 2", "<2, 1>"),
        Arguments.of("2 3", "<1, 2>")
    );
  }

  @Override
  protected void runMain() throws Exception {
    B1158.main(new String[]{});
  }

}