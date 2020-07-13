package pl.radoslawlapciak.model;

public class Color {

    private short redColorValue;
    private short greenColorValue;
    private short blueColorValue;

    public Color(short redColorValue, short greenColorValue, short blueColorValue) {
        setRedColorValue(redColorValue);
        setGreenColorValue(greenColorValue);
        setBlueColorValue(blueColorValue);
    }

    public short getRedColorValue() {
        return redColorValue;
    }

    public void setRedColorValue(short redColorValue) {
        checkIfColorValueIsCorrect(redColorValue);
        this.redColorValue = redColorValue;
    }

    public short getGreenColorValue() {
        return greenColorValue;
    }

    public void setGreenColorValue(short greenColorValue) {
        checkIfColorValueIsCorrect(redColorValue);
        this.greenColorValue = greenColorValue;
    }

    public short getBlueColorValue() {
        return blueColorValue;
    }

    public void setBlueColorValue(short blueColorValue) {
        checkIfColorValueIsCorrect(redColorValue);
        this.blueColorValue = blueColorValue;
    }

    private void checkIfColorValueIsCorrect(short value){
        if(value > 255 || value < 0){
            throw new IllegalArgumentException("color value must be between 0 and 255");
        }
    }
}
