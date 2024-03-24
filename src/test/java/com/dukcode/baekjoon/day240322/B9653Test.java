package com.dukcode.baekjoon.day240322;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B9653Test extends ProblemSolvingTest {

  public B9653Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                """,
            """
                    8888888888  888    88888
                   88     88   88 88   88  88
                    8888  88  88   88  88888
                       88 88 888888888 88   88
                88888888  88 88     88 88    888888
                        
                88  88  88   888    88888    888888
                88  88  88  88 88   88  88  88
                88 8888 88 88   88  88888    8888
                 888  888 888888888 88  88      88
                  88  88  88     88 88   88888888
                """)

    );
  }

  @Override
  protected void runMain() throws Exception {
    B9653.main(new String[]{});
  }

}