package com.vilin.demo.service;

import com.vilin.demo.dao.VerifyDao;
import com.vilin.demo.entity.Verify;

public class VerifyService {

  private VerifyDao verifyDao;

  public VerifyService(VerifyDao verifyDao) {
    this.verifyDao = verifyDao;
  }

  public boolean merge(Verify verify) {
    boolean exists = verifyDao.findVerify(verify);
    if (exists) {
      return verifyDao.updateVerify(verify);
    } else {
      return verifyDao.insertVerify(verify);
    }
  }
}
