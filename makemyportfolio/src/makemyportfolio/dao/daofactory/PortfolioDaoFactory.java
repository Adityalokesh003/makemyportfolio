package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.PortfolioDao;
import makemyportfolio.dao.impl.PortfolioDaoOracleImpl;

public class PortfolioDaoFactory {
	public static PortfolioDao	 getPortifolioDao() {
		return new PortfolioDaoOracleImpl();
	}
}
