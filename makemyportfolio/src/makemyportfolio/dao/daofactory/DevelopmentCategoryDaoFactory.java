package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.DevelopmentCategoryDao;
import makemyportfolio.dao.impl.DevelopmentCategoryDaoOracleImpl;

public class DevelopmentCategoryDaoFactory {
	public static DevelopmentCategoryDao getDevelopmentCategoryDao() {
		return new DevelopmentCategoryDaoOracleImpl();
	}
}
