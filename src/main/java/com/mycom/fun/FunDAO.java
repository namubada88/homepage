package com.mycom.fun;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FunDAO extends SqlSessionDaoSupport {
    private int countFun;

    public int getCountFun(){return this.countFun;}

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<FunVO> getListFun(FunVO vo){
        System.out.println("===> MyBatis로 getListFun() 기능 처리");
        List<FunVO> listFun = new ArrayList<FunVO>();
        listFun = getSqlSession().selectList("AllDAO.getListFun", vo);
        this.countFun = getSqlSession().selectOne("AllDAO.getCountFun");
        return listFun;
    }

    public void insertFun(FunVO vo){
        System.out.println("===> MyBatis로 insertFun() 기능 처리");
        System.out.println("DAO writer : " + vo.getWriter());
        getSqlSession().insert("AllDAO.insertFun", vo);
    }

    public FunVO getFun(FunVO vo){
        System.out.println("===> MyBatis로 getFun() 기능 처리");
        return (FunVO) getSqlSession().selectOne("AllDAO.getFun", vo);
    }

    public void deleteFun(FunVO vo){
        System.out.println("===> MyBatis로 deleteFun() 기능 처리");
        getSqlSession().delete("AllDAO.deleteFun", vo);
    }

    public void updateFun(FunVO vo){
        System.out.println("===> MyBatis로 updateFun() 기능 처리");
        getSqlSession().update("AllDAO.updateFun", vo);
    }

}
