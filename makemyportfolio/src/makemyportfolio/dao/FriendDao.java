package makemyportfolio.dao;

import java.util.List;

import makemyportfolio.bo.Friend;

public interface FriendDao {
	public boolean add(Friend friend);
	public Friend get(long frinds_id,long friend_profile_id);
	public List<Friend> getFrindsList(long frinds_id);
	public Friend unFriend(long frinds_id,long friend_profile_id);

}


