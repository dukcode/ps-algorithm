package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B14500 {

  private static int[][][] blocks = {
      {
          {1, 1, 1, 1}
      },
      {
          {1, 1},
          {1, 1}
      },
      {
          {1, 0},
          {1, 0},
          {1, 1}
      },
      {
          {0, 1},
          {0, 1},
          {1, 1}
      },
      {
          {1, 0},
          {1, 1},
          {0, 1}
      },
      {
          {0, 1},
          {1, 1},
          {1, 0}
      },
      {
          {1, 0},
          {1, 1},
          {1, 0}
      },
  };

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h; // 4 ~ 500
  private static int w; // 4 ~ 500

  private static int[][] board; // 각 칸의 수 1 ~ 1000

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    for (int y = 0; y < h; ++y) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; ++x) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    int ans = 0;
    for (int i = 0; i < blocks.length; i++) {
      for (int rotateCnt = 0; rotateCnt < 4; rotateCnt++) {
        for (int y = 0; y < h; ++y) {
          for (int x = 0; x < w; ++x) {
            int sum = sum(i, y, x);
            ans = Math.max(ans, sum);
          }
        }

        rotate(i);
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int sum(int i, int boardY, int boardX) {
    int[][] b = blocks[i];
    int bh = b.length;
    int bw = b[0].length;

    int ret = 0;
    for (int y = boardY; y < boardY + bh; ++y) {
      for (int x = boardX; x < boardX + bw; ++x) {
        if (b[y - boardY][x - boardX] == 0) {
          continue;
        }

        if (y < 0 || y >= h || x < 0 || x >= w) {
          return -1;
        }

        ret += board[y][x];
      }
    }

    return ret;
  }

  private static void rotate(int idx) {
    int[][] b = blocks[idx];
    int h = b.length;
    int w = b[0].length;

    int[][] ret = new int[w][h];

    for (int y = 0; y < h; ++y) {
      for (int x = 0; x < w; ++x) {
        ret[(w - 1) - x][y] = b[y][x];
      }
    }

    blocks[idx] = ret;
  }
}
