package com.dukcode.barkingdog.linked_list;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class B1406 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    LinkedList<Character> str = br.readLine()
        .chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.toCollection(LinkedList::new));
    int m = Integer.parseInt(br.readLine());

    ListIterator<Character> it = str.listIterator(str.size());
    for (int i = 0; i < m; ++i) {
      String command = br.readLine();

      switch (command) {
        case "L":
          if (it.hasPrevious()) {
            it.previous();
          }
          break;
        case "D":
          if (it.hasNext()) {
            it.next();
          }
          break;
        case "B":
          if (it.hasPrevious()) {
            it.previous();
            it.remove();
          }
          break;
        default:
          String[] tokens = command.split(" ");
          char c = tokens[1].charAt(0);
          it.add(c);
          break;
      }
    }

    for (Character c : str) {
      bw.write(c);
    }

    br.close();
    bw.close();

  }

}
