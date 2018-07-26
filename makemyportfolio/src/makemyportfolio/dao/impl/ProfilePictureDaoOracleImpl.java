package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import makemyportfolio.bo.ProfilePicture;
import makemyportfolio.dao.ProfilePictureDao;
import makemyportfolio.util.db.DataBaseUtil;

public class ProfilePictureDaoOracleImpl implements ProfilePictureDao {
	
	private long getNewID(Connection con) throws SQLException {

		String sql="SELECT NVL(MAX(id),0)+1 FROM profile_pictures";
		ResultSet rs = con.createStatement().executeQuery(sql);
		if(rs.next()){
			return rs.getLong(1);
		}
		return 0;
	}
	
	
	@Override
	public boolean add(ProfilePicture picture) {
		boolean isAdded =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "INSERT INTO profile_pictures(id , picture_filename)VALUES(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			long id  = getNewID(connection);
			preparedStatement.setLong(1,id);
			preparedStatement.setString(2, picture.getPicture_filename());
			 
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
	public ProfilePicture get(long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ProfilePicture profilePicture = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM profile_pictures WHERE  id =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1,id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				profilePicture = new ProfilePicture();
				profilePicture.setId(resultSet.getLong("id"));
				profilePicture.setPicture_filename(resultSet.getString("picture_filename"));
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

		return profilePicture;
	}

	@Override
	public boolean update(ProfilePicture picture, long id) {
		boolean isUpdated =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE profile_pictures SET  picture_filename=?  WHERE id=?";
			preparedStatement  =connection.prepareStatement(sql);
			preparedStatement.setString(1, picture.getPicture_filename());
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
	public ProfilePicture deleteByID(long id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		ProfilePicture  profilePicture = null;

		try {
			connection = DataBaseUtil.getConnection();
			profilePicture = get(id);
			String sql = "DELETE FROM profile_pictures WHERE id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1,id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return profilePicture;
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
