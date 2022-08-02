package com.example.Auto2.service;

import com.example.Auto2.dao.Sessions;
import com.example.Auto2.dao.Users;
import com.example.Auto2.dto.user.*;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {
    Users repository;
    Sessions sessionrepository;

    public User SaveUserData(String sessionid, String email) throws SessionNotFound, LocationNotDetectedException {
      Optional<Session> sessionbyid= sessionrepository.findById(sessionid);
     if(sessionbyid.isEmpty()) {
       throw  new SessionNotFound("not found session");
     }
     Session session=sessionbyid.get();
     if(session.getLocation()==null) {
      throw  new   LocationNotDetectedException("This element doesn't have location");
     }
    User f=new User();
    return repository.insert(new User(session.getLogin(),email,new Location(session.getLocation().getLatitude(),session.getLocation().getLongitude())));
    }


    public Sessions getSessionrepository() {
        return sessionrepository;
    }

    public void setSessionrepository(Sessions sessionrepository) {
        this.sessionrepository = sessionrepository;
    }

    public UserService(Users repository, Sessions sessionrepository) {
        this.repository = repository;
        this.sessionrepository = sessionrepository;
    }

    public Users getRepository() {
        return repository;
    }

    public void setRepository(Users repository) {
        this.repository = repository;
    }

    public boolean IsExistSession(String id) {

    return sessionrepository.existsById(id);
    }
}
