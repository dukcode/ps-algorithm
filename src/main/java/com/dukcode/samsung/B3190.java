package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B3190 {

  private static final int APPLE = 2;

  // 우 하 좌 상
  private static final int[] dy = {0, 1, 0, -1};
  private static final int[] dx = {1, 0, -1, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int l;

  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    board = new int[n][n];

    k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; ++i) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken()) - 1;
      int x = Integer.parseInt(st.nextToken()) - 1;
      board[y][x] = APPLE;
    }

    board[0][0] = 1;
    LinkedList<Point> snake = new LinkedList<>();
    snake.add(new Point(0, 0));

    l = Integer.parseInt(br.readLine());
    int second = 0;
    int dir = 0;
    Loop:
    for (int i = 0; i <= l; ++i) {
      int s;
      int nDir;
      if (i != l) {
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        nDir = st.nextToken().equals("L") ? (dir + 4 - 1) % 4 : (dir + 1) % 4;
      } else {
        s = Integer.MAX_VALUE;
        nDir = dir;
      }

      while (s > second) {
        second++;
        if (!move(snake, dir)) {
          break Loop;
        }
      }

      dir = nDir;
    }

    bw.write(String.valueOf(second));

    br.close();
    bw.close();

  }

  private static boolean move(LinkedList<Point> snake, int dir) {
    Point head = snake.peek();
    int ny = head.y + dy[dir];
    int nx = head.x + dx[dir];
    if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
      return false;
    }

    if (board[ny][nx] == 1) {
      return false;
    }

    if (board[ny][nx] == 0) {
      Point tail = snake.pollLast();
      board[tail.y][tail.x] = 0;
    }

    board[ny][nx] = 1;
    snake.offerFirst(new Point(ny, nx));
    return true;
  }

  private static class Point {

    int y;
    int x;

    public Point(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}
