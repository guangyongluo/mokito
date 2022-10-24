package com.vilin.demo.controller;

import com.vilin.demo.dao.AccountDao;
import com.vilin.demo.entity.Account;

import javax.servlet.http.HttpServletRequest;

public class AccountLoginController {

  private AccountDao accountDao;

  public AccountLoginController(AccountDao accountDao){
    this.accountDao = accountDao;
  }

  public String login(HttpServletRequest request) {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    try{
      Account account = accountDao.findAccount(username, password);
      if(account == null){
        return "/login.html";
      }else {
        return "/index.html";
      }
    }catch (Exception e){
      return "/505.html";
    }
  }
}
