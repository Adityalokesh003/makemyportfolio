package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import makemyportfolio.bo.EducationalInfo;
import makemyportfolio.dao.EducationalInfoDao;
import makemyportfolio.util.db.DataBaseUtil;

public class EducatioalInfoDaoOracleImpl implements EducationalInfoDao {
	
	private long getNewID(Connection con) throws SQLException {

		String sql="SELECT NVL(MAX(id),0)+1 FROM educational_info";
		ResultSet rs = con.createStatement().executeQuery(sql);
		if(rs.next()){
			return rs.getLong(1);
		}
		return 0;
	}

	@Override
	public boolean add(EducationalInfo educationalInfo) {
		boolean isAdded =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "INSERT INTO educational_info(id,education_profile_id,institution_name,degree_type,year_of_pass,percentage)VALUES(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			long id  = getNewID(connection);
			preparedStatement.setLong(1, id);
			preparedStatement.setLong(2, educationalInfo.getEducation_profile_id());
			preparedStatement.setString(3, educationalInfo.getInstitution_name());
			preparedStatement.setString(4,educationalInfo.getDegree_type());
			preparedStatement.setLong(5,educationalInfo.getYear_of_pass());
			preparedStatement.setLong(6,educationalInfo.getPercentage());

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
	public EducationalInfo get(long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		EducationalInfo educationalInfo = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM educational_info WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				educationalInfo = new  EducationalInfo();
				educationalInfo.setId(resultSet.getLong("id")); 
				educationalInfo.setEducation_profile_id(resultSet.getLong("education_profile_id"));
				educationalInfo.setInstitution_name(resultSet.getString("institution_name"));
				educationalInfo.setDegree_type(resultSet.getString("degree_type"));
				educationalInfo.setYear_of_pass(resultSet.getInt("year_of_pass"));
				educationalInfo.setPercentage(resultSet.getInt("percentage"));
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

		return educationalInfo;
	}

	@Override
	public List<EducationalInfo> getByProfileId(long education_profile_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		EducationalInfo educationalInfo = null;
		List<EducationalInfo> educationalInfos = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM educational_info WHERE education_profile_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, education_profile_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				educationalInfo = new EducationalInfo();
				educationalInfos = new ArrayList<EducationalInfo>();
				educationalInfo.setId(resultSet.getLong("id")); 
				educationalInfo.setEducation_profile_id(resultSet.getLong("education_profile_id"));
				educationalInfo.setInstitution_name(resultSet.getString("institution_name"));
				educationalInfo.setDegree_type(resultSet.getString("degree_type"));
				educationalInfo.setYear_of_pass(resultSet.getInt("year_of_pass"));
				educationalInfo.setPercentage(resultSet.getInt("percentage"));
				educationalInfos.add(educationalInfo);
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

		return educationalInfos;
	}

	@Override
	public boolean updateById(EducationalInfo educationalInfo, long id) {
		boolean isUpdated =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE educational_info SET institution_name= ? ,degree_type= ? ,year_of_pass= ? ,percentage=? WHERE id=?";
			preparedStatement  =connection.prepareStatement(sql);
			preparedStatement.setString(1, educationalInfo.getInstitution_name());
			preparedStatement.setString(2, educationalInfo.getDegree_type());
			preparedStatement.setInt(3, educationalInfo.getYear_of_pass());
			preparedStatement.setInt(4,educationalInfo.getPercentage());
			preparedStatement.setLong(5, id);
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
	public EducationalInfo deleteById(long id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		EducationalInfo educationalInfo=null;

		try {
			connection = DataBaseUtil.getConnection();
			educationalInfo = get(id);
			String sql = "DELETE FROM educational_info WHERE id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return educationalInfo;
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
