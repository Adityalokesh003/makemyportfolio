package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.PostDao;
import makemyportfolio.dao.impl.PostDaoOracleImpl;

public class PostDaoFactory {
	public static PostDao getPostDao() {
		return new PostDaoOracleImpl();
	}

}
