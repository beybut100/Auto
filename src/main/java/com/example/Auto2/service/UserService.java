package com.example.Auto2.service;

import com.example.Auto2.dao.SessionPst;
import com.example.Auto2.dao.UserPst;
import com.example.Auto2.dto.user.*;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {
    UserPst repository;
    SessionPst sessionrepository;

    public User SaveUserData(Integer sessionid, String email) throws SessionNotFound, LocationNotDetectedException {
      Optional<Session> sessionbyid= sessionrepository.findById(sessionid);
     if(sessionbyid.isEmpty()) {
       throw  new SessionNotFound("not found session");
     }
     Session session=sessionbyid.get();
     if(session.getLocation()==null) {
      throw  new   LocationNotDetectedException("This element doesn't have location");
     }
    User f=new User();
    return repository.save(new User(session.getLogin(),email,new Location(session.getLocation().getLatitude(),session.getLocation().getLongitude())));
    }


    public SessionPst getSessionrepository() {
        return sessionrepository;
    }

    public void setSessionrepository(SessionPst sessionrepository) {
        this.sessionrepository = sessionrepository;
    }

    public UserService(UserPst repository, SessionPst sessionrepository) {
        this.repository = repository;
        this.sessionrepository = sessionrepository;
    }

    public UserPst getRepository() {
        return repository;
    }

    public void setRepository(UserPst repository) {
        this.repository = repository;
    }

    public boolean IsExistSession(Integer id) {

    return sessionrepository.existsById(id);
    }
}
