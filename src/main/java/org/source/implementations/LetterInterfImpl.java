package org.source.implementations;

import org.model.Letter;
import org.source.interfaces.LetterInterf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс имплементирующий интерфейс {@link LetterInterf} с определенным методом <b>findAll</b>.
 * @author Наталья Лозинская
 * @version 1.0
 */
public class LetterInterfImpl implements LetterInterf {

    private Connection conn;
    private char simple;

    public LetterInterfImpl(Connection conn, char simple) {
        this.conn = conn;
        this.simple = simple;
    }

    /**
     * Метод для получения всех писем из базы данных
     * @see LetterInterf#findAll
     */
    @Override
    public List<Letter> findAll() {
        List<Letter> result = new ArrayList<>();
        String SQL_SELECT = "Select * from javahw.public.letters l left join javahw.public.document d on l.document_id=d.id";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int number = resultSet.getInt("document_id");
                String title = resultSet.getString("title");
                String from = resultSet.getString("letter_from");
                String to = resultSet.getString("letter_to");

                Letter letter = new Letter(number, simple);
                letter.setTo(to);
                letter.setFrom(from);
                letter.setTitle(title);
                result.add(letter);
            }


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return result;
    }
}
