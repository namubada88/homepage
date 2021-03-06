package com.mycom.board;

import java.util.List;

public interface BoardService {
    List<BoardVO> getListBoard(BoardVO vo);
    BoardVO getBoard(BoardVO vo);
    void insertBoard(BoardVO vo);
    void updateBoard(BoardVO vo);
    void deleteBoard(BoardVO vo);
    int getTotalCount();
}
