package makemyportfolio.bo;

 

public class ProfilePicture {
	private long id;
	private String picture_filename;
	
	public ProfilePicture() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPicture_filename() {
		return picture_filename;
	}

	public void setPicture_filename(String picture_filename) {
		this.picture_filename = picture_filename;
	}

	@Override
	public String toString() {
		return "ProfilePicture [id=" + id + ", picture_filename="
				+ picture_filename + "]";
	}
	
}
