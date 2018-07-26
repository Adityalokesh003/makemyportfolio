package makemyportfolio.bo;

public class Friend {
	 
	private long friends_id;
	private long friend_profile_id;
	
	public Friend() {
		 
	}

	public long getFriends_id() {
		return friends_id;
	}

	public void setFriends_id(long friends_id) {
		this.friends_id = friends_id;
	}

	public long getFriend_profile_id() {
		return friend_profile_id;
	}

	public void setFriend_profile_id(long friend_profile_id) {
		this.friend_profile_id = friend_profile_id;
	}

	@Override
	public String toString() {
		return "Friend [friends_id=" + friends_id + ", friend_profile_id="
				+ friend_profile_id + "]";
	}

	 
}
