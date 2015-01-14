package com.hiveTown.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HTDaoServiceSingleton {
	/** The context instance. */
	private static ApplicationContext contextInstance = null;
	
	/** The user account dao. */
	private static UserAccountDAO userAccountDao = null;

	/**
	 * Gets the single instance of HTDaoServiceSingleton.
	 * 
	 * @return single instance of HTDaoServiceSingleton
	 */
	public static synchronized ApplicationContext getInstance()
	{
		// singleton pattern is used for ApplicationContext instances
		if (contextInstance == null)
		{
			contextInstance = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		}

		return contextInstance;

	}
	/**
	 * Gets the user account dao.
	 * 
	 * @return the user account dao
	 */
	public static UserAccountDAO getUserAccountDao()
	{
		if (userAccountDao == null)
		{
			userAccountDao = (UserAccountDAO) getInstance().getBean(
					"userAccountDAO");
		}
		return userAccountDao;
	}

}
