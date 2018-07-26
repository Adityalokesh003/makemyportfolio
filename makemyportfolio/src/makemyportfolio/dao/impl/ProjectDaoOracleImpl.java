package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import makemyportfolio.bo.Project;
import makemyportfolio.dao.ProjectDao;
import makemyportfolio.util.db.DataBaseUtil;

public class ProjectDaoOracleImpl implements ProjectDao {
	
	private long getNewID(Connection con) throws SQLException {

		String sql="SELECT NVL(MAX(project_id),0)+1 FROM projects";
		ResultSet rs = con.createStatement().executeQuery(sql);
		if(rs.next()){
			return rs.getLong(1);
		}
		return 0;
	}
	
	@Override
	public boolean add(Project project) {
		boolean isAdded =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "INSERT INTO projects (project_id,project_portifolio_id,project_title,technologies_used,project_description,project_duration)VALUES(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
		    long project_id  = getNewID(connection);
			preparedStatement.setLong(1, project_id);
			preparedStatement.setLong(2, project.getProject_portifolio_id());
			preparedStatement.setString(3, project.getProject_title());
			preparedStatement.setString(4, project.getTechnologies_used());
			preparedStatement.setString(5, project.getProject_description());
			preparedStatement.setString(6, project.getProject_duration());

			int result  = preparedStatement.executeUpdate();
			if(result==1){
				isAdded =true;
			}
		} catch (SQLException e) {
			e.getMessage();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				e.getMessage();
			}

		}
		return isAdded;

	}

	@Override
	public Project get(long project_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Project project = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM projects WHERE project_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, project_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				project = new Project();
				project.setProject_id(resultSet.getLong("project_id"));
				project.setProject_portifolio_id(resultSet.getLong("project_portifolio_id"));
				project.setProject_title(resultSet.getString("project_title"));
				project.setTechnologies_used(resultSet.getString("technologies_used"));
				project.setProject_description(resultSet.getString("project_description"));
				project.setProject_duration(resultSet.getString("project_duration"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return project;
	}

	@Override
	public List<Project> getByPortifolioId(long project_portifolio_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Project project = null;
		List<Project> projects = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM projects WHERE project_portifolio_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, project_portifolio_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				project = new Project();
				projects = new ArrayList<Project>();
				project.setProject_id(resultSet.getLong("project_id"));
				project.setProject_portifolio_id(resultSet.getLong("project_portifolio_id"));
				project.setProject_title(resultSet.getString("project_title"));
				project.setTechnologies_used(resultSet.getString("technologies_used"));
				project.setProject_description(resultSet.getString("project_description"));
				project.setProject_duration(resultSet.getString("project_duration"));
				projects.add(project);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return projects;
	}

	@Override
	public List<Project> getByTitle(String project_title) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Project project = null;
		List<Project> projects = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM projects WHERE LOWER(project_portifolio_id) LIKE LOWER(?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, project_title);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				project = new Project();
				projects = new ArrayList<Project>();
				project.setProject_id(resultSet.getLong("project_id"));
				project.setProject_portifolio_id(resultSet.getLong("project_portifolio_id"));
				project.setProject_title(resultSet.getString("project_title"));
				project.setTechnologies_used(resultSet.getString("technologies_used"));
				project.setProject_description(resultSet.getString("project_description"));
				project.setProject_duration(resultSet.getString("project_duration"));
				projects.add(project);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return projects;
	}

	@Override
	public boolean update(Project project, long project_id) {
		boolean isUpdated =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE projects SET project_title = ? ,technologies_used =? ,project_description=?,project_duration=? WHERE project_id=?";
			preparedStatement  =connection.prepareStatement(sql);
			preparedStatement.setString(1, project.getProject_title());
			preparedStatement.setString(2, project.getTechnologies_used());
			preparedStatement.setString(3, project.getProject_description());
			preparedStatement.setString(4, project.getProject_duration());
			preparedStatement.setLong(5, project_id);
			 
			int result  = preparedStatement.executeUpdate();
			if(result==1){
				isUpdated =true;
			}
		} catch (SQLException e) {
			e.getMessage();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				e.getMessage();
			}

		}
		return isUpdated;
	}

	@Override
	public Project delete(long project_id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		Project project = null;

		try {
			connection = DataBaseUtil.getConnection();
			project = get(project_id);
			String sql = "DELETE FROM projects WHERE project_id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, project_id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return project;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DataBaseUtil.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
