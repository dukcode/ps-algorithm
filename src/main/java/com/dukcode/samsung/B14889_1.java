package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B14889_1 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] s;

  private static boolean[] taken;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    s = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        s[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    taken = new boolean[n];
    bw.write(String.valueOf(solve(0, 0)));

    br.close();
    bw.close();

  }

  private static int solve(int startIdx, int peekCount) {
    if (peekCount == n / 2) {
      return calc();
    }

    int ret = Integer.MAX_VALUE;
    for (int i = startIdx; i < n; i++) {
      if (taken[i]) {
        continue;
      }

      taken[i] = true;
      ret = Math.min(ret, solve(i + 1, peekCount + 1));
      taken[i] = false;
    }

    return ret;
  }


  private static int calc() {
    int sum = 0;
    int otherSum = 0;

    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {

        if (taken[i] && taken[j]) {
          sum += s[i][j] + s[j][i];
        }

        if (!taken[i] && !taken[j]) {
          otherSum += s[i][j] + s[j][i];
        }

      }
    }

    return Math.abs(sum - otherSum);
  }
}
