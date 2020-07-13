package pl.radoslawlapciak.model.service;

import pl.radoslawlapciak.model.Point;

import java.util.List;

public interface PointService {

    void add(Point point);
    Point get(int id);
    void update(Point point);
    void remove(Point point);
    List<Point> getAll();
}
