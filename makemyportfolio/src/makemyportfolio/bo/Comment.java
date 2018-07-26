package makemyportfolio.bo;

public class Comment {
	private long comment_post_id;
	private long comment_user_id;
	private String comment_content;
	public Comment() {
		 
	}
	public long getComment_post_id() {
		return comment_post_id;
	}
	public void setComment_post_id(long comment_post_id) {
		this.comment_post_id = comment_post_id;
	}
	public long getComment_user_id() {
		return comment_user_id;
	}
	public void setComment_user_id(long comment_user_id) {
		this.comment_user_id = comment_user_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	@Override
	public String toString() {
		return "Comment [comment_post_id=" + comment_post_id
				+ ", comment_user_id=" + comment_user_id + ", comment_content="
				+ comment_content + "]";
	}
	
	
}
