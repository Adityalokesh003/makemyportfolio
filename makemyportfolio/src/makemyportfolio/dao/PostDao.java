package makemyportfolio.dao;

import java.util.List;

import makemyportfolio.bo.Post;

public interface PostDao {
	public boolean add(Post post);
	public Post get(long post_id);
	public List<Post> getByUserId(long post_user_id);
	public List<Post> getByTitle(String post_title);
	public List<Post> getByTags(String post_tags);
	public boolean update(Post post,long post_id);
	public Post deleteById(long post_id);
	
}
