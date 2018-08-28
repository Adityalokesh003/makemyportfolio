package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import makemyportfolio.bo.User;
import makemyportfolio.dao.UserDao;
import makemyportfolio.util.HashGenerator;
import makemyportfolio.util.db.DataBaseUtil;

public class UserDaoOracleImpl implements UserDao {
	private static final String SALT ="winter-is-coming";
	private long getNewID(Connection con) throws SQLException {

		String sql="SELECT NVL(MAX(user_id),0)+1 FROM users";
		ResultSet rs = con.createStatement().executeQuery(sql);
		if(rs.next()){
			return rs.getLong(1);
		}
		return 0;
	}

	@Override
	public boolean signup(String user_name, String password) {
		boolean isSignedUp=false;
		String saltedPassword = SALT + password;
		String hashedPassword = HashGenerator.generateHash(saltedPassword);
		Connection connection=null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql="INSERT INTO users(user_id,user_name,password) VALUES(?,?,?)";
			preparedStatement= connection.prepareStatement(sql);
			long user_id = getNewID(connection);
			preparedStatement.setLong(1, user_id);
			preparedStatement.setString(2, user_name);
			preparedStatement.setString(3, hashedPassword);

			int result = preparedStatement.executeUpdate();
			if(result==1){

				isSignedUp=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}


		// TODO Auto-generated method stub
		return isSignedUp;
	}

	@Override
	public boolean validateLoginUsername(String user_name){
		User storedUser = getByUsername(user_name);
		if (storedUser!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean login(String user_name, String password) {
		boolean isAuthenticated = false;
		String saltedPassword = SALT + password;
		String hashedPassword = HashGenerator.generateHash(saltedPassword);
		User storedUser = getByUsername(user_name);
		if(storedUser!=null){
			String storedPassword = storedUser.getPassword();
			if(hashedPassword.equals(storedPassword)){
				isAuthenticated = true;
			}
		}
		return isAuthenticated;
	}

	@Override
	public User get(long user_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM users WHERE user_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, user_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				user = new User();
				user.setUser_id(resultSet.getLong("user_id") );
				user.setUser_name(resultSet.getString("user_name") );
				user.setPassword(resultSet.getString("password"));
				return user;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}

		return user;
	}

	@Override
	public User getByUsername(String user_name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM users WHERE user_name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				user = new User();
				user.setUser_id(resultSet.getLong("user_id") );
				user.setUser_name(resultSet.getString("user_name") );
				user.setPassword(resultSet.getString("password"));
				return user;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}

		return user;

	}

	@Override
	public List<User> getAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		List<User> userList = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM users";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				user = new User();
				user.setUser_id(resultSet.getLong("user_id") );
				user.setUser_name(resultSet.getString("user_name") );
				user.setPassword(resultSet.getString("password"));
				userList = new ArrayList<User>();
				userList.add(user);
				 
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}

		return userList;

	}

	@Override
	public boolean updateUsername(long user_id,String user_name) {
		boolean isUpdated = false;
		Connection connection=null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE users SET user_name = ? WHERE user_id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_name);
			preparedStatement.setLong(2, user_id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				isUpdated =true;
				return isUpdated;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		return isUpdated;
	}

	@Override
	public boolean updatePassword(long user_id,String password) {
		boolean isUpdated = false;
		Connection connection=null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE users SET password = ? WHERE user_id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setLong(2, user_id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				isUpdated =true;
				return isUpdated;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		return isUpdated;
	}

	@Override
	public User deleteById(long user_id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		User user = null;

		try {
			connection = DataBaseUtil.getConnection();
			user = get(user_id);
			String sql = "DELETE FROM users WHERE user_id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, user_id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		return null;
	}

}
