package com.dukcode.barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B6198 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Stack<Integer> stk = new Stack<>();
    long ans = 0;
    while (n-- > 0) {
      int h = Integer.parseInt(br.readLine());

      while (!stk.isEmpty() && stk.peek() <= h) {
        stk.pop();
      }

      ans += stk.size();
      stk.push(h);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

}
