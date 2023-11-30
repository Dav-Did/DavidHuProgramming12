public abstract class TwoDShape {
    private double width;
    private double height;
    private Colour color;


    public TwoDShape(double width, double height, Colour color){
        // Constructor with width, height and color as three fields.
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public TwoDShape(){
        // Empty constructor
    }

    // Getters and setters

    public abstract double getArea(); // Abstract area getter, overridden in Triangle and Circle classes

    public void setHeight(double newHeight){
        this.height = newHeight;
    }

    public double getHeight(){
        return height;
    }

    public void setWidth(double newWidth){
        this.width = newWidth;
    }

    public double getWidth(){
        return width;
    }

    public void setColor(Colour color) {
        this.color = color;
    }

    public Colour getColor() {
        return color;
    }

    // Returns the variables of the object in a single string, overridden in Triangle and Circle
    public String toString() {
        String strWidth = Double.toString(width);
        String strHeight = Double.toString(height);
        String strArea = Double.toString(getArea());
        return "Width: " + strWidth + " Height: " + strHeight;
    }


    
}
