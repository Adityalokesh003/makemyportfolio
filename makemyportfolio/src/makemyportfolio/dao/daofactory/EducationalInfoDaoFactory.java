package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.EducationalInfoDao;
import makemyportfolio.dao.impl.EducatioalInfoDaoOracleImpl;

public class EducationalInfoDaoFactory {
	public static EducationalInfoDao getEducationalInfoDao() {
		return new EducatioalInfoDaoOracleImpl();
	}
}
