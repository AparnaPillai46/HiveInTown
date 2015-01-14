package com.hiveTown.dao;
import com.hiveTown.Exception.HTWebConsoleException;
import com.hiveTown.dao.HTDaoServiceSingleton;
import com.hiveTown.dao.UserAccountDAO;


public class test {
	static UserAccountDAO user = HTDaoServiceSingleton
			.getUserAccountDao();

	public static void main(String[] args) throws HTWebConsoleException {
		System.out.println(user.getUsersByEmail("a@a.com"));
	}

}
