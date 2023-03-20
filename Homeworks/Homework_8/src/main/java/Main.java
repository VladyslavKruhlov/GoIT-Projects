public class Main {
    public static void main(String[] args){

        Circle circle = new Circle();
        GetFigure getFigureCircle = new GetFigure(circle);
        System.out.println(getFigureCircle.displayNameOfFigure());

        Quad quad = new Quad();
        GetFigure getFigureQuad = new GetFigure(quad);
        System.out.println(getFigureQuad.displayNameOfFigure());

        Square square = new Square();
        GetFigure getFigureSquare = new GetFigure(square);
        System.out.println(getFigureSquare.displayNameOfFigure());

        Triangle triangle = new Triangle();
        GetFigure getFigureTriangle = new GetFigure(triangle);
        System.out.println(getFigureTriangle.displayNameOfFigure());

        Oval oval = new Oval();
        GetFigure getFigureOval = new GetFigure(oval);
        System.out.println(getFigureOval.displayNameOfFigure());
    }
}
