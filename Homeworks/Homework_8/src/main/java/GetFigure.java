public class GetFigure {
    public String figureName;

    public GetFigure(Shape shape){
        this.figureName = shape.getName();
    }

    public String displayNameOfFigure(){
        return figureName;
    }
}
