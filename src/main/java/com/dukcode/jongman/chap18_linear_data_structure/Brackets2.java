package com.dukcode.jongman.chap18_linear_data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Brackets2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      char[] brackets = br.readLine().toCharArray();

      bw.write(isValid(brackets) ? "YES" : "NO");
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static boolean isValid(char[] brackets) {

    Stack<Character> stk = new Stack<>();
    for (char bracket : brackets) {
      if (isOpening(bracket)) {
        stk.push(bracket);
        continue;
      }

      if (stk.isEmpty() || !isCounter(stk.peek(), bracket)) {
        return false;
      }

      stk.pop();
    }

    return stk.isEmpty();
  }

  private static boolean isCounter(char openingBracket, char closingBracket) {
    switch (openingBracket) {
      case '(':
        return closingBracket == ')';
      case '[':
        return closingBracket == ']';
      case '{':
        return closingBracket == '}';
    }

    return false;
  }

  private static boolean isOpening(char bracket) {
    return bracket == '(' || bracket == '[' || bracket == '{';
  }
}
