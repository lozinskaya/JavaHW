package org.source.interfaces;

import org.model.Document;

import java.util.List;

public interface SourceInterf {
    public List<Document> fetchData() throws InstantiationException, IllegalAccessException;
}
