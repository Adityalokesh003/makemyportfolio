package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.PortifolioDao;
import makemyportfolio.dao.impl.PortifolioDaoOracleImpl;

public class PortifolioDaoFactory {
	public static PortifolioDao	 getPortifolioDao() {
		return new PortifolioDaoOracleImpl();
	}
}
