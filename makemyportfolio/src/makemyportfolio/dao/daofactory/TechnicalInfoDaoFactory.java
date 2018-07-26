package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.TechnicalInfoDao;
import makemyportfolio.dao.impl.TechnicalInfoDaoOracleImpl;

public class TechnicalInfoDaoFactory {
	public static TechnicalInfoDao getTechnicalInfoDao() {
		return new TechnicalInfoDaoOracleImpl();
	}
		
}
