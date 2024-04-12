package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15683 {

  private static final int[] dy = {1, 0, -1, 0};
  private static final int[] dx = {0, 1, 0, -1};

  private static final int[][] dirs = {{1}, {1, 3}, {1, 2}, {1, 2, 3}, {0, 1, 2, 3}};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;

  private static int[][] board;
  private static int[] rot;

  private static List<Point> cctvs;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    cctvs = new ArrayList<>();
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
        if (1 <= board[y][x] && board[y][x] <= 5) {
          cctvs.add(new Point(y, x));
        }
      }
    }

    rot = new int[cctvs.size()];
    bw.write(String.valueOf(solve(0)));

    br.close();
    bw.close();

  }


  private static int solve(int idx) {
    if (idx == cctvs.size()) {
      return calcArea();
    }

    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < 4; ++i) {
      ans = Math.min(ans, solve(idx + 1));
      rot[idx] = (rot[idx] + 1) % 4;
    }

    return ans;
  }

  private static int calcArea() {
    int n = cctvs.size();

    int[][] newBoard = new int[h][w];
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        newBoard[y][x] = board[y][x];
      }
    }

    for (int i = 0; i < n; ++i) {
      Point p = cctvs.get(i);

      int cctv = newBoard[p.y][p.x];
      int[] cctvDirs = dirs[cctv - 1];
      int r = rot[i];

      for (int cctvDir : cctvDirs) {
        int d = (cctvDir + r) % 4;
        draw(p, d, newBoard);
      }
    }

    int cnt = 0;
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        if (newBoard[y][x] == 0) {
          cnt++;
        }
      }
    }

    return cnt;
  }

  private static void draw(Point p, int d, int[][] board) {
    int y = p.y;
    int x = p.x;
    while (true) {
      int ny = y + dy[d];
      int nx = x + dx[d];

      if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
        return;
      }

      if (board[ny][nx] == 6) {
        return;
      }

      y = ny;
      x = nx;

      if (1 <= board[ny][nx] && board[ny][nx] <= 5) {
        continue;
      }

      board[ny][nx] = -1;
    }
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
