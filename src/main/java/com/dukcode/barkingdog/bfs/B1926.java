package com.dukcode.barkingdog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1926 {

  private static final int[] dy = {0, 0, 1, -1};
  private static final int[] dx = {1, -1, 0, 0};

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
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        board[y][x] = st.nextToken().equals("1");
      }
    }

    visited = new boolean[h][w];
    int maxArea = 0;
    int cnt = 0;
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        if (visited[y][x] || !board[y][x]) {
          continue;
        }

        int area = 1;
        cnt++;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
          Point cur = q.poll();
          for (int dir = 0; dir < 4; ++dir) {
            int ny = cur.y + dy[dir];
            int nx = cur.x + dx[dir];

            if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
              continue;
            }

            if (visited[ny][nx] || !board[ny][nx]) {
              continue;
            }

            visited[ny][nx] = true;
            area++;
            q.offer(new Point(ny, nx));
          }

          maxArea = Math.max(maxArea, area);
        }

      }
    }

    bw.write(String.valueOf(cnt));
    bw.newLine();
    bw.write(String.valueOf(maxArea));

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
