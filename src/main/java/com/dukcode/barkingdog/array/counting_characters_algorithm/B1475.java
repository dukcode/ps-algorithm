package com.dukcode.barkingdog.array.counting_characters_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B1475 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] cache = new int[10];
    String number = br.readLine();
    for (char ch : number.toCharArray()) {
      cache[ch - '0']++;
    }

    cache[6] = cache[9] = (cache[6] + cache[9] + 1) / 2;

    bw.write(String.valueOf(Arrays.stream(cache).max().getAsInt()));

    br.close();
    bw.close();

  }


}
