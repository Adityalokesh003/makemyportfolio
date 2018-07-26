package makemyportfolio.dao;

import java.util.List;

import makemyportfolio.bo.Comment;

public interface CommentDao {
	public boolean add(Comment comment) ;
	public Comment get(long comment_post_id,long comment_user_id);
	public List<Comment> getAll(long comment_post_id);
	public boolean update(String comment_content,long comment_post_id,long comment_user_id);
	public Comment delete(long comment_post_id,long comment_user_id);
	
 
}
