package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import makemyportfolio.bo.Profile;
import makemyportfolio.dao.ProfileDao;
import makemyportfolio.util.db.DataBaseUtil;

public class ProfileDaoOracleImpl implements ProfileDao {

	private long getNewID(Connection con) throws SQLException {

		String sql="SELECT NVL(MAX(profile_id),0)+1 FROM profiles";
		ResultSet rs = con.createStatement().executeQuery(sql);
		if(rs.next()){
			return rs.getLong(1);
		}
		return 0;
	}

	@Override
	public boolean add(Profile profile) {
		boolean isAdded =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "INSERT INTO profiles(profile_id,profile_user_id,full_name,profile_picture_id,about_you,hometown,current_city,email_id,phone_no,total_friends)VALUES(?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			long profile_id  = getNewID(connection);
			preparedStatement.setLong(1, profile_id);
			preparedStatement.setLong(2, profile.getProfile_user_id());
			preparedStatement.setString(3, profile.getFull_name());
			preparedStatement.setLong(4,profile.getProfile_picture_id());
			preparedStatement.setString(5,profile.getAbout_you());
			preparedStatement.setString(6,profile.getHometown());
			preparedStatement.setString(7,profile.getCurrent_city());
			preparedStatement.setString(8,profile.getEmail_id());
			preparedStatement.setString(9,profile.getPhone_no());
			preparedStatement.setString(10,profile.getTotal_friends());

			int result  = preparedStatement.executeUpdate();
			if(result==1){
				isAdded =true;
			}
		} catch (SQLException e) {
			e.getMessage();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				e.getMessage();
			}

		}
		return isAdded;
	}

	@Override
	public Profile get(long profile_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Profile profile = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM profiles WHERE profile_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, profile_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				profile = new Profile();
				profile.setProfile_id(resultSet.getLong("profile_id")); 
				profile.setProfile_user_id(resultSet.getLong("profile_user_id"));
				profile.setFull_name(resultSet.getString("full_name"));
				profile.setProfile_picture_id(resultSet.getLong("profile_picture_id"));
				profile.setAbout_you(resultSet.getString("about_you"));
				profile.setHometown(resultSet.getString("hometown"));
				profile.setCurrent_city(resultSet.getString("current_city"));
				profile.setEmail_id(resultSet.getString("email_id"));
				profile.setPhone_no(resultSet.getString("phone_no"));
				profile.setTotal_friends(resultSet.getString("total_friends"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return profile;
	}

	@Override
	public Profile getByUserId(long profile_user_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Profile profile = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM profiles WHERE profile_user_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, profile_user_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				profile = new Profile();
				profile.setProfile_id(resultSet.getLong("profile_id")); 
				profile.setProfile_user_id(resultSet.getLong("profile_user_id"));
				profile.setFull_name(resultSet.getString("full_name"));
				profile.setProfile_picture_id(resultSet.getLong("profile_picture_id"));
				profile.setAbout_you(resultSet.getString("about_you"));
				profile.setHometown(resultSet.getString("hometown"));
				profile.setCurrent_city(resultSet.getString("current_city"));
				profile.setEmail_id(resultSet.getString("email_id"));
				profile.setPhone_no(resultSet.getString("phone_no"));
				profile.setTotal_friends(resultSet.getString("total_friends"));
				 
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return profile;

	}

	@Override
	public List<Profile> getByName(String full_name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Profile profile = null;
		List<Profile> profileList = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= " SELECT * FROM profiles WHERE LOWER(full_name) like LOWER('%?%');";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, full_name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				profile = new Profile();
				profileList = new ArrayList<Profile>();
				profile.setProfile_id(resultSet.getLong("profile_id")); 
				profile.setProfile_user_id(resultSet.getLong("profile_user_id"));
				profile.setFull_name(resultSet.getString("full_name"));
				profile.setProfile_picture_id(resultSet.getLong("profile_picture_id"));
				profile.setAbout_you(resultSet.getString("about_you"));
				profile.setHometown(resultSet.getString("hometown"));
				profile.setCurrent_city(resultSet.getString("current_city"));
				profile.setEmail_id(resultSet.getString("email_id"));
				profile.setPhone_no(resultSet.getString("phone_no"));
				profile.setTotal_friends(resultSet.getString("total_friends"));
				profileList.add(profile);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return profileList;
	}

	@Override
	public List<Profile> getAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Profile profile = null;
		List<Profile> profileList = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM profiles";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				profile = new Profile();
				profileList = new ArrayList<Profile>();
				profile.setProfile_id(resultSet.getLong("profile_id")); 
				profile.setProfile_user_id(resultSet.getLong("profile_user_id"));
				profile.setFull_name(resultSet.getString("full_name"));
				profile.setProfile_picture_id(resultSet.getLong("profile_picture_id"));
				profile.setAbout_you(resultSet.getString("about_you"));
				profile.setHometown(resultSet.getString("hometown"));
				profile.setCurrent_city(resultSet.getString("current_city"));
				profile.setEmail_id(resultSet.getString("email_id"));
				profile.setPhone_no(resultSet.getString("phone_no"));
				profile.setTotal_friends(resultSet.getString("total_friends"));
				profileList.add(profile);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return profileList;
	}

	@Override
	public boolean update(Profile profile,long profile_user_id) {
		boolean isUpdated =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE profiles SET full_name=?,about_you=?,hometown=?,current_city = ?,email_id = ?,phone_no =? ,total_friends=? WHERE profile_user_id=?";
			preparedStatement  =connection.prepareStatement(sql);
			preparedStatement.setString(1, profile.getFull_name());
			preparedStatement.setString(2,profile.getAbout_you());
			preparedStatement.setString(3,profile.getHometown());
			preparedStatement.setString(4,profile.getCurrent_city());
			preparedStatement.setString(5,profile.getEmail_id());
			preparedStatement.setString(6,profile.getPhone_no());
			preparedStatement.setString(7,profile.getTotal_friends());
			preparedStatement.setLong(8, profile_user_id);
			int result  = preparedStatement.executeUpdate();
			if(result==1){
				isUpdated =true;
			}
		} catch (SQLException e) {
			e.getMessage();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				e.getMessage();
			}

		}
		return isUpdated;
	}

	@Override
	public Profile deleteByUserId(long profile_user_id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		Profile profile = null;

		try {
			connection = DataBaseUtil.getConnection();
			profile = get(profile_user_id);
			String sql = "DELETE FROM profiles WHERE profile_user_id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, profile_user_id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return profile;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
