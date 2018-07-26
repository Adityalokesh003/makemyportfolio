package makemyportfolio.bo;

public class EducationalInfo {
	private long id;
	private long education_profile_id ;
	private String institution_name ;
	private String degree_type;
	private int year_of_pass ;
	private int percentage ;
	
	public EducationalInfo() {
		 
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEducation_profile_id() {
		return education_profile_id;
	}

	public void setEducation_profile_id(long education_profile_id) {
		this.education_profile_id = education_profile_id;
	}

	public String getInstitution_name() {
		return institution_name;
	}

	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}

	public String getDegree_type() {
		return degree_type;
	}

	public void setDegree_type(String degree_type) {
		this.degree_type = degree_type;
	}

	public int getYear_of_pass() {
		return year_of_pass;
	}

	public void setYear_of_pass(int year_of_pass) {
		this.year_of_pass = year_of_pass;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "EducationalInfo [id=" + id + ", education_profile_id="
				+ education_profile_id + ", institution_name="
				+ institution_name + ", degree_type=" + degree_type
				+ ", year_of_pass=" + year_of_pass + ", percentage="
				+ percentage + "]";
	}
}