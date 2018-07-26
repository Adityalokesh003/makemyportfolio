package makemyportfolio.bo;

public class TechnicalInfo {
	private long id;
	private long tech_profile_id;
	private String programming_languages;
	private String scripting_languages;
	private String os_known;
	private String databases_known ;
	public TechnicalInfo() {
		 
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTech_profile_id() {
		return tech_profile_id;
	}
	public void setTech_profile_id(long tech_profile_id) {
		this.tech_profile_id = tech_profile_id;
	}
	public String getProgramming_languages() {
		return programming_languages;
	}
	public void setProgramming_languages(String programming_languages) {
		this.programming_languages = programming_languages;
	}
	public String getScripting_languages() {
		return scripting_languages;
	}
	public void setScripting_languages(String scripting_languages) {
		this.scripting_languages = scripting_languages;
	}
	public String getOs_known() {
		return os_known;
	}
	public void setOs_known(String os_known) {
		this.os_known = os_known;
	}
	public String getDatabases_known() {
		return databases_known;
	}
	public void setDatabases_known(String databases_known) {
		this.databases_known = databases_known;
	}
	@Override
	public String toString() {
		return "TechnicalInfo [id=" + id + ", tech_profile_id="
				+ tech_profile_id + ", programming_languages="
				+ programming_languages + ", scripting_languages="
				+ scripting_languages + ", os_known=" + os_known
				+ ", databases_known=" + databases_known + "]";
	}
}