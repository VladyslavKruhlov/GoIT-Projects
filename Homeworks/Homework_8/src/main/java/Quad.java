public class Quad extends Shape{

    private String name = "Quad";

    public String getName() {return name;}

    @Override
    public void printName(String name) {
        System.out.println(getName());
    }
}
