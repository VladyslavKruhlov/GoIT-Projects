package DTO;

public class MaxProjectClient {

    String name ;
    int projectCount;

    public MaxProjectClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return name;
    }

    public int getProjectCount() {
        return projectCount;
    }
}