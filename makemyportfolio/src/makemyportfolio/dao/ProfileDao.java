package makemyportfolio.dao;

import java.util.List;

import makemyportfolio.bo.Profile;

public interface ProfileDao {
	public boolean add(Profile profile);
	public Profile get(long profile_id);
	public Profile getByUserId(long profile_user_id);
	public List<Profile>  getByName(String  full_name);
	public List<Profile>  getAll();
	public boolean update(Profile profile,long profile_user_id);
	public Profile deleteByUserId(long profile_user_id);
}
