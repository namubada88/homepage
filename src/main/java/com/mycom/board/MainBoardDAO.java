package com.mycom.board;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import sun.applet.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainBoardDAO {
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    private final String LIST_BOARD = "select * from BOARD order by num desc limit 0,5";

    public List<BoardVO> getMainBoard() throws SQLException {
        System.out.println("===> JDBC로 getMainBoard() 접속");
        List<BoardVO> li = new ArrayList<BoardVO>();
        conn = JDBCUtil.getConnection();
        pstmt = conn.prepareStatement(LIST_BOARD);
        rs = pstmt.executeQuery();
        rs.next();
        do{
            BoardVO vo = new BoardVO();
            vo.setNum(rs.getInt("num"));
            vo.setSubject(rs.getString("subject"));
            vo.setWriter(rs.getString("writer"));
            li.add(vo);
        }while(rs.next());

        JDBCUtil.closeConnection(conn,pstmt,rs);
        return li;
    }
}
