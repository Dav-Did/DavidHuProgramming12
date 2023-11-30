public abstract class TwoDShape {
    private double width;
    private double height;


    public TwoDShape(double width, double height){
        this.width = width;
        this.height = height;
    }

    public TwoDShape(){

    }

    public abstract double getArea();

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

    public String toString() {
        String strWidth = Double.toString(width);
        String strHeight = Double.toString(height);
        return "Width: " + strWidth + " Height: " + strHeight;
    }

    public double getNumber(){
        return 1.0;
    }

    
}
