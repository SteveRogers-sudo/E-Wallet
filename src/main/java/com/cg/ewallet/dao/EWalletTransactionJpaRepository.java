package com.cg.ewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ewallet.entity.Transaction;

public interface EWalletTransactionJpaRepository extends JpaRepository<Transaction,Long>{

}
