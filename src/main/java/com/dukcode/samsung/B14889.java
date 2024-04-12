package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14889 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] s;

  private static int[] permutation;

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

    permutation = new int[n];
    Arrays.fill(permutation, n / 2, n, 1);

    int ans = Integer.MAX_VALUE;
    do {
      int sum = 0;
      int otherSum = 0;
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (permutation[i] == 1 && permutation[j] == 1) {
            sum += s[j][i] + s[i][j];
          }
          if (permutation[i] == 0 && permutation[j] == 0) {
            otherSum += s[j][i] + s[i][j];
          }
        }
      }

      ans = Math.min(ans, Math.abs(sum - otherSum));

    } while (nextPermutation());

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static boolean nextPermutation() {
    int l = n - 2;
    while (0 <= l && permutation[l] >= permutation[l + 1]) {
      l--;
    }

    if (l < 0) {
      return false;
    }

    int r = n - 1;
    while (0 <= r && permutation[l] >= permutation[r]) {
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

}
