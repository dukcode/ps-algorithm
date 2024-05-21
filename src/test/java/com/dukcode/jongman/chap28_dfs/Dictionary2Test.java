package com.dukcode.jongman.chap28_dfs;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class Dictionary2Test extends ProblemSolvingTest {

  public Dictionary2Test() {
    super(1);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                3
                3
                ba
                aa
                ab
                5
                gg
                kia
                lotte
                lg
                hanhwa
                6
                dictionary
                english
                is
                ordered
                ordinary
                this
                """,
            // g k l, o g
            // d e i o t
            """
                INVALID HYPOTHESIS
                zyxwvutsrqponmjigklhfedcba
                zyxwvusrqpnmlkjhgfdeiotcba
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    Dictionary2.main(new String[]{});
  }

}