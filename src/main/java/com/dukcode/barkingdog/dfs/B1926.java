package com.dukcode.barkingdog.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1926 {

  private static final int[] dy = {0, 1, 0, -1};
  private static final int[] dx = {1, 0, -1, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;
  private static int h;
  private static int w;
  private static boolean[][] board;
  private static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new boolean[h][w];
    visited = new boolean[h][w];
    for (int y = 0; y < h; ++y) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; ++x) {
        board[y][x] = Integer.parseInt(st.nextToken()) == 1;
      }
    }

    int maxArea = 0;
    int cnt = 0;
    for (int y = 0; y < h; ++y) {
      for (int x = 0; x < w; ++x) {
        if (visited[y][x] || !board[y][x]) {
          continue;
        }

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(y, x));
        cnt++;

        int area = 0;
        while (!q.isEmpty()) {
          Point cur = q.poll();

          if (visited[cur.y][cur.x]) {
            continue;
          }

          area++;
          visited[cur.y][cur.x] = true;

          for (int dir = 0; dir < 4; ++dir) {
            int ny = cur.y + dy[dir];
            int nx = cur.x + dx[dir];

            if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
              continue;
            }

            if (visited[ny][nx] || !board[ny][nx]) {
              continue;
            }

            q.offer(new Point(ny, nx));
          }
        }

        maxArea = Math.max(maxArea, area);

      }
    }

    bw.write(String.valueOf(cnt));
    bw.newLine();
    bw.write(String.valueOf(maxArea));
    bw.newLine();

    br.close();
    bw.close();

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
