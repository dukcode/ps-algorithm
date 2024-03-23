package com.dukcode.baekjoon.day240323;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B3273 {

  private static final int MAX = 1_000_000;
  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;
  private static int n;
  private static int[] freq;
  private static int x;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(br.readLine());
    freq = new int[MAX + 1];

    int ret = 0;
    for (int i = 0; i < n; ++i) {
      int num = Integer.parseInt(st.nextToken());
      int counter = x - num;

      if (counter < 0 || counter > MAX) {
        continue;
      }

      ret += freq[counter];
      freq[num]++;
    }

    bw.write(String.valueOf(ret));

    br.close();
    bw.close();

  }

}
