package com.tc.dao;

import com.tc.model.User;

public interface UserDAO {

	public int addUser(User u);
	public int getUserByEmail(String email);
	public User getUserByEmail(String email,String password);
	public void updateUser(User u);

}
