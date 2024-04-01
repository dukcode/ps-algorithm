package com.dukcode.barkingdog.stack_advanced;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B9012 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    while (n-- > 0) {
      String line = br.readLine();
      boolean ret = solve(line);
      bw.write(ret ? "YES" : "NO");
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static boolean solve(String line) throws IOException {
    Stack<Character> stk = new Stack<>();
    for (char c : line.toCharArray()) {
      if (c == '(') {
        stk.push(c);
        continue;
      }

      if (stk.isEmpty() || stk.peek() == ')') {
        return false;
      }

      stk.pop();
    }

    return stk.isEmpty();
  }

}
