package com.dukcode.barkingdog.array.counting_characters_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1919 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] freqDiff = new int[26];
    String word1 = br.readLine();
    String word2 = br.readLine();

    for (char ch : word1.toCharArray()) {
      freqDiff[ch - 'a']++;
    }

    for (char ch : word2.toCharArray()) {
      freqDiff[ch - 'a']--;
    }

    int ret = 0;
    for (int i = 0; i < 26; ++i) {
      ret += Math.abs(freqDiff[i]);
    }

    bw.write(String.valueOf(ret));

    br.close();
    bw.close();

  }

}
