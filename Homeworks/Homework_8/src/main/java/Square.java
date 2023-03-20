public class Square extends Shape {

    private String name = "Square";

    public String getName() {return name;}

    @Override
    public void printName(String name) {
        System.out.println(getName());
    }
}
