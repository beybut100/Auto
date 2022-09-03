package com.example.Auto2.dto.user;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name="Session")
public class Session {

    String login;
    @Id
    private Integer id;
    @Column(name="starttime")
    Date starttime;
    @Column(name="finishtime")
    Date finishtime=null;

    @Transient
    Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
