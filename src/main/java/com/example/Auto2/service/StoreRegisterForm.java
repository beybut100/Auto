package com.example.Auto2.service;

import com.example.Auto2.dao.LoginPasswordsPst;
import com.example.Auto2.dao.SessionPst;
import com.example.Auto2.dao.UserPst;
import com.example.Auto2.dto.user.Location;
import com.example.Auto2.dto.user.Registration.*;
import com.example.Auto2.dto.user.Session;
import com.example.Auto2.dto.user.SessionNotFound;
import com.example.Auto2.dto.user.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StoreRegisterForm {
    LoginPasswordsPst logpassRepository;
    Hashing hashing;
    SessionPst sessionsRepository;
    UserPst users;


    /* Method that limits variants of password */
    public static String CheckPassword(String password) throws InvalidPassword {

        if(password.length()<6||password.length()>12||password.contains(" ")) {
            throw new InvalidPassword("Incorrect password");
        }
        if(true){
            int countdigits=0;
            for(int i=0;i<=9;i++) {
                String str=Integer.toString(i);
                if(password.contains(str)){
                    countdigits=1;
                }
            }
            if(countdigits==0) {
                throw new InvalidPassword("need number");
            }
        }
        if(true) {
            Pattern UpperCasePattern=Pattern.compile("[A-Z]");
            if(!UpperCasePattern.matcher(password).find()) {
                throw new InvalidPassword("need UpperLetter");
            }
        }
        return password;

    }

    public  String checkLogin(String login) throws InvalidLogin {
            if(login.length()>14|login.length()<4) {
                throw new InvalidLogin(1);
            }
            if(logpassRepository.getFirstByLogin(login).isPresent()){
                throw new InvalidLogin(2);
            }
            if(true) {
                Pattern SpecialCasePattern=Pattern.compile("[^a-zA-Z0-9@]");
                Matcher matcher=SpecialCasePattern.matcher(login);
            if(matcher.find()) {
                    throw new InvalidLogin(3);
                }
            }
            return login;
    }

    public LoginAndPassword SaveLoginPassword(String login, String password ) throws InvalidPassword, NoSuchAlgorithmException, InvalidLogin {
        String checkedlogin=checkLogin(login);
    String checkedpassword=CheckPassword(password);
    byte[] salt=Hashing.getSalt();
    System.out.println(Arrays.toString(salt));
    String HashedPassword=Hashing.getSecurePassword(checkedpassword,salt);
    return new LoginAndPassword(checkedlogin,HashedPassword, salt);

    }

    public LoginAndPassword SaveRegForm(String login, String password) throws NoSuchAlgorithmException, InvalidPassword, InvalidLogin {

        return logpassRepository.save(SaveLoginPassword(login,password));
    }
    public Session getAuthorized(String login, String Password) throws UserNotFound,IncorrectPassword {
        Optional<LoginAndPassword> element= logpassRepository.getFirstByLogin(login);
        if(element.isEmpty()) {
            System.out.println("This login doesn't exist");
            throw new UserNotFound("This login doesn't exist");
        }
        String HashedPassword=Hashing.getSecurePassword(Password,element.get().getSalt());
        System.out.println(Arrays.toString(element.get().getSalt()));
        System.out.println(HashedPassword);
        if(!element.get().password.equals(HashedPassword)) {
            System.out.println("Password doen't match");
            throw new IncorrectPassword("Password doen't match");
        }
             return  sessionsRepository.save(new Session(login));
        }

        public void CloseSession(Integer id) {
        Session elem=sessionsRepository.findById(id).get();
        elem.setFinishtime(new Date(System.currentTimeMillis()));
         sessionsRepository.save(elem);

        }
        public void SetLocation(Integer id, Location location) throws SessionNotFound {
        Optional<Session> elem=sessionsRepository.findById(id);
         if(elem.isEmpty()){
             throw new SessionNotFound("Not found session in db");
         }
         Session upelem= elem.get();

         upelem.setLocation(location);
         sessionsRepository.save(upelem);
        }
        public void DeleteOldSessions(int seconds) {
            Date timetodelete=new Date(System.currentTimeMillis()-seconds*1000);
            System.out.println(timetodelete);
           sessionsRepository.deleteByFinishtimeLessThan(timetodelete);
        }


@Autowired
public StoreRegisterForm(LoginPasswordsPst logpassRepository, SessionPst sessionsRepository ) throws NoSuchAlgorithmException, InvalidPassword, InvalidLogin  {
        this.logpassRepository = logpassRepository;
        this.sessionsRepository=sessionsRepository;
        this.users=users;
    }
}

