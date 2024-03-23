package com.dukcode.baekjoon.day240323;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10808 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String word = br.readLine();
    int[] cache = new int[26];
    for (char ch : word.toCharArray()) {
      cache[ch - 'a']++;
    }

    for (int cnt : cache) {
      bw.write(String.valueOf(cnt));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }


}
