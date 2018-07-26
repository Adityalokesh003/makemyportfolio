package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.ProjectDao;
import makemyportfolio.dao.impl.ProjectDaoOracleImpl;

public class ProjectDaoFactory {
	public static ProjectDao getProjectDao(){
		return new ProjectDaoOracleImpl();
	}
}
