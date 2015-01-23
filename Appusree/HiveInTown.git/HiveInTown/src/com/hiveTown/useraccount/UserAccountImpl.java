package com.hiveTown.useraccount;

import com.hiveTown.Exception.HTWebConsoleException;
import com.hiveTown.dao.HTDaoServiceSingleton;
import com.hiveTown.dao.UserAccountDAO;

public class UserAccountImpl {

	UserAccountDAO user = HTDaoServiceSingleton.getUserAccountDao();

	public boolean isUserValid(String emailId) {
		boolean isUserAvailable = false;
		try {
			isUserAvailable = user.getUsersByEmail(emailId);
		} catch (HTWebConsoleException e) {
			// TODO LOG
			e.printStackTrace();
		}
		return isUserAvailable;

	}
}
