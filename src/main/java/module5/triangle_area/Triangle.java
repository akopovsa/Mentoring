package module5.triangle_area;

import java.util.HashMap;
import java.util.Map;

public class Triangle {

    Map<String, Double> vertexA = new HashMap<>();
    Map<String, Double> vertexB = new HashMap<>();
    Map<String, Double> vertexC = new HashMap<>();


    void triangleArea() throws AreaCouldNotBeCalculated {
        double area;
        area = 0.5*((vertexA.get("x")-vertexC.get("x")) * (vertexB.get("y")-vertexC.get("y")) - (vertexB.get("x")-vertexC.get("x")) * (vertexA.get("y")-vertexC.get("y")));

        if (area <= 0){
            throw new AreaCouldNotBeCalculated("Area could not be calculated! Looks like some vertices are intersecting!" + " A("+vertexA.get("x")+","+vertexA.get("y")+")"+ ", B("+vertexB.get("x")+","+vertexB.get("y")+")"+", C("+vertexC.get("x")+","+vertexC.get("y")+")");
        }

        System.out.printf("Area of triangle with vertex A(%s,%s), B(%s,%s), C(%s,%s) is: %s",vertexA.get("x"),vertexA.get("y"),vertexB.get("x"),vertexB.get("y"),vertexC.get("x"),vertexC.get("y"),area);
    }

    class AreaCouldNotBeCalculated extends Exception {

        AreaCouldNotBeCalculated(String message) {
            super(message);
        }
    }

}
