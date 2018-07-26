package makemyportfolio.bo;

public class Profile {
	private long profile_id;
	private long profile_user_id ;
	private String full_name;  
	private long profile_picture_id; 
	private String about_you; 
	private String hometown;
	private String total_friends;

	public Profile() {

	}

	public long getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(long profile_id) {
		this.profile_id = profile_id;
	}

	public long getProfile_user_id() {
		return profile_user_id;
	}

	public void setProfile_user_id(long profile_user_id) {
		this.profile_user_id = profile_user_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public long getProfile_picture_id() {
		return profile_picture_id;
	}

	public void setProfile_picture_id(long profile_picture_id) {
		this.profile_picture_id = profile_picture_id;
	}

	public String getAbout_you() {
		return about_you;
	}

	public void setAbout_you(String about_you) {
		this.about_you = about_you;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getTotal_friends() {
		return total_friends;
	}

	public void setTotal_friends(String total_friends) {
		this.total_friends = total_friends;
	}

	@Override
	public String toString() {
		return "Profile [profile_id=" + profile_id + ", profile_user_id="
				+ profile_user_id + ", full_name=" + full_name
				+ ", profile_picture_id=" + profile_picture_id + ", about_you="
				+ about_you + ", hometown=" + hometown + ", total_friends="
				+ total_friends + "]";
	}
}
