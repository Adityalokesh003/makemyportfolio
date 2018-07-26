package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import makemyportfolio.bo.Comment;
import makemyportfolio.dao.CommentDao;
import makemyportfolio.util.db.DataBaseUtil;

public class CommentDaoOracleImpl implements CommentDao{

	@Override
	public boolean add(Comment comment) {
		boolean isAdded = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "INSERT INTO comments(comment_post_id,comment_user_id,comment_content)VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, comment.getComment_post_id());
			preparedStatement.setLong(2, comment.getComment_user_id());
			preparedStatement.setString(3, comment.getComment_content());
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
	public Comment get(long comment_post_id, long comment_user_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Comment comment = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM comments WHERE comment_post_id = ? AND comment_user_id=? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, comment_post_id);
			preparedStatement.setLong(2, comment_user_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				comment = new Comment();
				comment.setComment_post_id(resultSet.getLong("comment_post_id"));
				comment.setComment_user_id(resultSet.getLong("comment_user_id"));
				comment.setComment_content(resultSet.getString("comment_content"));
				
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

		return comment;
	}
	@Override
	public List<Comment> getAll(long comment_post_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Comment comment = null;
		List<Comment> comments = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM comments WHERE comment_post_id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, comment_post_id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				comment = new Comment();
				comments = new ArrayList<Comment>();
				comment.setComment_post_id(resultSet.getLong("comment_post_id"));
				comment.setComment_user_id(resultSet.getLong("comment_user_id"));
				comment.setComment_content(resultSet.getString("comment_content"));
				comments.add(comment);
				
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

		return comments;
	}
	
	@Override
	public boolean update(String comment_content, long comment_post_id ,long comment_user_id) {
		boolean isUpdated =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE comments SET comment_content=? WHERE comment_post_id=? AND comment_user_id=?";
			preparedStatement  =connection.prepareStatement(sql);
			preparedStatement.setString(1, comment_content);
			preparedStatement.setLong(2, comment_post_id);
			preparedStatement.setLong(3, comment_user_id);
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
	public Comment delete(long comment_post_id, long comment_user_id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		Comment comment = null;

		try {
			connection = DataBaseUtil.getConnection();
			comment = get( comment_post_id,comment_user_id );
			String sql = "DELETE FROM comments WHERE comment_post_id = ? AND comment_user_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, comment_post_id);
			preparedStatement.setLong(2, comment_user_id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return comment;
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
