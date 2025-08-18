package org.gs.mapper;

import org.gs.dto.UserResponse;
import org.gs.entity.UsersTbl;

public class UserMapper {





    public static UserResponse toUser(UsersTbl usersTbl)
    {

        UserResponse userResponse=new UserResponse();
        userResponse.setIntLevel(usersTbl.getIntLevel());
        userResponse.setTxtName(usersTbl.getTxtName());
        return userResponse;

    }
}
