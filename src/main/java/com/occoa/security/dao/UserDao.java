package com.occoa.security.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.occoa.security.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	@Modifying
	@Query("update User u set u.email = :email, "
				+ "u.phoneNumber = :phoneNumber, "
				+ "u.type = :type, "
				+ "u.status = :status, "
				+ "u.modificationDateTime = :modificationDateTime "
			+ "where u.username = :username")
	void update(@Param("email") String email,
				@Param("phoneNumber") String phoneNumber,
				@Param("type") String type,
				@Param("status") String status,
				@Param("modificationDateTime") Date modificationDateTime,
				@Param("username") String username);
	
	@Modifying
	@Query("update User u set u.status = :status where u.username = :username")
	void updateStatusByUsername(@Param("status") String status, @Param("username") String username);
	
	@Modifying
	@Query("update User u set u.password = :password where u.username = :username")
	void updatePasswordByUsername(@Param("password") String password, @Param("username") String username);
	
	void deleteByUsername(String username);
	
	User findByUsername(String username);

}
