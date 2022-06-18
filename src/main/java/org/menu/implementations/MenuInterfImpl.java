package org.menu.implementations;

import org.menu.interfaces.MenuInterf;

import java.io.IOException;
import java.util.Scanner;

public class MenuInterfImpl implements MenuInterf {
    private String resultTo = "console";
    private String outputTo = "file";
    private char simple = 'y';
    private final static Scanner scanner = new Scanner(System.in);

    public void run() throws IOException {
        System.out.print("Хотите настроить вывод перед начало работы ? (y/n)");
        char answer = read(scanner.next().charAt(0));
        switch (answer) {
            case 'y':
                setSimple();
                setResultTo();
                setOutputTo();
                break;
            case 'n':
                break;
        }
    }

    public char read(char answer) throws IOException {
        if (answer != 'y' & answer != 'n') throw new IOException("Введены неверные данные");
        return answer;
    }

    @Override
    public char getSimple() {
        return simple;
    }

    public String getResultTo() {
        return resultTo;
    }

    private void setResultTo() throws IOException {
        System.out.print("Выводить информацию о документах и сотрудниках в файл (иначе в консоль) ? (y/n)");
        this.resultTo = read(scanner.next().charAt(0)) == 'y' ? "file" : "console";
    }

    public String getOutputTo() {
        return outputTo;
    }

    private void setOutputTo() throws IOException {
        System.out.print("Выводить статистику в файл (иначе в консоль) ? (y/n)");
        this.outputTo = read(scanner.next().charAt(0)) == 'y' ? "file" : "console";
    }

    private void setSimple() throws IOException {
        System.out.print("Выводить краткую информацию о документах ? (y/n)");
        this.simple = read(scanner.next().charAt(0));
    }
}
