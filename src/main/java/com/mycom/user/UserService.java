package com.mycom.user;

import java.util.List;

public interface UserService {
    void insertUser(UserVO vo);
    List<UserVO> getListUser();
    UserVO getUser(UserVO vo);
    int getCountUser();
}
