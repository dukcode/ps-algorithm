package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14891 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static LinkedList<Integer>[] gear = new LinkedList[4];

  private static int k;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i < 4; ++i) {
      gear[i] = new LinkedList<>();
      char[] line = br.readLine().toCharArray();
      for (char c : line) {
        gear[i].offerLast(c - '0');
      }
    }

    k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; ++i) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken()) - 1;
      int dir = Integer.parseInt(st.nextToken());

      move(num, dir);
    }

    bw.write(String.valueOf(calcScore()));

    br.close();
    bw.close();

  }

  private static void move(int num, int dir) {
    int[] dirs = new int[4];
    Arrays.fill(dirs, -2);
    Queue<Integer> q = new LinkedList<>();
    q.offer(num);
    dirs[num] = dir;

    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int dx : new int[]{-1, 1}) {
        int next = cur + dx;
        if (next < 0 || next >= 4) {
          continue;
        }

        if (dirs[next] != -2) {
          continue;
        }

        int curMag = dx == -1 ? get9(gear[cur]) : get3(gear[cur]);
        int nextMag = dx == -1 ? get3(gear[next]) : get9(gear[next]);
        if (curMag != nextMag && dirs[cur] != 0) {
          dirs[next] = dirs[cur] == 1 ? -1 : 1;
        } else {
          dirs[next] = 0;
        }

        q.offer(next);
      }
    }

    for (int i = 0; i < 4; ++i) {
      move(gear[i], dirs[i]);
    }
  }


  private static void move(LinkedList<Integer> gear, int dir) {
    if (dir == 1) {
      gear.offerFirst(gear.pollLast());
    } else if (dir == -1) {
      gear.offerLast(gear.pollFirst());
    }
  }

  private static int get12(LinkedList<Integer> gear) {
    return gear.get(0);
  }

  private static int get3(LinkedList<Integer> gear) {
    return gear.get(2);
  }

  private static int get9(LinkedList<Integer> gear) {
    return gear.get(6);
  }

  private static int calcScore() {
    int ret = 0;
    for (int i = 0; i < 4; ++i) {
      if (get12(gear[i]) == 1) {
        ret += (1 << i);
      }
    }

    return ret;
  }
}
