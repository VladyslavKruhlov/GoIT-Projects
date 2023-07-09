package org.myName;

import lombok.Data;

@Data

public class UserDTO {

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}