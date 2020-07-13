package pl.radoslawlapciak.model.repositroy;

import pl.radoslawlapciak.model.Identifiable;

import java.util.List;

public interface Repository<T extends Identifiable> {
    void add(T t);
    T get(int id);
    void update(T t);
    void remove(T t);
    List<T> getAll();
}
