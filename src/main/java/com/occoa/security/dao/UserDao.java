package com.occoa.security.dao;

import com.occoa.security.model.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	@Modifying
	@Query("update security.tb_user u set u.phoneNumber = :phoneNumber, "
				+ "u.type = :type, "
				+ "u.status = :status, "
				+ "u.update_date = :modificationDateTime "
			+ "where u.username = :username")
	void update(@Param("phoneNumber") String phoneNumber,
				@Param("type") String type,
				@Param("status") String status,
				@Param("modificationDateTime") Date modificationDateTime,
				@Param("username") String username);
	
	@Modifying
	@Query("update security.tb_user u set u.status = :status where u.username = :username")
	void updateStatusByUsername(@Param("status") String status, @Param("username") String username);
	
	@Modifying
	@Query("update security.tb_user u set u.password = :password where u.username = :username")
	void updatePasswordByUsername(@Param("password") String password, @Param("username") String username);

	@Modifying
	@Query("delete from security.tb_user u where u.username = :username")
	void deleteByUsername(String username);

	@Query("select * from security.tb_user u where u.username = :username")
	User findByUsername(String username);

}
