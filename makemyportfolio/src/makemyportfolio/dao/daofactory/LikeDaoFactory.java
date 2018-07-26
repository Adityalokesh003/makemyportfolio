package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.LikeDao;
import makemyportfolio.dao.impl.LikeDaoOracleImpl;

public class LikeDaoFactory {
	public static LikeDao getLikeDao() {
		return new LikeDaoOracleImpl();
	}
}
