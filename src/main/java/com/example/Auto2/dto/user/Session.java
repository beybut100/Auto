package com.example.Auto2.dto.user;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Date;

public class Session {

    String login;
    @Id
    private String id;
    Date starttime;
    Date finishtime=null;
    Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public String getLogin() {
        return login;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    private void setStartTime(){
       starttime=new Date(System.currentTimeMillis()) ;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Session(String login) {
        setStartTime();
        this.login=login;
    }

}
