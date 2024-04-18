package com.dukcode.barkingdog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {

  private static final int[] dy = {0, 0, -1, 1};
  private static final int[] dx = {1, -1, 0, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;

  private static int[][] board;
  private static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    visited = new boolean[h][w];
    Queue<Point> q = new LinkedList<>();
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
        if (board[y][x] == 1) {
          q.offer(new Point(y, x));
          visited[y][x] = true;
        }
      }
    }

    int days = -1;
    Queue<Point> nq = new LinkedList<>();
    while (!q.isEmpty()) {
      Point cur = q.poll();
      for (int i = 0; i < 4; ++i) {
        int ny = cur.y + dy[i];
        int nx = cur.x + dx[i];

        if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
          continue;
        }

        if (board[ny][nx] != 0 || visited[ny][nx]) {
          continue;
        }

        board[ny][nx] = 1;
        visited[ny][nx] = true;
        nq.offer(new Point(ny, nx));
      }

      if (q.isEmpty()) {
        q = nq;
        nq = new LinkedList<>();
        days++;
      }
    }

    Loop:
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        if (board[y][x] == 0) {
          days = -1;
          break Loop;
        }
      }
    }

    bw.write(String.valueOf(days));

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
