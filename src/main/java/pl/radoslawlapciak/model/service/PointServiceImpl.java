package pl.radoslawlapciak.model.service;

import pl.radoslawlapciak.model.Point;
import pl.radoslawlapciak.model.repositroy.Repository;

import java.util.List;

public class PointServiceImpl implements PointService {

    Repository<Point> points;

    public PointServiceImpl(Repository<Point> points) {
        this.points = points;
    }

    @Override
    public void add(Point point) {
        points.add(point);
    }

    @Override
    public Point get(int id) {
        return points.get(id);
    }

    @Override
    public void update(Point point) {
        points.update(point);
    }

    @Override
    public void remove(Point point) {
        points.remove(point);
    }

    @Override
    public List<Point> getAll() {
        return points.getAll();
    }

}
