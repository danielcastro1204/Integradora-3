package model;

import java.util.Calendar;

public abstract class User {
    
    private String name;
    private String id;
    private Calendar linkingDate;
    
    public User(String name, String id) {

        this.name = name;
        this.id = id;
        this.linkingDate = Calendar.getInstance();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Calendar getLinkingDate() {
        return linkingDate;
    }
    public void setLinkingDate(Calendar linkingDate) {
        this.linkingDate = linkingDate;
    } 
}
