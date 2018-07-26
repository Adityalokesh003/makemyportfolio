package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import makemyportfolio.bo.ExtracurricularInfo;
import makemyportfolio.dao.ExtracurricularInfoDao;
import makemyportfolio.util.db.DataBaseUtil;

public class ExtracurricularInfoDaoOracleImpl implements ExtracurricularInfoDao {
	private long getNewID(Connection con) throws SQLException {

		String sql="SELECT NVL(MAX(id),0)+1 FROM extracurricular_info";
		ResultSet rs = con.createStatement().executeQuery(sql);
		if(rs.next()){
			return rs.getLong(1);
		}
		return 0;
	}
	
	@Override
	public boolean add(ExtracurricularInfo extracurricularInfo) {
		boolean isAdded =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "INSERT INTO extracurricular_info(id,extracur_profile_id,activity_title,activity_description)VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			long id  = getNewID(connection);
			preparedStatement.setLong(1, id);
			preparedStatement.setLong(2, extracurricularInfo.getExtracur_profile_id());
			preparedStatement.setString(3, extracurricularInfo.getActivity_title());
			preparedStatement.setString(4, extracurricularInfo.getActivity_description());

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
	public ExtracurricularInfo get(long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ExtracurricularInfo extracurricularInfo =null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM extracurricular_info WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				extracurricularInfo = new ExtracurricularInfo();
				extracurricularInfo.setId(resultSet.getLong("id"));
				extracurricularInfo.setExtracur_profile_id(resultSet.getLong("extracur_profile_id"));
				extracurricularInfo.setActivity_title(resultSet.getString("activity_title"));
				extracurricularInfo.setActivity_description(resultSet.getString("activity_description"));
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

		return extracurricularInfo;
	}

	@Override
	public List<ExtracurricularInfo> getByProfileId(long extracur_profile_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ExtracurricularInfo extracurricularInfo =null;
		List<ExtracurricularInfo> extracurricularInfos = null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM extracurricular_info WHERE extracur_profile_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, extracur_profile_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				extracurricularInfo = new ExtracurricularInfo();
				extracurricularInfos = new ArrayList<ExtracurricularInfo>();
				extracurricularInfo.setId(resultSet.getLong("id"));
				extracurricularInfo.setExtracur_profile_id(resultSet.getLong("extracur_profile_id"));
				extracurricularInfo.setActivity_title(resultSet.getString("activity_title"));
				extracurricularInfo.setActivity_description(resultSet.getString("activity_description"));
				extracurricularInfos.add(extracurricularInfo);
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

		return extracurricularInfos;
	}

	@Override
	public boolean updateById(long id, ExtracurricularInfo extracurricularInfo) {
		boolean isUpdated =false;
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE extracurricular_info SET activity_title =? ,activity_description=? WHERE id=?";
			preparedStatement  =connection.prepareStatement(sql);
			preparedStatement.setString(1, extracurricularInfo.getActivity_title());
			preparedStatement.setString(2, extracurricularInfo.getActivity_description());
			preparedStatement.setLong(3, id);
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
	public ExtracurricularInfo deleteById(long id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		ExtracurricularInfo extracurricularInfo = null;
		try {
			connection = DataBaseUtil.getConnection();
			extracurricularInfo = get(id);
			String sql = "DELETE FROM extracurricular_info WHERE id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return extracurricularInfo;
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
