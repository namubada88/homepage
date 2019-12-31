package com.mycom.board;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BoardDAO extends SqlSessionDaoSupport {
    /*전체 record 수*/
    private int totalCount;

    public int getTotalCount() {
        return this.totalCount;
    }

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<BoardVO> getListBoard(BoardVO vo) {
        System.out.println("===> MyBatis로 getListBoard() 기능 처리");
        List<BoardVO> listBoard = new ArrayList<BoardVO>();
        /*limit min, max*/
        listBoard = getSqlSession().selectList("AllDAO.getListBoard", vo);
        this.totalCount = getSqlSession().selectOne("AllDAO.getTotalPaging");
        return listBoard;
    }

    public BoardVO getBoard(BoardVO vo){
        System.out.println("===> MyBatis로 getBoard() 기능 처리");
        return (BoardVO) getSqlSession().selectOne("AllDAO.getBoard", vo);
    }

    public void insertBoard(BoardVO vo){
        System.out.println("===> MyBatis로 insertBoard() 기능 처리");
        getSqlSession().insert("AllDAO.insertBoard", vo);
    }

    public void updateBoard(BoardVO vo){
        System.out.println("===> MyBatis로 updateBoard() 기능 처리");
        getSqlSession().update("AllDAO.updateBoard", vo);
    }

    public void deleteBoard(BoardVO vo){
        System.out.println("===> MyBatis로 deleteBoard() 기능 처리");
        getSqlSession().delete("AllDAO.deleteBoard", vo);
    }

}
