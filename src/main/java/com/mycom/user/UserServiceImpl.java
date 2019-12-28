package com.mycom.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    public void insertUser(UserVO vo) {
        userDAO.insertUser(vo);
    }


    public List<UserVO> getListUser() {
        return userDAO.getListUser();
    }

    public UserVO getUser(UserVO vo) {
        return userDAO.getUser(vo);
    }


    public int getCountUser() {
        return userDAO.getCountUser();
    }

}
