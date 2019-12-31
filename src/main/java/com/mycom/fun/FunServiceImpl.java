package com.mycom.fun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("Service")
public class FunServiceImpl implements FunService {
    @Autowired
    FunDAO funDAO;

    public List<FunVO> getListFun(FunVO vo) {
        return funDAO.getListFun(vo);
    }

    public FunVO getFun(FunVO vo) {
        return funDAO.getFun(vo);
    }

    public int getCountFun() {
        return funDAO.getCountFun();
    }

    public void insertFun(FunVO vo) {
        funDAO.insertFun(vo);
    }

    public void deleteFun(FunVO vo) {
        funDAO.deleteFun(vo);
    }

    public void updateFun(FunVO vo) {
        funDAO.updateFun(vo);
    }


}
