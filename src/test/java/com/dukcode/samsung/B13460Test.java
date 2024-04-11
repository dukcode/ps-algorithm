package com.dukcode.samsung;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import util.ProblemSolvingTest;

class B13460Test extends ProblemSolvingTest {

  public B13460Test() {
    super(3);
  }

  public static Stream<Arguments> setData() {
    return Stream.of(
        Arguments.of(
            """
                5 5
                #####
                #..B#
                #.#.#
                #RO.#
                #####
                """,
            """
                1
                """),
        Arguments.of(
            """
                7 7
                #######
                #...RB#
                #.#####
                #.....#
                #####.#
                #O....#
                #######
                """,
            """
                5
                """),
        Arguments.of(
            """
                7 7
                #######
                #..R#B#
                #.#####
                #.....#
                #####.#
                #O....#
                #######
                """,
            """
                5
                """),
        Arguments.of(
            """
                10 10
                ##########
                #R#...##B#
                #...#.##.#
                #####.##.#
                #......#.#
                #.######.#
                #.#....#.#
                #.#.#.#..#
                #...#.O#.#
                ##########
                """,
            """
                -1
                """),
        Arguments.of(
            """
                3 7
                #######
                #R.O.B#
                #######
                """,
            """
                1
                """),
        Arguments.of(
            """
                10 10
                ##########
                #R#...##B#
                #...#.##.#
                #####.##.#
                #......#.#
                #.######.#
                #.#....#.#
                #.#.##...#
                #O..#....#
                ##########
                """,
            """
                7
                """),
        Arguments.of(
            """
                3 10
                ##########
                #.O....RB#
                ##########
                """,
            """
                -1
                """),
        Arguments.of(
            """
                3 10
                ##########
                #.O...B#R#
                ##########
                """,
            """
                -1
                """),
        Arguments.of(
            """
                3 10
                ##########
                #RO...B..#
                ##########
                """,
            """
                1
                """),
        Arguments.of(
            """
                3 10
                ##########
                #O...R.#B#
                ##########
                """,
            """
                1
                """)
    );
  }

  @Override
  protected void runMain() throws Exception {
    B13460.main(new String[]{});
  }

}