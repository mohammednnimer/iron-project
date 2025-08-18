package org.gs.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gs.entity.UsersTbl;
import org.gs.repository.UsersTblRepo;

import java.math.BigDecimal;

@ApplicationScoped
public class LoginService {

    @Inject
    UsersTblRepo userRepository;

    public UsersTbl authenticate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    public String getUserRole(BigDecimal level) {
        if (level != null && level.compareTo(BigDecimal.ONE) == 0) {
            return "ADMIN";
        } else {
            return "EMPLOYEE";
        }
    }

    @Transactional
    public void updateUserToken(UsersTbl user, String token) {
        user.setActiveToken(token);
        userRepository.persist(user);
    }
}
