package com.mycom.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDAO boardDAO;

    public List<BoardVO> getListBoard(int minLimit, int maxLimit) {
        return boardDAO.getListBoard(minLimit, maxLimit);
    }

    public BoardVO getBoard(BoardVO vo) {
        return boardDAO.getBoard(vo);
    }


    public void insertBoard(BoardVO vo) {
        boardDAO.insertBoard(vo);
    }

    public void updateBoard(BoardVO vo) {
        boardDAO.updateBoard(vo);
    }

    public void deleteBoard(BoardVO vo) {
        boardDAO.deleteBoard(vo);
    }


    public int getTotalCount() {
        return boardDAO.getTotalCount();
    }
}
