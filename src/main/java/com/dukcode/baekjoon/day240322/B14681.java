package com.dukcode.baekjoon.day240322;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B14681 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int x = Integer.parseInt(br.readLine());
    int y = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(solve(x, y)));

    br.close();
    bw.close();

  }

  private static int solve(int x, int y) {
    if (x > 0) {
      return y > 0 ? 1 : 4;
    }

    return y > 0 ? 2 : 3;
  }


}
