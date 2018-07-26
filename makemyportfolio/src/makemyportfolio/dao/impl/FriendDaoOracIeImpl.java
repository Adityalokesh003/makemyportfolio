package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import makemyportfolio.bo.Friend;
import makemyportfolio.dao.FriendDao;
import makemyportfolio.util.db.DataBaseUtil;

public class FriendDaoOracIeImpl implements FriendDao {

	@Override
	public boolean add(Friend friend) {
		boolean isAdded =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "INSERT INTO friends(friends_id,friend_profile_id)VALUES(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, friend.getFriends_id());
			preparedStatement.setLong(1, friend.getFriend_profile_id());
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
	public Friend get(long frinds_id, long friend_profile_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Friend  friend = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM friends WHERE frinds_id = ? AND friend_profile_id =? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, frinds_id);
			preparedStatement.setLong(2, friend_profile_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				friend = new  Friend();
				friend.setFriends_id(resultSet.getLong("friends_id"));
				friend.setFriend_profile_id(resultSet.getLong("friend_profile_id"));
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

		return friend;
	}

	@Override
	public List<Friend> getFrindsList(long frinds_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Friend  friend = null;
		List<Friend> friends = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM friends WHERE frinds_id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, frinds_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				friend = new Friend();
				friends = new ArrayList<Friend>();
				friend.setFriends_id(resultSet.getLong("friends_id"));
				friend.setFriend_profile_id(resultSet.getLong("friend_profile_id"));
				friends.add(friend);
				 
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

		return friends;
	}

	@Override
	public Friend unFriend(long frinds_id, long friend_profile_id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		Friend  friend = null;

		try {
			connection = DataBaseUtil.getConnection();
			friend = get(frinds_id, friend_profile_id);
			String sql = "DELETE FROM friends WHERE frinds_id = ? AND friend_profile_id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, frinds_id);
			preparedStatement.setLong(2, friend_profile_id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return friend;
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
