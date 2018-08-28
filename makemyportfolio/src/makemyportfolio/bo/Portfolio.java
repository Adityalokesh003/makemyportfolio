package makemyportfolio.bo;

public class Portfolio {
	private long portfolio_id;
	private long portfolio_profile_id;
	private String about_yourself;
	private String strengths;
	private String weaknesses;
	private String interests;
	private String achievements;
	private String career_objective;
	private String links;
	
	
	public Portfolio() {
		 
	}


	public long getPortfolio_id() {
		return portfolio_id;
	}


	public void setPortfolio_id(long portfolio_id) {
		this.portfolio_id = portfolio_id;
	}


	public long getPortfolio_profile_id() {
		return portfolio_profile_id;
	}


	public void setPortfolio_profile_id(long portfolio_profile_id) {
		this.portfolio_profile_id = portfolio_profile_id;
	}


	public String getAbout_yourself() {
		return about_yourself;
	}


	public void setAbout_yourself(String about_yourself) {
		this.about_yourself = about_yourself;
	}


	public String getStrengths() {
		return strengths;
	}


	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}


	public String getWeaknesses() {
		return weaknesses;
	}


	public void setWeaknesses(String weaknesses) {
		this.weaknesses = weaknesses;
	}


	public String getInterests() {
		return interests;
	}


	public void setInterests(String interests) {
		this.interests = interests;
	}


	public String getAchievements() {
		return achievements;
	}


	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}


	public String getCareer_objective() {
		return career_objective;
	}


	public void setCareer_objective(String career_objective) {
		this.career_objective = career_objective;
	}


	public String getLinks() {
		return links;
	}


	public void setLinks(String links) {
		this.links = links;
	}


	@Override
	public String toString() {
		return "Portfolio [portfolio_id=" + portfolio_id
				+ ", portfolio_profile_id=" + portfolio_profile_id
				+ ", about_yourself=" + about_yourself + ", strengths="
				+ strengths + ", weaknesses=" + weaknesses + ", interests="
				+ interests + ", achievements=" + achievements
				+ ", career_objective=" + career_objective + ", links=" + links
				+ "]";
	}
	 
}
