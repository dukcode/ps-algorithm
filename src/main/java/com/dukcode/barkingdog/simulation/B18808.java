package com.dukcode.barkingdog.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B18808 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;
  private static int k;

  private static int[][][] stickers;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    stickers = new int[k][][];
    for (int i = 0; i < k; ++i) {
      st = new StringTokenizer(br.readLine());
      int h = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      stickers[i] = new int[h][w];
      for (int y = 0; y < h; ++y) {
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < w; ++x) {
          stickers[i][y][x] = Integer.parseInt(st.nextToken());
        }
      }
    }

    board = new int[h][w];
    solve();

    bw.write(String.valueOf(countBlank()));

    br.close();
    bw.close();

  }

  private static void solve() {
    Loop:
    for (int i = 0; i < k; ++i) {

      int[][] sticker = stickers[i];
      for (int cntRotate = 0; cntRotate < 4; ++cntRotate) {

        for (int y = 0; y < h; ++y) {
          for (int x = 0; x < w; ++x) {
            if (stick(sticker, y, x, 1)) {
              continue Loop;
            }
            stick(sticker, y, x, -1);
          }
        }

        sticker = rotate(sticker);
      }

    }
  }

  private static void print(int[][] arr) {
    int h = arr.length;
    int w = arr[0].length;

    for (int y = 0; y < h; ++y) {
      for (int x = 0; x < w; ++x) {
        System.out.print(arr[y][x] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static int[][] rotate(int[][] sticker) {
    int h = sticker.length;
    int w = sticker[0].length;

    int[][] ret = new int[w][h];
    for (int y = 0; y < h; ++y) {
      for (int x = 0; x < w; ++x) {
        ret[x][(h - 1) - y] = sticker[y][x];
      }
    }
    return ret;
  }

  private static boolean stick(int[][] sticker, int firstY, int firstX, int delta) {
    Point stickerFirstPoint = findFirst(sticker);

    boolean ret = true;
    for (int y = 0; y < sticker.length; ++y) {
      for (int x = 0; x < sticker[0].length; ++x) {
        int ny = firstY + y - stickerFirstPoint.y;
        int nx = firstX + x - stickerFirstPoint.x;

        if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
          if (sticker[y][x] == 1) {
            ret = false;
          }
          continue;
        }

        if ((board[ny][nx] += sticker[y][x] * delta) > 1) {
          ret = false;
        }

      }
    }

    return ret;
  }

  private static Point findFirst(int[][] arr) {
    int h = arr.length;
    int w = arr[0].length;

    for (int y = 0; y < h; ++y) {
      for (int x = 0; x < w; ++x) {
        if (arr[y][x] == 1) {
          return new Point(y, x);
        }
      }
    }

    return null;
  }

  private static int countBlank() {
    int ret = 0;
    for (int y = 0; y < h; ++y) {
      for (int x = 0; x < w; ++x) {
        ret += board[y][x];
      }
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
