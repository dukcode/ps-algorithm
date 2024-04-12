package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B14890 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // 2 ~ 100
  private static int l; // 1 ~ n

  private static int[][] board; // 각 칸의 높이: 10 이하의 자연수

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());

    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    for (int y = 0; y < n; y++) {
      int[] arr = board[y];
      if (canBeRoute(arr)) {
        cnt++;
      }
    }

    for (int x = 0; x < n; ++x) {
      int[] arr = new int[n];
      for (int y = 0; y < n; y++) {
        arr[y] = board[y][x];
      }

      if (canBeRoute(arr)) {
        cnt++;
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static boolean canBeRoute(int[] arr) {
    if (isFlat(arr)) {
      return true;
    }

    if (isImpossible(arr)) {
      return false;
    }

    boolean[] installed = new boolean[n];
    for (int i = 1; i < n; i++) {
      int dh = arr[i] - arr[i - 1];

      if (dh == 1) { // 상승 기준 i
        for (int j = i - l; j < i; ++j) {
          if (j < 0 || arr[j] + 1 != arr[i] || installed[j]) {
            return false;
          }
          installed[j] = true;
        }
      } else if (dh == -1) { // 하강 기준 i - 1
        for (int j = i; j < i + l; ++j) {
          if (j >= n || arr[i - 1] != arr[j] + 1 || installed[j]) {
            return false;
          }
          installed[j] = true;
        }
      }
    }
    return true;
  }

  private static boolean isImpossible(int[] arr) {
    for (int i = 1; i < n; ++i) {
      if (Math.abs(arr[i] - arr[i - 1]) > 1) {
        return true;
      }
    }

    return false;
  }

  private static boolean isFlat(int[] arr) {
    int h = arr[0];
    for (int i = 0; i < n; ++i) {
      if (h != arr[i]) {
        return false;
      }
    }

    return true;
  }

}
