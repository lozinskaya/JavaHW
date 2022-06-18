package org.menu.interfaces;

import java.io.IOException;

/**
 * Интерфейс меню с методами <b>print</b> и <b>read</b>.
 *
 * @author Наталья Лозинская
 * @version 1.0
 */
public interface MenuInterf {

    public void run() throws IOException;

    /**
     * Метод для чтения ответа
     *
     * @param answer ответ пользователя
     */
    public char read(char answer) throws IOException;

    public char getSimple();

    public String getResultTo();

    public String getOutputTo();
}
