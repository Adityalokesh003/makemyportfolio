package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.FriendDao;
import makemyportfolio.dao.impl.FriendDaoOracIeImpl;

public class FriendDaoFactory {
	public static FriendDao getFriendDao() {
		return new FriendDaoOracIeImpl();
	}

}
