package com.dukcode.barkingdog.stack_advanced;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B4949Test extends ProblemSolvingTest {

  public B4949Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                So when I die (the [first] I will see in (heaven) is a score list).
                [ first in ] ( first out ).
                Half Moon tonight (At least it is better than no Moon at all].
                A rope may form )( a trail in a maze.
                Help( I[m being held prisoner in a fortune cookie factory)].
                ([ (([( [ ] ) ( ) (( ))] )) ]).
                 .
                .
                """,
            """
                yes
                yes
                no
                no
                no
                yes
                yes
                """)

    );
  }

  @Override
  protected void runMain() throws Exception {
    B4949.main(new String[]{});
  }

}