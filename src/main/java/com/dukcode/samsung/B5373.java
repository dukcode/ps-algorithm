package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B5373 {

  private static final char[] colors = {'w', 'y', 'r', 'o', 'g', 'b'};

  private static final int U = 0;
  private static final int D = 1;
  private static final int F = 2;
  private static final int B = 3;
  private static final int L = 4;
  private static final int R = 5;

  private static final int CW = 1;
  private static final int CCW = 3;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int t;
  private static int n;

  private static char[][][] cube;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      n = Integer.parseInt(br.readLine());

      initCube();

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; ++i) {
        char[] temp = st.nextToken().toCharArray();
        int face = parseFace(temp[0]);
        int dir = parseDir(temp[1]);

        rotate(face, dir);
      }

      printTop();
    }

    br.close();
    bw.close();

  }

  private static void printTop() throws IOException {
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        bw.write(cube[U][y][x]);
      }
      bw.newLine();
    }
  }

  private static int parseDir(char c) {
    return c == '+' ? CW : CCW;
  }

  private static void rotate(int face, int dir) {
    rotateFace(face, dir);
    rotateSide(face, dir);
  }

  private static void rotateFace(int face, int dir) {
    char[][] ans = new char[3][3];
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        if (dir == CW) {
          ans[x][2 - y] = cube[face][y][x];
        } else {
          ans[2 - x][y] = cube[face][y][x];
        }

      }
    }

    cube[face] = ans;
  }

  private static void rotateSide(int face, int dir) {
    char tmp;
    while (dir-- > 0) {
      switch (face) {
        case U:
          for (int i = 0; i < 3; ++i) {
            tmp = cube[F][0][i];
            cube[F][0][i] = cube[R][0][i];
            cube[R][0][i] = cube[B][0][i];
            cube[B][0][i] = cube[L][0][i];
            cube[L][0][i] = tmp;
          }
          break;
        case D:
          for (int i = 0; i < 3; ++i) {
            tmp = cube[R][2][i];
            cube[R][2][i] = cube[F][2][i];
            cube[F][2][i] = cube[L][2][i];
            cube[L][2][i] = cube[B][2][i];
            cube[B][2][i] = tmp;
          }
          break;
        case F:
          for (int i = 0; i < 3; ++i) {
            tmp = cube[R][i][0];
            cube[R][i][0] = cube[U][2][i];
            cube[U][2][i] = cube[L][2 - i][2];
            cube[L][2 - i][2] = cube[D][0][2 - i];
            cube[D][0][2 - i] = tmp;
          }
          break;
        case B:
          for (int i = 0; i < 3; ++i) {
            tmp = cube[R][i][2];
            cube[R][i][2] = cube[D][2][2 - i];
            cube[D][2][2 - i] = cube[L][2 - i][0];
            cube[L][2 - i][0] = cube[U][0][i];
            cube[U][0][i] = tmp;
          }
          break;
        case L:
          for (int i = 0; i < 3; ++i) {
            tmp = cube[U][i][0];
            cube[U][i][0] = cube[B][2 - i][2];
            cube[B][2 - i][2] = cube[D][i][0];
            cube[D][i][0] = cube[F][i][0];
            cube[F][i][0] = tmp;
          }
          break;
        case R:
          for (int i = 0; i < 3; ++i) {
            tmp = cube[U][i][2];
            cube[U][i][2] = cube[F][i][2];
            cube[F][i][2] = cube[D][i][2];
            cube[D][i][2] = cube[B][2 - i][0];
            cube[B][2 - i][0] = tmp;
          }
          break;
        default:
          break;
      }
    }
  }


  private static int parseFace(char c) {
    switch (c) {
      case 'U':
        return U;
      case 'D':
        return D;
      case 'F':
        return F;
      case 'B':
        return B;
      case 'L':
        return L;
      case 'R':
        return R;
      default:
        return -1;
    }
  }

  private static void initCube() {
    cube = new char[6][3][3];
    for (int i = 0; i < 6; ++i) {
      for (int y = 0; y < 3; y++) {
        Arrays.fill(cube[i][y], colors[i]);
      }
    }

  }

}
