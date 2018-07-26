package makemyportfolio.dao.daofactory;

import makemyportfolio.dao.ProfilePictureDao;
import makemyportfolio.dao.impl.ProfilePictureDaoOracleImpl;

public class ProfilePictureDaoFactory {
	public static ProfilePictureDao getProfilePictureDao() {
		return new ProfilePictureDaoOracleImpl();
	}
}
