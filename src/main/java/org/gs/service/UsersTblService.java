package org.gs.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gs.dto.UpdatePassword;
import org.gs.dto.UpdatePasswordByAdmin;
import org.gs.dto.UserResponse;
import org.gs.entity.UsersTbl;
import org.gs.mapper.UserMapper;
import org.gs.repository.UsersTblRepo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UsersTblService {

    @Inject
    UsersTblRepo usersTblRepo;

    public List<UsersTbl> getAll() {
        return usersTblRepo.listAll();
    }


    @Transactional
    public boolean create(String name, String password, BigDecimal level) {
       UsersTbl userisexist =usersTblRepo.getUser(name);
        if (userisexist!=null) {

            return false ;
        }
        UsersTbl user =new UsersTbl();
        user.setTxtCode(UUID.randomUUID().toString().substring(0,30));
        user.setTxtName(name);
        user.setTxtPwd(password);
        user.setUserStatus(false);
        user.setIntLevel(level);
        usersTblRepo.persist(user);
        return true;
    }


    public List<UsersTbl> Search(String name,int limit,int page)
    {
        return usersTblRepo.findByName(name,limit,page);
    }

    @Transactional
    public String updatePassword(UpdatePassword dto) {
        UsersTbl user = usersTblRepo.findByUsernameAndPassword(dto.getUsername(), dto.getOldPassword());

        if (dto.getOldPassword().equals(dto.getNewPassword())) {
             return "New password cannot be the same as old password";
        }


        if (user==null) {
            return "sorry there not user that have this user name and password";
        }
        user.setTxtPwd(dto.getNewPassword());
        return "Updated succeeded";
    }





    @Transactional
    public String updatePasswordByAdmin(UpdatePasswordByAdmin dto) {
        UsersTbl user = usersTblRepo.getUser(dto.getUsername());
        if (user==null) {
            return "sorry there not user that have this user name and password";
        }
        user.setTxtPwd(dto.getNewPassword());
        return "Updated succeeded";
    }




    @Transactional
    public boolean delete(String username,String password) {
      return usersTblRepo.deleteUser(username,password);
    }
    public UsersTbl findByUsernameAndPassword(String username, String password) {
        return usersTblRepo.findByUsernameAndPassword(username,password);
    }



    public  List<UserResponse> getALlUser(int limit, int page)
    {
        List<UsersTbl> usersTbls=usersTblRepo.GetAllUser(limit,page);

        List<UserResponse> userResponses=new ArrayList<>();
        for(UsersTbl usersTbl: usersTbls)
        {
            userResponses.add(UserMapper.toUser(usersTbl));

        }
       return userResponses;
    }
}
