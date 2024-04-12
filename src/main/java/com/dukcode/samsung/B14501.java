package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14501 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // 1 ~ 15
  private static int[] time; // 1 ~ 5
  private static int[] pay; // 1 ~ 1000

  private static int[] cache;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    time = new int[n];
    pay = new int[n];
    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      time[i] = Integer.parseInt(st.nextToken());
      pay[i] = Integer.parseInt(st.nextToken());
    }

    cache = new int[n];
    Arrays.fill(cache, -1);

    bw.write(String.valueOf(solve(0)));

    br.close();
    bw.close();

  }

  private static int solve(int day) {
    if (day > n) {
      return Integer.MIN_VALUE;
    }

    if (day == n) {
      return 0;
    }

    if (cache[day] != -1) {
      return cache[day];
    }

    return cache[day] =
        Math.max(
            solve(day + 1),
            solve(day + time[day]) + pay[day]
        );
  }

}
