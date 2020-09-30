package com.cg.ewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ewallet.entity.User;

@Repository
public interface EWalletJpaRepository extends JpaRepository<User,String> {
	
//	@Modifying
	//@Query("UPDATE USER usr SET usr.userBalance=:amount WHERE usr.userId=:uid")
	//public void updateUser(@Param("amount") double amount ,@Param("uid") String uid);
	
//	@Query("UPDATE USER usr SET usr.userBalance=?1 WHERE usr.userId=?2")
//	public void updateUser(double amount ,String uid);
}
