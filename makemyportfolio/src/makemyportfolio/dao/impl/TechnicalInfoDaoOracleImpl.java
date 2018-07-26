package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import makemyportfolio.bo.TechnicalInfo;
import makemyportfolio.dao.TechnicalInfoDao;
import makemyportfolio.util.db.DataBaseUtil;

public class TechnicalInfoDaoOracleImpl implements TechnicalInfoDao {
	private long getNewID(Connection con) throws SQLException {
		String sql="SELECT NVL(MAX(id),0)+1 FROM technical_info";
		ResultSet rs = con.createStatement().executeQuery(sql);
		if(rs.next()){
			return rs.getLong(1);
		}
		return 0;
	}
	
	@Override
	public boolean add(TechnicalInfo technicalInfo) {
		boolean isAdded =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "INSERT INTO technical_info(id,tech_profile_id,programming_languages,scripting_languages,os_known,databases_known)VALUES(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			long id  = getNewID(connection);
			preparedStatement.setLong(1, id);
			preparedStatement.setLong(2, technicalInfo.getTech_profile_id());
			preparedStatement.setString(3, technicalInfo.getProgramming_languages());
			preparedStatement.setString(4, technicalInfo.getScripting_languages());
			preparedStatement.setString(5, technicalInfo.getOs_known());
			preparedStatement.setString(6, technicalInfo.getDatabases_known());
			
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
	public TechnicalInfo get(long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		TechnicalInfo technicalInfo = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM technical_info WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				technicalInfo = new TechnicalInfo();
				technicalInfo.setId(resultSet.getLong("id")); 
				technicalInfo.setTech_profile_id(resultSet.getLong("tech_profile_id"));
				technicalInfo.setProgramming_languages(resultSet.getString("programming_languages"));
				technicalInfo.setScripting_languages(resultSet.getString("scripting_languages"));
				technicalInfo.setOs_known(resultSet.getString("os_known"));
				technicalInfo.setDatabases_known(resultSet.getString("databases_known"));
				
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

		return technicalInfo;
	}

	@Override
	public List<TechnicalInfo> getByProfileId(long tech_profile_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		TechnicalInfo technicalInfo = null;
		List<TechnicalInfo> technicalInfos = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM technical_info WHERE tech_profile_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, tech_profile_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				technicalInfo = new TechnicalInfo();
				technicalInfos = new ArrayList<TechnicalInfo>();
				technicalInfo.setId(resultSet.getLong("id")); 
				technicalInfo.setTech_profile_id(resultSet.getLong("tech_profile_id"));
				technicalInfo.setProgramming_languages(resultSet.getString("programming_languages"));
				technicalInfo.setScripting_languages(resultSet.getString("scripting_languages"));
				technicalInfo.setOs_known(resultSet.getString("os_known"));
				technicalInfo.setDatabases_known(resultSet.getString("databases_known"));
				technicalInfos.add(technicalInfo);			}

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

		return technicalInfos;
	}

	@Override
	public boolean updateById(long id, TechnicalInfo technicalInfo) {
		boolean isUpdated =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE technical_info SET programming_languages=?,scripting_languages=?,os_known=?,databases_known=? WHERE id=?";
			preparedStatement  =connection.prepareStatement(sql);
			preparedStatement.setString(1, technicalInfo.getProgramming_languages());
			preparedStatement.setString(2, technicalInfo.getScripting_languages());
			preparedStatement.setString(3, technicalInfo.getOs_known());
			preparedStatement.setString(4, technicalInfo.getDatabases_known());
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
	public TechnicalInfo deleteById(long id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		TechnicalInfo technicalInfo =null;

		try {
			connection = DataBaseUtil.getConnection();
			technicalInfo = get(id);
			String sql = "DELETE FROM technical_info WHERE id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return technicalInfo;
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
