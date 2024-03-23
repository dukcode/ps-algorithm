package com.dukcode.baekjoon.day240322;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2525 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(br.readLine());

    bw.write(solve(a, b, c));

    br.close();
    bw.close();
  }

  private static String solve(int a, int b, int c) {
    int hour = a;
    int min = b + c;

    hour += min / 60;
    min %= 60;

    hour %= 24;

    return String.format("%d %d", hour, min);
  }

}
