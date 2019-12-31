package com.mycom.fun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainFunDAO {
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    private final String LIST_FUN = "select * from FUN order by num desc limit 0,5";

    public List<FunVO> getMainFun() throws SQLException {
        System.out.println("===> JDBC로 getMainFun() 접속");
        List<FunVO> li = new ArrayList<FunVO>();
        conn = com.mycom.fun.JDBCUtil.getConnection();
        pstmt = conn.prepareStatement(LIST_FUN);
        rs = pstmt.executeQuery();
        rs.next();
        do{
            FunVO vo = new FunVO();
            vo.setNum(rs.getInt("num"));
            vo.setSubject(rs.getString("subject"));
            vo.setWriter(rs.getString("writer"));
            li.add(vo);
        }while(rs.next());

        JDBCUtil.closeConnection(conn,pstmt,rs);
        return li;
    }
}
