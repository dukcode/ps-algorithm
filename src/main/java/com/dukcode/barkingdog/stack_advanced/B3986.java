package com.dukcode.barkingdog.stack_advanced;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B3986 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int ans = 0;
    for (int i = 0; i < n; ++i) {
      String word = br.readLine();
      Stack<Character> stk = new Stack<>();
      for (char c : word.toCharArray()) {
        if (!stk.isEmpty() && stk.peek() == c) {
          stk.pop();
          continue;
        }

        stk.push(c);
      }

      if (stk.isEmpty()) {
        ans++;
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

}
