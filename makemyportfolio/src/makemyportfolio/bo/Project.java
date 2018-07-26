package makemyportfolio.bo;

public class Project {
	private long project_id;
	private long project_portifolio_id;
	private String project_title;
	private String technologies_used;
	private String project_description;
	private String project_duration;
	
	
	public Project() {
		 
	}


	public long getProject_id() {
		return project_id;
	}


	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}


	public long getProject_portifolio_id() {
		return project_portifolio_id;
	}


	public void setProject_portifolio_id(long project_portifolio_id) {
		this.project_portifolio_id = project_portifolio_id;
	}


	public String getProject_title() {
		return project_title;
	}


	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}


	public String getTechnologies_used() {
		return technologies_used;
	}


	public void setTechnologies_used(String technologies_used) {
		this.technologies_used = technologies_used;
	}


	public String getProject_description() {
		return project_description;
	}


	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}


	public String getProject_duration() {
		return project_duration;
	}


	public void setProject_duration(String project_duration) {
		this.project_duration = project_duration;
	}


	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", project_portifolio_id="
				+ project_portifolio_id + ", project_title=" + project_title
				+ ", technologies_used=" + technologies_used
				+ ", project_description=" + project_description
				+ ", project_duration=" + project_duration + "]";
	}
	 
	
	
	  
}
