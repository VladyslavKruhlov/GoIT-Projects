public class Circle extends Shape {

    private String name = "Circle";

    public String getName() {return name;}

    @Override
    public void printName (String name){
        System.out.println(getName());
    }
}
