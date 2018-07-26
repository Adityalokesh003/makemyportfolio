package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import makemyportfolio.bo.DevelopmentCategory;
import makemyportfolio.dao.DevelopmentCategoryDao;
import makemyportfolio.util.db.DataBaseUtil;

public class DevelopmentCategoryDaoOracleImpl implements DevelopmentCategoryDao {
	
	private long getNewID(Connection con) throws SQLException {

		String sql="SELECT NVL(MAX(id),0)+1 FROM development_categories";
		ResultSet rs = con.createStatement().executeQuery(sql);
		if(rs.next()){
			return rs.getLong(1);
		}
		return 0;
	}
	
	@Override
	public boolean add(DevelopmentCategory developmentCategory) {
		boolean isAdded =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "INSERT INTO development_categories(id , dev_category_tech_id,category_title)VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			long id  = getNewID(connection);
			preparedStatement.setLong(1,id);
			preparedStatement.setLong(2, developmentCategory.getDev_category_tech_id());
			preparedStatement.setString(3, developmentCategory.getCategory_title());
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
	public DevelopmentCategory get(long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DevelopmentCategory  developmentCategory = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM development_categories WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				developmentCategory = new DevelopmentCategory();
				developmentCategory.setId(resultSet.getLong("id")); 
				developmentCategory.setDev_category_tech_id(resultSet.getLong("dev_category_tech_id"));
				developmentCategory.setCategory_title(resultSet.getString("category_title"));
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

		return developmentCategory;
	}

	@Override
	public List<DevelopmentCategory> getByTechId(long dev_category_tech_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DevelopmentCategory  developmentCategory = null;
		List<DevelopmentCategory>  developmentCategories = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM development_categories";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				developmentCategory = new DevelopmentCategory();
				developmentCategories = new ArrayList<DevelopmentCategory>();
				developmentCategory.setId(resultSet.getLong("id")); 
				developmentCategory.setDev_category_tech_id(resultSet.getLong("dev_category_tech_id"));
				developmentCategory.setCategory_title(resultSet.getString("category_title"));
				developmentCategories.add(developmentCategory);
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

		return developmentCategories;
	}

	@Override
	public boolean update(DevelopmentCategory developmentCategory , long id) {
		boolean isUpdated =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE development_categories SET category_title = ?  WHERE id=?";
			preparedStatement  =connection.prepareStatement(sql);
			preparedStatement.setString(1, developmentCategory.getCategory_title());
			preparedStatement.setLong(2, id);
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
	public DevelopmentCategory deleteByID(long id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		DevelopmentCategory  developmentCategory =null;

		try {
			connection = DataBaseUtil.getConnection();
			developmentCategory = get(id);
			String sql = "DELETE FROM development_categories WHERE id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return developmentCategory;
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
