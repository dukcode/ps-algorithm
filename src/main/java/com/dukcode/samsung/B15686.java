package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15686 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static List<Point> chickens;
  private static List<Point> houses;
  private static int[] remain;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    chickens = new ArrayList<>();
    houses = new ArrayList<>();
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        int num = Integer.parseInt(st.nextToken());
        if (num == 1) {
          houses.add(new Point(y, x));
        } else if (num == 2) {
          chickens.add(new Point(y, x));
        }
      }
    }

    remain = new int[chickens.size()];
    for (int i = chickens.size() - m; i < chickens.size(); i++) {
      remain[i] = 1;
    }

    int ans = Integer.MAX_VALUE;
    do {
      int chickenDist = 0;
      for (Point house : houses) {
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < chickens.size(); i++) {
          if (remain[i] == 0) {
            continue;
          }
          minDist = Math.min(minDist,
              Math.abs(chickens.get(i).y - house.y) + Math.abs(chickens.get(i).x - house.x));
        }
        chickenDist += minDist;
      }
      ans = Math.min(ans, chickenDist);
    } while (nextPermutation());

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static boolean nextPermutation() {
    int n = remain.length;
    int l = n - 2;
    while (l >= 0 && remain[l] >= remain[l + 1]) {
      l--;
    }

    if (l < 0) {
      return false;
    }

    int r = n - 1;
    while (r > l && remain[l] >= remain[r]) {
      r--;
    }

    int tmp = remain[l];
    remain[l] = remain[r];
    remain[r] = tmp;

    int st = l + 1;
    int en = n - 1;
    while (st < en) {
      int num = remain[en];
      remain[en] = remain[st];
      remain[st] = num;
      st++;
      en--;
    }

    return true;
  }


  private static class Point {

    int y;
    int x;

    public Point(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}
