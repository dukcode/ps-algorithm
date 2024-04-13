package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B15684 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int h;

  private static boolean[][] ladder;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    ladder = new boolean[h][n - 1];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      ladder[a - 1][b - 1] = true;
    }

    int ans = solve(0, 0);
    bw.write(String.valueOf(ans == Integer.MAX_VALUE ? -1 : ans));

    br.close();
    bw.close();

  }

  private static void print() {
    for (int y = 0; y < h; y++) {
      System.out.print("|");
      for (int x = 0; x < n - 1; x++) {
        System.out.print(ladder[y][x] ? "---" : "   ");
        System.out.print("|");
      }
      System.out.println();
    }
    System.out.println();
  }


  private static int solve(int cnt, int startIdx) {
    if (cnt == 4) {
      return Integer.MAX_VALUE;
    }

    if (win()) {
      return cnt;
    }

    int ans = Integer.MAX_VALUE;
    for (int i = startIdx; i < h * (n - 1); i++) {
      int y = i / (n - 1);
      int x = i % (n - 1);
      if (ladder[y][x]) {
        continue;
      }

      if (x != 0 && ladder[y][x - 1]) {
        continue;
      }

      if (x != n - 2 && ladder[y][x + 1]) {
        continue;
      }

      ladder[y][x] = true;
      ans = Math.min(ans, solve(cnt + 1, i + 1));
      ladder[y][x] = false;
    }

    return ans;
  }

  private static boolean win() {
    for (int i = 0; i < n; ++i) {
      if (calcResult(i) != i) {
        return false;
      }
    }
    return true;
  }

  private static int calcResult(int i) {
    int x = i;
    int y = 0;

    while (y < h) {
      // 오른쪽
      if (x < n - 1 && ladder[y][x]) {
        x++;
        y++;
        continue;
      }

      // 왼쪽
      if (x - 1 >= 0 && ladder[y][x - 1]) {
        x--;
        y++;
        continue;
      }

      y++;
    }

    return x;
  }
}
