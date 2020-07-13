package pl.radoslawlapciak.model.repositroy;

import pl.radoslawlapciak.model.Point;

public class PointRepository extends AbstractRepository<Point> {
    @Override
    public void update(Point point) {
        Point pointToUpdate = get(point.getId());
        if(pointToUpdate != null){
            pointToUpdate.setColor(point.getColor());
            pointToUpdate.setX(point.getX());
            pointToUpdate.setY(point.getY());
        }
    }
}
