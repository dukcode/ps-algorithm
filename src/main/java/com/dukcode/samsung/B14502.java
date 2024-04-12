package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502 {

  private static final int BLANK = 0; // 최대 8 * 8 - 3 - 2 = 51개
  private static final int WALL = 1;
  private static final int VIRUS = 2;

  private static final int[] dy = {0, 0, -1, 1};
  private static final int[] dx = {-1, 1, 0, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h; // 3 ~ 8
  private static int w; // 3 ~ 8

  private static int[][] board;
  private static List<Point> blank;
  private static List<Point> virus;

  private static int[] permutation;

  // 벽 3개를 세우고 바이러스가 퍼져 나가게 한 다음 BLANK 의 최대값을 구하여라.
  // O(51C3 * h * w) = O(50^3 / 6 * 8 * 8) = O(1_332_800)

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new int[h][w];

    blank = new ArrayList<>();
    virus = new ArrayList<>();
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
        if (board[y][x] == BLANK) {
          blank.add(new Point(y, x));
        } else if (board[y][x] == VIRUS) {
          virus.add(new Point(y, x));
        }
      }
    }

    permutation = new int[blank.size()];
    Arrays.fill(permutation, blank.size() - 3, blank.size(), 1);

    int ans = 0;
    do {
      int[][] newBoard = new int[h][w];
      for (int y = 0; y < h; y++) {
        for (int x = 0; x < w; x++) {
          newBoard[y][x] = board[y][x];
        }
      }

      for (int i = 0; i < blank.size(); ++i) {
        if (permutation[i] == 1) {
          Point wall = blank.get(i);
          newBoard[wall.y][wall.x] = WALL;
        }
      }

      Queue<Point> q = new LinkedList<>(virus);
      while (!q.isEmpty()) {
        Point cur = q.poll();

        for (int dir = 0; dir < 4; ++dir) {
          int ny = cur.y + dy[dir];
          int nx = cur.x + dx[dir];

          if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
            continue;
          }

          if (newBoard[ny][nx] != 0) {
            continue;
          }

          newBoard[ny][nx] = VIRUS;
          q.offer(new Point(ny, nx));
        }
      }

      int area = 0;
      for (int y = 0; y < h; y++) {
        for (int x = 0; x < w; x++) {
          if (newBoard[y][x] == BLANK) {
            area++;
          }
        }
      }

      ans = Math.max(ans, area);
    } while (nextPermutation());

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static void print(int[][] board) {

    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        System.out.print(board[y][x] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static boolean nextPermutation() {
    int n = permutation.length;

    int l = n - 2;
    while (l >= 0 && permutation[l] >= permutation[l + 1]) {
      l--;
    }

    if (l < 0) {
      return false;
    }

    int r = n - 1;
    while (r > 0 && permutation[l] >= permutation[r]) {
      r--;
    }

    swap(l, r, permutation);

    int st = l + 1;
    int en = n - 1;
    while (st < en) {
      swap(st, en, permutation);
      st++;
      en--;
    }

    return true;
  }

  private static void swap(int a, int b, int[] arr) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
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
