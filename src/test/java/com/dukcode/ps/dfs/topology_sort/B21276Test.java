package com.dukcode.ps.dfs.topology_sort;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B21276Test extends ProblemSolvingTest {

  public B21276Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                7
                daeil sangdo yuri hoseok minji doha haeun
                7
                hoseok sangdo
                yuri minji
                hoseok daeil
                daeil sangdo
                haeun doha
                doha minji
                haeun minji
                """,
            """
                2
                minji sangdo
                daeil 1 hoseok
                doha 1 haeun
                haeun 0
                hoseok 0
                minji 2 doha yuri
                sangdo 1 daeil
                yuri 0
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B21276.main(new String[]{});
  }

}