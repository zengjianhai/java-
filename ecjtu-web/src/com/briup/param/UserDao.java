package com.briup.param;

import java.util.List;

public interface UserDao {
	void saveUser(User user);
	List<User> findUserALlByName(String name);
	User findUserByName(String name);
}
