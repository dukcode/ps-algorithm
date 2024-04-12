package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B13458 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // n개의 시험장
  private static int[] a; // 각 시험장에 있는 응시자의 수
  private static int b; // 총감독관이 한 시험장에서 감시할 수 있는 응시자의 수
  private static int c; // 부감독관이 한 시험장에서 감시할 수 있는 응시자의 수

  // 총감독관은 무조건 1명 부감독관은 여러명 가능
  // 필요한 감독관 수의 최솟값?

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    long ans = 0;
    for (int i = 0; i < n; ++i) {
      int num = a[i];
      num -= b;
      ans++;

      if (num <= 0) {
        continue;
      }

      ans += (num + c - 1) / c;
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

}
