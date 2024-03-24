package com.dukcode.baekjoon.others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2558 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(a + b));

    br.close();
    bw.close();

  }


}
