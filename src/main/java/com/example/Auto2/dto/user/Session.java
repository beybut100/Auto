package com.example.Auto2.dto.user;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name="session")
@TypeDef(name = "json", typeClass = JsonBinaryType.class)
public class Session {

    String login;
    @Id
    @GeneratedValue
 /*   @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @ org.hibernate.annotations.Parameter(name = "sequence_name", value = "session_id")
            }
    ) */
    private Integer id;
    @Column(name="starttime")
    Date starttime;
    @Column(name="finishtime")
    Date finishtime=null;

    @Type(type = "json")
    @Column(name = "location", columnDefinition = "text")
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

    public Session() {
    }

    public Session(String login) {
        setStartTime();
        this.login=login;
    }

}
