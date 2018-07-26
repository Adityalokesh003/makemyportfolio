package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import makemyportfolio.bo.Post;
import makemyportfolio.dao.PostDao;
import makemyportfolio.util.db.DataBaseUtil;

public class PostDaoOracleImpl implements PostDao {
	
	private long getNewID(Connection con) throws SQLException {

		String sql="SELECT NVL(MAX(post_id),0)+1 FROM posts";
		ResultSet rs = con.createStatement().executeQuery(sql);
		if(rs.next()){
			return rs.getLong(1);
		}
		return 0;
	}
	
	@Override
	public boolean add(Post post) {
		boolean isAdded =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "INSERT INTO posts(post_id,post_user_id,post_title,post_content,post_image,post_tags,comment_count,likes_count)VALUES(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			long post_id  = getNewID(connection);
			preparedStatement.setLong(1, post_id);
			preparedStatement.setLong(2, post.getPost_user_id());
			preparedStatement.setString(3, post.getPost_title());
			preparedStatement.setString(4, post.getPost_content());
			preparedStatement.setString(5, post.getPost_image());
			preparedStatement.setString(6, post.getPost_tags());
			preparedStatement.setInt(7, post.getComment_count());
			preparedStatement.setInt(8, post.getLikes_count());
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
	public Post get(long post_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Post post = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM posts WHERE post_id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, post_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				post = new  Post();
				post.setPost_id(resultSet.getLong("post_id"));
				post.setPost_user_id(resultSet.getLong("post_user_id"));
				post.setPost_title(resultSet.getString("post_title"));
				post.setPost_content(resultSet.getString("post_content"));
				post.setPost_image(resultSet.getString("post_image"));
				post.setPost_tags(resultSet.getString("post_tags"));
				post.setComment_count(resultSet.getInt("comment_count"));
				post.setLikes_count(resultSet.getInt("likes_count"));
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

		return post;
	}

	@Override
	public List<Post> getByUserId(long post_user_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Post post = null;
		List<Post> posts =  null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM posts WHERE post_user_id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, post_user_id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				post = new  Post();
				posts = new ArrayList<Post>();
				post.setPost_id(resultSet.getLong("post_id"));
				post.setPost_user_id(resultSet.getLong("post_user_id"));
				post.setPost_title(resultSet.getString("post_title"));
				post.setPost_content(resultSet.getString("post_content"));
				post.setPost_image(resultSet.getString("post_image"));
				post.setPost_tags(resultSet.getString("post_tags"));
				post.setComment_count(resultSet.getInt("comment_count"));
				post.setLikes_count(resultSet.getInt("likes_count"));
				posts.add(post);
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

		return posts;
	}

	@Override
	public List<Post> getByTitle(String post_title) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Post post = null;
		List<Post> posts =  null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM posts WHERE post_title = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, post_title);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				post = new  Post();
				posts = new ArrayList<Post>();
				post.setPost_id(resultSet.getLong("post_id"));
				post.setPost_user_id(resultSet.getLong("post_user_id"));
				post.setPost_title(resultSet.getString("post_title"));
				post.setPost_content(resultSet.getString("post_content"));
				post.setPost_image(resultSet.getString("post_image"));
				post.setPost_tags(resultSet.getString("post_tags"));
				post.setComment_count(resultSet.getInt("comment_count"));
				post.setLikes_count(resultSet.getInt("likes_count"));
				posts.add(post);
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

		return posts;
	}

	@Override
	public List<Post> getByTags(String post_tags) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Post post = null;
		List<Post> posts =  null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM posts WHERE post_tags = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, post_tags);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				post = new  Post();
				posts = new ArrayList<Post>();
				post.setPost_id(resultSet.getLong("post_id"));
				post.setPost_user_id(resultSet.getLong("post_user_id"));
				post.setPost_title(resultSet.getString("post_title"));
				post.setPost_content(resultSet.getString("post_content"));
				post.setPost_image(resultSet.getString("post_image"));
				post.setPost_tags(resultSet.getString("post_tags"));
				post.setComment_count(resultSet.getInt("comment_count"));
				post.setLikes_count(resultSet.getInt("likes_count"));
				posts.add(post);
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

		return posts;
	}

	@Override
	public boolean update(Post post, long post_id) {
		boolean isUpdated =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE posts SET post_title=?,post_content=?,post_image=?,post_tags=? WHERE post_id=?";
			preparedStatement  =connection.prepareStatement(sql);
			preparedStatement.setString(1, post.getPost_title());
			preparedStatement.setString(2, post.getPost_content());
			preparedStatement.setString(3, post.getPost_image());
			preparedStatement.setString(4, post.getPost_tags());
			preparedStatement.setLong(5, post_id);
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
	public Post deleteById(long post_id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		Post post = null;

		try {
			connection = DataBaseUtil.getConnection();
			post = get(post_id);
			String sql = "DELETE FROM posts WHERE post_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, post_id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return post;
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
