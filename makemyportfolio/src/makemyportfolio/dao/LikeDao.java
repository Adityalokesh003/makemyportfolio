package makemyportfolio.dao;

import java.util.List;

import makemyportfolio.bo.Like;


public interface LikeDao {
	public boolean add(long like_post_id,long like_user_id) ;
	public List<Like> get(long like_post_id);
	public Like delete(long like_post_id,long like_user_id);
}
