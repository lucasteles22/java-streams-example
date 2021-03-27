package com.streams.example.io;

import java.util.Arrays;
import java.util.Scanner;

public class Greeting {

    private static final int[] COMMANDS = { 1, 2, 3 };

    public static int input() {
        Scanner sc = new Scanner(System.in);
        do {
            hello();
            var option = sc.nextLine();
            try {
                if (option.equals("q")) exit();

                int command = Integer.parseInt(option);
                if (Arrays.stream(COMMANDS).anyMatch(x -> x == command)) return command;

                throw new Exception("Wrong command");
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Wrong command! Repeat please!!!");
            }
        } while (true);
    }

    private static void hello() {
        System.out.println("Press a number to run the command:");
        System.out.println("<1> - Run sequential");
        System.out.println("<2> - Run sync stream");
        System.out.println("<3> - Run parallel stream");
        System.out.println("<q> - PRESS q FOR EXIT");
    }

    private static void exit() {
        System.out.println("Bye Bye!!");
        System.exit(0);
    }
}
