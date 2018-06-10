package com.visit_egypt.visitegypt.server;

import java.io.Serializable;

/**
 * Created by Muhammad on 12/6/2016
 */
public class BaseItem implements Serializable {

    private String ID;
    private String Name;


    public BaseItem(String ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

}
