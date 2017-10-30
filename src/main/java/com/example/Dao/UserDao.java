package com.example.Dao;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bean.User;

@Repository
@Table(name = "user")
@Qualifier("UserDao")
public interface UserDao extends CrudRepository<User, Long> {



	@Query("select t from User t where t.userName=:userName")
	public User findUserByName(@Param("userName") String name);

}
