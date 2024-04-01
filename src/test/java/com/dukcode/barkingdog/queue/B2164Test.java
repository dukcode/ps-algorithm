package com.dukcode.barkingdog.queue;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B2164Test extends ProblemSolvingTest {

  public B2164Test() {
    super(2);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of("6", "4"),
        Arguments.of("1", "1")
    );
  }

  @Override
  protected void runMain() throws Exception {
    B2164.main(new String[]{});
  }

}