public class Triangle extends Shape{

    private String name = "Triangle";

    public String getName() {return name;}

    @Override
    public void printName(String name) {
        System.out.println(getName());
    }
}
