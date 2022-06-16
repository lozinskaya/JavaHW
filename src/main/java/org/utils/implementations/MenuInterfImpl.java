package org.utils.implementations;

import org.utils.interfaces.MenuInterf;

import java.io.IOException;
public class MenuInterfImpl implements MenuInterf {

    private String question;

    public MenuInterfImpl() {
        question = "Выводить краткую информацию о документах ? (y/n) ";
    }

    @Override
    public char run() throws IOException {
        System.out.print(question);
        return read((char) System.in.read());
    }

    @Override
    public char read(char answer) throws IOException {
        if (answer != 'y' & answer != 'n') throw new IOException("Введены неверные данные");
        System.out.println("Ввели " + answer);
        return answer;
    }
}
