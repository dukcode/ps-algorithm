package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B5373Test extends ProblemSolvingTest {

  public B5373Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                4
                1
                L-
                2
                F+ B+
                4
                U- D- L+ R+
                10
                L- U- L+ U- L- U- U- L+ U+ U+
                """,
            """
                rww
                rww
                rww
                bbb
                www
                ggg
                gwg
                owr
                bwb
                gwo
                www
                rww
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B5373.main(new String[]{});
  }

}