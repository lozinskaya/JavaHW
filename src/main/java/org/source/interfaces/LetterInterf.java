package org.source.interfaces;

import org.model.Letter;
import org.source.implementations.LetterInterfImpl;

import java.sql.Connection;
import java.util.List;

/**
 * Интерфейс для работы с письмами в БД методом <b>findAll</b>.
 * @author Наталья Лозинская
 * @version 1.0
 */
public interface LetterInterf {

    /**
     * Метод для получения всех писем из базы данных
     * @see LetterInterfImpl#findAll
     */
    public List<Letter> findAll();
}
