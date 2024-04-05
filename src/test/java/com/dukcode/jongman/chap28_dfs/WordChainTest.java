package com.dukcode.jongman.chap28_dfs;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class WordChainTest extends ProblemSolvingTest {

  public WordChainTest() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                3
                4
                dog
                god
                dragon
                need
                3
                aa
                ab
                bb
                2
                ab
                cd
                """,
            """
                dog god dragon need
                aa ab bb
                IMPOSSIBLE
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    WordChain.main(new String[]{});
  }

}