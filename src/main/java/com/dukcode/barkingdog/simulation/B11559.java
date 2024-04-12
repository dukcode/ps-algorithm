package com.dukcode.barkingdog.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11559 {

  private static final int[] dy = {0, 0, 1, -1};
  private static final int[] dx = {1, -1, 0, 0};

  private static final int H = 12;
  private static final int W = 6;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static char[][] board = new char[H][];


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int y = 0; y < H; y++) {
      char[] line = br.readLine().toCharArray();
      for (int x = 0; x < W; x++) {
        board[y] = line;
      }
    }

    int cnt = 0;
    while (boom()) {
      cnt++;
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static boolean boom() {
    boolean ret = false;
    for (int y = 0; y < H; y++) {
      for (int x = 0; x < W; x++) {
        if (board[y][x] == '.') {
          continue;
        }
        if (boom(y, x)) {
          ret = true;
        }
      }
    }

    gravity();
    return ret;
  }

  private static boolean boom(int y, int x) {
    char c = board[y][x];
    boolean[][] vis = new boolean[H][W];
    List<Point> candidates = new ArrayList<>();

    Queue<Point> q = new LinkedList<>();
    q.offer(new Point(y, x));
    candidates.add(new Point(y, x));
    vis[y][x] = true;

    while (!q.isEmpty()) {
      Point cur = q.poll();
      for (int dir = 0; dir < 4; ++dir) {
        int ny = cur.y + dy[dir];
        int nx = cur.x + dx[dir];

        if (ny < 0 || ny >= H || nx < 0 || nx >= W) {
          continue;
        }

        if (vis[ny][nx] || board[ny][nx] != c) {
          continue;
        }

        vis[ny][nx] = true;
        candidates.add(new Point(ny, nx));
        q.offer(new Point(ny, nx));
      }
    }

    if (candidates.size() < 4) {
      return false;
    }

    for (Point candidate : candidates) {
      board[candidate.y][candidate.x] = '.';
    }
    return true;
  }

  private static void gravity() {
    for (int x = 0; x < W; ++x) {
      int pos = H - 1;
      for (int y = H - 1; y >= 0; --y) {
        if (board[y][x] == '.') {
          continue;
        }
        board[pos--][x] = board[y][x];
      }

      for (int y = pos; y >= 0; --y) {
        board[y][x] = '.';
      }
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
