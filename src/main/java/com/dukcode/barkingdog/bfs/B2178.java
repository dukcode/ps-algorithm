package com.dukcode.barkingdog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {

  private static final int[] dy = {0, 0, -1, 1};
  private static final int[] dx = {1, -1, 0, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;

  private static boolean[][] board;
  private static int[][] dist;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new boolean[h][w];
    for (int y = 0; y < h; y++) {
      char[] line = br.readLine().toCharArray();
      for (int x = 0; x < w; x++) {
        board[y][x] = line[x] == '1';
      }
    }

    dist = new int[h][w];
    Queue<Point> q = new LinkedList<>();

    q.offer(new Point(0, 0));
    dist[0][0] = 1;

    int ans = -1;
    while (!q.isEmpty()) {
      Point cur = q.poll();
      for (int dir = 0; dir < 4; ++dir) {
        int ny = cur.y + dy[dir];
        int nx = cur.x + dx[dir];

        if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
          continue;
        }

        if (dist[ny][nx] != 0 || !board[ny][nx]) {
          continue;
        }

        dist[ny][nx] = dist[cur.y][cur.x] + 1;

        if (ny == h - 1 && nx == w - 1) {
          ans = dist[ny][nx];
          break;
        }

        q.offer(new Point(ny, nx));
      }
    }

    bw.write(String.valueOf(ans));

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
