package makemyportfolio.dao;

import java.util.List;

import makemyportfolio.bo.User;


public interface UserDao {
	boolean validateLoginUsername(String user_name);
	boolean signup(String user_name, String password);
	boolean login(String user_name, String password);
	User get( long user_id);
	User getByUsername(String user_name);
	List<User> getAll();
	boolean  updateUsername(long user_id,String user_name);
	boolean  updatePassword(long user_id,String password);
	User  deleteById( long user_id);

}
