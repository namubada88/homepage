package com.mycom.fun;

import java.util.List;

public interface FunService {
    List<FunVO> getListFun(FunVO vo);
    FunVO getFun(FunVO vo);
    int getCountFun();
    void insertFun(FunVO vo);
    void deleteFun(FunVO vo);
    void updateFun(FunVO vo);

}
