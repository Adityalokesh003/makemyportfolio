package makemyportfolio.dao;

import makemyportfolio.bo.ProfilePicture;

public interface ProfilePictureDao {
	boolean add(ProfilePicture picture);
	ProfilePicture get(long id);
	boolean update(ProfilePicture picture,long id);
	ProfilePicture deleteByID(long id);

}
