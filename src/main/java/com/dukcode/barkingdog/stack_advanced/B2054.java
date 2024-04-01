package com.dukcode.barkingdog.stack_advanced;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2054 {

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

    int multiple = 1;
    for (int i = 0; i < n; ++i) {
      char c = line[i];

      if (c == '(' || c == '[') {
        stk.push(c);
        multiple *= c == '(' ? 2 : 3;
        continue;
      }

      char counter = c == ')' ? '(' : '[';
      if (stk.isEmpty() || stk.peek() != counter) {
        ans = 0;
        break;
      }

      if (line[i - 1] == counter) {
        ans += multiple;
      }

      multiple /= c == ')' ? 2 : 3;
      stk.pop();
    }

    bw.write(String.valueOf(stk.isEmpty() ? ans : 0));

    br.close();
    bw.close();

  }

  private static boolean isCounter(char openingBracket, char closingBracket) {
    return (openingBracket == '(' && closingBracket == ')')
        || (openingBracket == '[' && closingBracket == ']');
  }
}
