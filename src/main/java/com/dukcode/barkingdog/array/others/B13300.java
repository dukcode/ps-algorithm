package com.dukcode.barkingdog.array.others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B13300 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] students = new int[2][6];

    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      int sex = Integer.parseInt(st.nextToken());
      int grade = Integer.parseInt(st.nextToken());

      students[sex][grade - 1]++;
    }

    int ans = 0;
    for (int sex = 0; sex < 2; ++sex) {
      for (int grade = 1; grade <= 6; ++grade) {
        ans += (students[sex][grade - 1] + k - 1) / k;
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

}
