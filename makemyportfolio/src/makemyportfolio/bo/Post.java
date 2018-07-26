package makemyportfolio.bo;

public class Post {
	private long post_id;
	private long post_user_id;
	private String post_title;
	private String post_content;
	private String post_image;
	private String post_tags;
	private int comment_count;
	private int likes_count;
	public Post() {
		
	}
	public long getPost_id() {
		return post_id;
	}
	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}
	public long getPost_user_id() {
		return post_user_id;
	}
	public void setPost_user_id(long post_user_id) {
		this.post_user_id = post_user_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public String getPost_image() {
		return post_image;
	}
	public void setPost_image(String post_image) {
		this.post_image = post_image;
	}
	public String getPost_tags() {
		return post_tags;
	}
	public void setPost_tags(String post_tags) {
		this.post_tags = post_tags;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public int getLikes_count() {
		return likes_count;
	}
	public void setLikes_count(int likes_count) {
		this.likes_count = likes_count;
	}
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", post_user_id=" + post_user_id
				+ ", post_title=" + post_title + ", post_content="
				+ post_content + ", post_image=" + post_image + ", post_tags="
				+ post_tags + ", comment_count=" + comment_count
				+ ", likes_count=" + likes_count + "]";
	}
	
	
	
}
