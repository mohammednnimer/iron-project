package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.UsersTbl;

import java.util.List;

@ApplicationScoped
public class UsersTblRepo implements PanacheRepository<UsersTbl> {


    public List<UsersTbl> GetAllUser(int limit, int page) {
        int offset = (page-1) * limit;
        return find("userStatus = false ").range(offset,offset+ limit - 1).list();
    }

    public UsersTbl getUser(String name) {
        return find("txtName = ?1", name).firstResult();
    }

     public boolean deleteUser(String name, String password) {
        return delete("txtName = ?1 AND txtPwd = ?2", name, password) > 0;
    }

    public UsersTbl getUserByToken(String token ) {
        return find("activeToken = ?1", token).firstResult();
    }

    public UsersTbl findByUsername(String username) {
        return find("txtName like ?1 and userStatus = false", username).firstResult();
    }
    public List<UsersTbl> findByName(String username,int limit,int page) {

        int offset = (page - 1) * limit;
        return find("LOWER(txtName) LIKE ?1 AND userStatus = false", "%" + username.toLowerCase() + "%")
                .range(offset, offset + limit - 1).list();

    }




    public UsersTbl findByUsernameAndPassword(String username, String password) {
        return find("txtName = ?1 and txtPwd = ?2 and userStatus = false", username, password).firstResult();
    }

    public UsersTbl findByUserCode(String userCode) {
        // and userStatus = false
        return find("txtCode = ?1 and userStatus = false ", userCode).firstResult();
    }
    }

