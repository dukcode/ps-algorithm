package com.dukcode.baekjoon.day240323;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
sort 없이 풀 수 있는데...
 */
public class B11328 {

  public static final String IMPOSSIBLE = "Impossible";
  public static final String POSSIBLE = "Possible";
  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Loop:
    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());

      char[] arr1 = st.nextToken().toCharArray();
      Arrays.sort(arr1);

      char[] arr2 = st.nextToken().toCharArray();
      Arrays.sort(arr2);

      if (arr1.length != arr2.length) {
        bw.write(IMPOSSIBLE);
        bw.newLine();
        continue;
      }

      for (int idx = 0; idx < arr1.length; ++idx) {
        if (arr1[idx] != arr2[idx]) {
          bw.write(IMPOSSIBLE);
          bw.newLine();
          continue Loop;
        }
      }

      bw.write(POSSIBLE);
      bw.newLine();
    }

    br.close();
    bw.close();

  }

}
