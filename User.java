package Entities;

import java.util.Date;

public class User {

    public static int counter = 1;
    private int userId;

    private String firstName;
    private String lastName;

    private Date registrationTimestamp;

    public User(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.registrationTimestamp = new Date();
            this.userId = counter;
            counter++;
        }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return firstName+" "+lastName;
    }

    public Date getRegistrationTime() {
        return registrationTimestamp;
    }

}

