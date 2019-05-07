package module5.triangle_area;

public class TestTriangleArea {

    public static void main (String[] args){

        Triangle triangleBad = new Triangle();
        Triangle triangleGood = new Triangle();

        triangleBad.vertexA.put("x",3.0);
        triangleBad.vertexA.put("y",2.0);

        triangleBad.vertexB.put("x",3.0);
        triangleBad.vertexB.put("y",2.0);

        triangleBad.vertexC.put("x",0.0);
        triangleBad.vertexC.put("y",0.0);

        try {
            triangleBad.triangleArea();
        } catch (Triangle.AreaCouldNotBeCalculated areaCouldNotBeCalculated) {
            areaCouldNotBeCalculated.printStackTrace();
        }

        triangleGood.vertexA.put("x",3.0);
        triangleGood.vertexA.put("y",2.0);

        triangleGood.vertexB.put("x",7.0);
        triangleGood.vertexB.put("y",5.0);

        triangleGood.vertexC.put("x",0.0);
        triangleGood.vertexC.put("y",0.0);

        try {
            triangleGood.triangleArea();
        } catch (Triangle.AreaCouldNotBeCalculated areaCouldNotBeCalculated) {
            areaCouldNotBeCalculated.printStackTrace();
        }
    }
}
