package org.example.staffs;

import org.example.entities.Person;

public class Staff extends Person {

    protected String StaffId;


    public Staff(String name, String staffId) {
        super(name);
        StaffId = staffId;

    }


    public String getStaffId() {
        return StaffId;
    }

    public void setStaffId(String staffId) {

        StaffId = staffId;
    }

}
