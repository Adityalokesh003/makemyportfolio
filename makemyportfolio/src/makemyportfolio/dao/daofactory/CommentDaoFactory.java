package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.CommentDao;
import makemyportfolio.dao.impl.CommentDaoOracleImpl;

public class CommentDaoFactory {
	public static CommentDao getCommentDao() {
		return new CommentDaoOracleImpl();
	}

}
