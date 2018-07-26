package makemyportfolio.bo;

public class DevelopmentCategory {
	private long id;
	private long dev_category_tech_id;
	private String category_title;
	
	public DevelopmentCategory() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDev_category_tech_id() {
		return dev_category_tech_id;
	}
	public void setDev_category_tech_id(long dev_category_tech_id) {
		this.dev_category_tech_id = dev_category_tech_id;
	}
	public String getCategory_title() {
		return category_title;
	}
	public void setCategory_title(String category_title) {
		this.category_title = category_title;
	}
	@Override
	public String toString() {
		return "DevelopmentCategory [id=" + id + ", dev_category_tech_id="
				+ dev_category_tech_id + ", category_title=" + category_title
				+ "]";
	}
	

}
