package com.otp.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.otp.entity.User;
import com.otp.util.HibernateUtil;

public class UserDAO {
  public boolean saveUser(User user) {
	 try {
		 Session session = HibernateUtil.getSessionFactory().openSession();
		  Transaction tx = session.beginTransaction();
		  session.save(user);
		  tx.commit();
		  session.close();
		  return true;
	 }
	 catch(Exception e) {
		 e.printStackTrace();
		 return false;
	 }
  }
}
