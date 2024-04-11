package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class B12100 {

  private static final int MN = -987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    board = new int[n][n];
    for (int y = 0; y < n; ++y) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; ++x) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(String.valueOf(solve(0, board, new ArrayList<>())));

    br.close();
    bw.close();

  }

  private static int solve(int cnt, int[][] board, List<Integer> order) {
    if (cnt == 5) {
      return findMax(board);
    }

    int[][] newBoard = new int[n][n];
    for (int y = 0; y < n; ++y) {
      System.arraycopy(board[y], 0, newBoard[y], 0, n);
    }

    int ret = MN;
    for (int cntRotate = 0; cntRotate < 4; ++cntRotate) {
      List<Integer> nextOrder = new ArrayList<>(order);
      nextOrder.add(cntRotate);
      ret = Math.max(ret,
          solve(cnt + 1, moveLeft(newBoard), nextOrder));

      if (cntRotate == 3) {
        continue;
      }
      newBoard = rotate(newBoard);
    }

    return ret;
  }

  private static int findMax(int[][] board) {
    int ret = MN;
    for (int y = 0; y < n; ++y) {
      for (int x = 0; x < n; ++x) {
        ret = Math.max(ret, board[y][x]);
      }
    }

    return ret;
  }

  private static int[][] moveLeft(int[][] board) {
    int[][] ret = new int[n][];

    for (int y = 0; y < n; ++y) {
      ret[y] = moveLineLeft(board[y]);
    }

    return ret;
  }

  private static int[] moveLineLeft(int[] line) {

    Deque<Integer> dq = new ArrayDeque<>();
    boolean added = false;
    for (int i = 0; i < n; ++i) {
      int num = line[i];
      if (num == 0) {
        continue;
      }
      if (!dq.isEmpty() && dq.peekLast() == num && !added) {
        num = dq.pollLast() * 2;
        added = true;
      } else {
        added = false;
      }
      dq.offerLast(num);
    }

    int[] ret = new int[n];
    int idx = 0;
    while (!dq.isEmpty()) {
      ret[idx++] = dq.pollFirst();
    }

    return ret;
  }

  private static int[][] rotate(int[][] board) {
    int[][] ret = new int[n][n];
    for (int y = 0; y < n; ++y) {
      for (int x = 0; x < n; ++x) {
        ret[y][(n - 1) - x] = board[y][x];
      }
    }

    for (int y = 0; y < n; ++y) {
      for (int x = y + 1; x < n; ++x) {
        int tmp = ret[y][x];
        ret[y][x] = ret[x][y];
        ret[x][y] = tmp;
      }
    }

    return ret;
  }

}
