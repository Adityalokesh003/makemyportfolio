package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.ProfileDao;
import makemyportfolio.dao.impl.ProfileDaoOracleImpl;


public class ProfileDaoFactory {
	public static ProfileDao getProfileDao() {
		return new ProfileDaoOracleImpl();
	}
}
