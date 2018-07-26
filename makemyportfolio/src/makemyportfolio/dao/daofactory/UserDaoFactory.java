package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.UserDao;
import makemyportfolio.dao.impl.UserDaoOracleImpl;

public class UserDaoFactory {
	public static UserDao getUserDao() {
		return new UserDaoOracleImpl();
	}

}
