package org.gs.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gs.entity.UsersTbl;
import org.gs.repository.UsersTblRepo;

@ApplicationScoped
public class LogoutService {
    @Inject
    UsersTblRepo userRepository;

    @Transactional
    public boolean deletToken(String token)
    {

        UsersTbl usersTbl=userRepository.getUserByToken(token);
        if(usersTbl==null)
        {
            return false;

        }
        usersTbl.setActiveToken("");
        return true;

    }


}
