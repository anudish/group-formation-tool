package com.group3.BusinessModels;

public class GuestModel extends Person {

    public GuestModel(String lastName, String firstName, String email, String role, String psw) {
        super(lastName,  firstName,  email, role,  psw);
    }

    public GuestModel() {
        super();
    }

}
