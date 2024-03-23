package com.dukcode.baekjoon.day240322;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringJoiner;

public class B5217 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int numCase = Integer.parseInt(br.readLine());
    while (numCase-- > 0) {
      int n = Integer.parseInt(br.readLine());

      int half = (n + 1) / 2;

      StringJoiner ans = new StringJoiner(", ");
      for (int first = 1; first < half; ++first) {
        int second = n - first;
        ans.add(String.format("%d %d", first, second));
      }

      bw.write(String.format("Pairs for %d: ", n));
      bw.write(ans.toString());
      bw.newLine();
    }

    br.close();
    bw.close();

  }


}
