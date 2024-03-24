package com.dukcode.barkingdog.array.counting_characters_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2577 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());

    int[] cache = new int[10];
    String res = String.valueOf(a * b * c);
    for (char ch : res.toCharArray()) {
      cache[ch - '0']++;
    }

    for (int cnt : cache) {
      bw.write(String.valueOf(cnt));
      bw.newLine();
    }

    br.close();
    bw.close();

  }


}
