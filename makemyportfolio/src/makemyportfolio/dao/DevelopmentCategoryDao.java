package makemyportfolio.dao;

import java.util.List;

import makemyportfolio.bo.DevelopmentCategory;

public interface DevelopmentCategoryDao {
	boolean add(DevelopmentCategory developmentCategory);
	DevelopmentCategory get(long id);
	List<DevelopmentCategory> getByTechId(long dev_category_tech_id);
	boolean update(DevelopmentCategory developmentCategory , long id);
	DevelopmentCategory deleteByID(long id);
	
}
