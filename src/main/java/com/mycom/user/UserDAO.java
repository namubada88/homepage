package com.mycom.user;

import com.mycom.board.BoardVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO extends SqlSessionDaoSupport {
    private int countUser;

    public int getCountUser() { return this.countUser; }

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public void insertUser(UserVO vo){
        System.out.println("===> MyBatis로 insertUser() 기능 처리");
        getSqlSession().insert("AllDAO.insertUser",vo);
    }

    public List<UserVO> getListUser(){
        System.out.println("===> MyBatis로 getListUser() 기능 처리");
        List<UserVO> listBoard = new ArrayList<UserVO>();

        listBoard = getSqlSession().selectList("AllDAO.getListUser");
        this.countUser = getSqlSession().selectOne("AllDAO.getUserCount");

        return listBoard;
    }

    public UserVO getUser(UserVO vo){
        System.out.println("===> MyBatis로 getUser() 기능 처리");
        return (UserVO) getSqlSession().selectOne("AllDAO.getUser",vo);
    }
}
