package makemyportfolio.bo;

public class ExtracurricularInfo {
	private long  id;
	private long extracur_profile_id;
	private String activity_title ;
	private String activity_description ;
	
	public ExtracurricularInfo() {
		 
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getExtracur_profile_id() {
		return extracur_profile_id;
	}

	public void setExtracur_profile_id(long extracur_profile_id) {
		this.extracur_profile_id = extracur_profile_id;
	}

	public String getActivity_title() {
		return activity_title;
	}

	public void setActivity_title(String activity_title) {
		this.activity_title = activity_title;
	}

	public String getActivity_description() {
		return activity_description;
	}

	public void setActivity_description(String activity_description) {
		this.activity_description = activity_description;
	}

	@Override
	public String toString() {
		return "ExtracurricularInfo [id=" + id + ", extracur_profile_id="
				+ extracur_profile_id + ", activity_title=" + activity_title
				+ ", activity_description=" + activity_description + "]";
	}
	 
}
