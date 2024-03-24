package com.dukcode.barkingdog.array.counting_characters_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10807 {

  private static final int MIN = -100;
  private static final int MAX = 100;
  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int[] freq = new int[MAX - MIN + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      int num = Integer.parseInt(st.nextToken());
      freq[num - MIN]++; // ?
    }

    int v = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(freq[v - MIN]));

    br.close();
    bw.close();

  }

}
