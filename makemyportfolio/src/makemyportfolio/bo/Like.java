package makemyportfolio.bo;

public class Like {
	private long like_post_id ;
	private long like_user_id ;
	public Like() {
		 
	}
	public long getLike_post_id() {
		return like_post_id;
	}
	public void setLike_post_id(long like_post_id) {
		this.like_post_id = like_post_id;
	}
	public long getLike_user_id() {
		return like_user_id;
	}
	public void setLike_user_id(long like_user_id) {
		this.like_user_id = like_user_id;
	}
	@Override
	public String toString() {
		return "Like [like_post_id=" + like_post_id + ", like_user_id="
				+ like_user_id + "]";
	}
	
}
