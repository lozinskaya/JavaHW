package org.dao.interfaces;

import org.classes.Letter;
import org.dao.implementations.LetterInterfImpl;

import java.util.List;

/**
 * Интерфейс объекта Письмо с методом <b>findAll</b>.
 * @author Наталья Лозинская
 * @version 1.0
 */
public interface LetterInterf {

    /**
     * Интерфейс для получения всех писем из базы данных
     * @see LetterInterfImpl#findAll
     */
    public List<Letter> findAll();
}
