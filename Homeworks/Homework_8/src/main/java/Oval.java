public class Oval extends Shape{

    private String name = "Oval";

    public String getName() {return name;}

    @Override
    public void printName (String name){
        System.out.println(getName());
    }
}
