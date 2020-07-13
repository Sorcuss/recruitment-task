package pl.radoslawlapciak.model.repositroy;

import pl.radoslawlapciak.model.Identifiable;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T extends Identifiable> implements Repository<T> {

    protected List<T> items = new ArrayList<>();

    @Override
    public void add(T t) {
        items.add(t);
    }

    @Override
    public T get(int id) {
        return items.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public abstract void update(T t);


    @Override
    public void remove(T t) {
        items.remove(t);
    }

    @Override
    public List<T> getAll() {
        return items;
    }
}
