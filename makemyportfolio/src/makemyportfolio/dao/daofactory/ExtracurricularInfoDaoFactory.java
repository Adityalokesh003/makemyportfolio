package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.ExtracurricularInfoDao;
import makemyportfolio.dao.impl.ExtracurricularInfoDaoOracleImpl;

public class ExtracurricularInfoDaoFactory {
	public static ExtracurricularInfoDao getExtracurricularInfoDao() {
		return new ExtracurricularInfoDaoOracleImpl();
	}
}
