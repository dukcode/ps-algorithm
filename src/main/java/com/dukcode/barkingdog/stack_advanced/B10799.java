package com.dukcode.barkingdog.stack_advanced;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10799 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    char[] line = br.readLine().toCharArray();
    int n = line.length;
    int ans = 0;
    Stack<Character> stk = new Stack<>();
    for (int i = 0; i < n; ++i) {
      char c = line[i];

      if (c == '(') {
        stk.push(c);
        continue;
      }

      if (line[i - 1] == '(') {
        stk.pop();
        ans += stk.size();
        continue;
      }

      stk.pop();
      ans++;
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

}
