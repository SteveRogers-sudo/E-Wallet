package com.cg.ewallet.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;



@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="transaction1")
public class Transaction {
	
	public Transaction() {
	
	}

	@Id
	@Column(name="txn_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transaccountId;
	
	@Column(name="txn_type", length=10)
	private String transType;
	
	@Column(name="txn_amt")
	private double transAmount;
	
	@Column(name="txn_dt")
	private LocalDate transDate;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName = "user_id")
	private User user = new User();

	public long getTransaccountId() {
		return transaccountId;
	}

	public void setTransaccountId(long transaccountId) {
		this.transaccountId = transaccountId;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public double getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}

	public LocalDate getTransDate() {
		return transDate;
	}

	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
