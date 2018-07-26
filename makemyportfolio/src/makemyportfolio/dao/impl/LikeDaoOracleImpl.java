package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import makemyportfolio.bo.Like;
import makemyportfolio.dao.LikeDao;
import makemyportfolio.util.db.DataBaseUtil;

public class LikeDaoOracleImpl implements LikeDao {

	@Override
	public boolean add(long like_post_id, long like_user_id) {
		boolean isAdded = false;
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql="INSERT INTO likes (like_post_id,like_user_id)VALUES(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, like_post_id);
			preparedStatement.setLong(2, like_user_id);
			int result = preparedStatement.executeUpdate();
			if(result==1){
				isAdded=true;
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
		return isAdded;
	}

	@Override
	public List<Like> get(long like_post_id) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		Like like =null;
		List<Like> likes = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql="SELECT * FROM likes WHERE like_post_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, like_post_id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				like = new Like();
				likes = new ArrayList<Like>();
				like.setLike_post_id(resultSet.getLong("like_post_id"));
				like.setLike_user_id(resultSet.getLong("like_user_id"));
				likes.add(like);
				
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
		return likes;
	}

	@Override
	public Like delete(long like_post_id, long like_user_id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		Like  like = null;

		try {
			connection = DataBaseUtil.getConnection();
			like = new Like();
			like.setLike_post_id(like_post_id);
			like.setLike_user_id(like_user_id);
			
			String sql = "DELETE FROM likes WHERE like_post_id = ? AND like_user_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, like_post_id);
			preparedStatement.setLong(2, like_user_id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return like;
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
