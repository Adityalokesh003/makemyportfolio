package makemyportfolio.dao;

import java.util.List;

import makemyportfolio.bo.Project;

public interface ProjectDao {
	boolean add(Project project);
	Project get(long project_id);
	List<Project> getByPortifolioId(long project_portifolio_id);
	List<Project> getByTitle(String project_title);
	boolean update(Project project,long project_id);
	Project delete(long project_id);
}
