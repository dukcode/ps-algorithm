package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15685 {

  // 우 상 좌 하
  private static final int[] dy = {0, -1, 0, 1};
  private static final int[] dx = {1, 0, -1, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;

  private static boolean[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    board = new boolean[101][101];

    while (n-- > 0) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());

      List<Integer> dirs = new ArrayList<>();

      dirs.add(d);
      board[y][x] = true;

      while (g-- > 0) {
        for (int i = dirs.size() - 1; i >= 0; --i) {
          dirs.add((dirs.get(i) + 1) % 4);
        }
      }

      for (Integer dir : dirs) {
        y += dy[dir];
        x += dx[dir];

        if (y < 0 || y > 100 || x < 0 || x > 100) {
          continue;
        }

        board[y][x] = true;
      }
    }

    int cnt = 0;
    for (int y = 0; y < 100; y++) {
      for (int x = 0; x < 100; x++) {
        if (board[y][x] && board[y + 1][x + 1] && board[y + 1][x] && board[y][x + 1]) {
          cnt++;
        }
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

}
