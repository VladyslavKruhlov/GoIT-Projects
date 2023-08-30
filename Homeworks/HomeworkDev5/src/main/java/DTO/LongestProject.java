package DTO;

public class LongestProject {
    String name ;
    int monthCount;

    public LongestProject(String name, int monthCount) {
        this.name = name;
        this.monthCount = monthCount;
    }
    public String getName() {
        return name;
    }
    public int getMonthCount() {
        return monthCount;
    }
}
