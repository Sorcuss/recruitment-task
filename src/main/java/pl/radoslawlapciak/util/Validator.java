package pl.radoslawlapciak.util;

public class Validator {

    public static boolean checkCoordinateBoundBounds(double coordinateToCheck, double coordinateBound) {
        return coordinateToCheck <= coordinateBound && coordinateToCheck >= 0;
    }

    public static boolean validateTextField(String value, double coordinateBound) {
        try {
            double coordinate = Double.parseDouble(value);
            return checkCoordinateBoundBounds(coordinate, coordinateBound);
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
