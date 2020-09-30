package com.cg.ewallet.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.ewallet.entity.Transaction;
import com.cg.ewallet.entity.User;

@Repository
public class EWalletDaoImpl implements EWalletDao{
	
	@PersistenceContext
	private EntityManager em;
	
	public User viewUser(String userId) {
		return em.find(User.class, userId);
	}

	@Override
	public boolean addUser(User user) {
		em.persist(user);
		return true;
		
	}

	@Override
	public boolean editUser(User user) {
		em.merge(user);
		return true;
	}

	@Override
	public boolean addTransaction(Transaction transaction) {
		em.persist(transaction);
		return true;
	}

}
