package org.source.interfaces;

import org.model.Document;

import java.util.List;

public interface SourceInterf {
    /**
     * Метод для получения документов
     *
     * @return список документов
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public List<Document> fetchData() throws InstantiationException, IllegalAccessException;
}
