package makemyportfolio.dao.unitest;

import makemyportfolio.dao.UserDao;
import makemyportfolio.dao.daofactory.UserDaoFactory;

public class UserDaoUniTester {

	public static void main(String[] args) {
		UserDao userDao = UserDaoFactory.getUserDao();
		System.out.println(userDao.login("Lokesh", "Aditya@149"));

	}

}
