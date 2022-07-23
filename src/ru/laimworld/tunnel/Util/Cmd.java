package ru.laimworld.tunnel.Util;

import java.util.Scanner;

public class Cmd implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
