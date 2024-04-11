package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B13460 {

  private static final int MX = 987_654_321;
  // 상 하 좌 우
  private static final int[] dy = {-1, 1, 0, 0};
  private static final int[] dx = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;

  private static char[][] board;

  private static Point red;
  private static Point blue;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new char[h][];
    for (int y = 0; y < h; ++y) {
      char[] line = br.readLine().toCharArray();
      board[y] = line;
      for (int x = 0; x < w; ++x) {
        char c = line[x];
        switch (c) {
          case 'B':
            blue = new Point(y, x);
            board[y][x] = '.';
            break;
          case 'R':
            red = new Point(y, x);
            board[y][x] = '.';
            break;
          default:
            board[y][x] = c;
            break;
        }
      }
    }

    int ans = solve();
    bw.write(String.valueOf(ans == MX ? -1 : ans));

    br.close();
    bw.close();

  }

  private static int solve() {
    int cnt = MX;

    for (int dir = 0; dir < 4; ++dir) {
      cnt = Math.min(cnt, move(1, dir, red, blue));
    }

    return cnt;
  }

  private static int move(int cnt, int dir, Point red, Point blue) {
    if (cnt > 10) {
      return MX;
    }

    int nry = red.y;
    int nrx = red.x;
    int nby = blue.y;
    int nbx = blue.x;

    while (board[nby + dy[dir]][nbx + dx[dir]] == '.') {
      nby += dy[dir];
      nbx += dx[dir];
    }

    if (board[nby + dy[dir]][nbx + dx[dir]] == 'O') {
      return MX;
    }

    while (board[nry + dy[dir]][nrx + dx[dir]] == '.') {
      nry += dy[dir];
      nrx += dx[dir];
    }

    if (board[nry + dy[dir]][nrx + dx[dir]] == 'O') {
      return cnt;
    }

    if (nry == nby && nrx == nbx) {
      // 상 하 좌 우
      switch (dir) {
        case 0:
          if (red.y < blue.y) {
            nby++;
          } else {
            nry++;
          }
          break;
        case 1:
          if (red.y < blue.y) {
            nry--;
          } else {
            nby--;
          }
          break;
        case 2:
          if (red.x < blue.x) {
            nbx++;
          } else {
            nrx++;
          }
          break;
        case 3:
          if (red.x < blue.x) {
            nrx--;
          } else {
            nbx--;
          }
          break;
        default:
          break;
      }
    }

    int ret = MX;
    for (int nextDir = 0; nextDir < 4; ++nextDir) {
      if (dir == nextDir) {
        continue;
      }
      ret = Math.min(ret, move(cnt + 1, nextDir, new Point(nry, nrx), new Point(nby, nbx)));
    }
    return ret;
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
