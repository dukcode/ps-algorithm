package com.dukcode.barkingdog.stack_advanced;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B4949 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String line = null;
    while (!(line = br.readLine()).equals(".")) {
      boolean ret = solve(line);
      bw.write(ret ? "yes" : "no");
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static boolean solve(String line) {
    Stack<Character> stk = new Stack<>();
    for (char c : line.toCharArray()) {
      if (!isBracket(c)) {
        continue;
      }

      if (c == '(' || c == '[') {
        stk.push(c);
        continue;
      }

      if (stk.isEmpty() || !isCounter(stk.peek(), c)) {
        return false;
      }

      stk.pop();
    }

    return stk.isEmpty();
  }

  private static boolean isCounter(char openingBracket, char closingBracket) {
    return (openingBracket == '(' && closingBracket == ')')
        || (openingBracket == '[' && closingBracket == ']');
  }

  private static boolean isBracket(char c) {
    return c == '(' || c == ')' || c == '[' || c == ']';
  }

}
