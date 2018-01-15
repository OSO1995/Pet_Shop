package main;

import contexts.Context;

import java.util.Random;

class Main {

  static Random random = new Random(10);

  public static void main(String[] args) {
    try {
      Context.getEmulator().start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


