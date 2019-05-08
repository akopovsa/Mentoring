package module4.area_calculation;

public class Area extends Shape{

    @Override
    public void rectangleArea(double length, double breadth) {
        double area = length*breadth;
        System.out.printf("Area of rectangle with length: %s and breadth: %s is: %s",length,breadth,area);
        System.out.println();
    }

    @Override
    public void squareArea(double side) {
        double area = side*side;
        System.out.printf("Area of square with side: %s is: %s",side,area);
        System.out.println();
    }

    @Override
    public void circleArea(double radius) {
        double area = 3.14*radius*radius;
        System.out.printf("Area of circle with radius: %s is: %s",radius,area);
        System.out.println();
    }

    public static void main (String[] args){

        Area area = new Area();
        area.rectangleArea(2.0,5.0);
        area.squareArea(2.0);
        area.circleArea(4.0);

    }
}
