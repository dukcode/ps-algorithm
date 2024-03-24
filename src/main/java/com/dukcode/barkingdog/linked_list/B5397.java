package com.dukcode.barkingdog.linked_list;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class B5397 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      String str = br.readLine();

      LinkedList<Character> list = new LinkedList<>();
      ListIterator<Character> it = list.listIterator();

      for (char ch : str.toCharArray()) {
        switch (ch) {
          case '-':
            if (it.hasPrevious()) {
              it.previous();
              it.remove();
            }
            break;
          case '<':
            if (it.hasPrevious()) {
              it.previous();
            }
            break;
          case '>':
            if (it.hasNext()) {
              it.next();
            }
            break;
          default:
            it.add(ch);
            break;
        }
      }

      for (Character ch : list) {
        bw.write(ch);
      }
      bw.newLine();
    }

    br.close();
    bw.close();

  }

}
