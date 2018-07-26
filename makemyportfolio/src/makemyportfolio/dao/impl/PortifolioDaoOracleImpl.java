package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import makemyportfolio.bo.Portifolio;
import makemyportfolio.dao.PortifolioDao;
import makemyportfolio.util.db.DataBaseUtil;

public class PortifolioDaoOracleImpl implements PortifolioDao {
	
	private long getNewID(Connection con) throws SQLException {

		String sql="SELECT NVL(MAX(portifolio_id),0)+1 FROM portifolios";
		ResultSet rs = con.createStatement().executeQuery(sql);
		if(rs.next()){
			return rs.getLong(1);
		}
		return 0;
	}
	
	@Override
	public boolean add(Portifolio portifolio) {
		boolean isAdded =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "INSERT INTO portifolios (portifolio_id,portifolio_profile_id,about_yourself,strengths,weaknesses,interests,achievements,career_objective,links)VALUES(?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			long portifolio_id  = getNewID(connection);
			preparedStatement.setLong(1, portifolio_id);
			preparedStatement.setLong(2, portifolio.getPortifolio_profile_id());
			preparedStatement.setString(3, portifolio.getAbout_yourself());
			preparedStatement.setString(4,portifolio.getStrengths());
			preparedStatement.setString(5,portifolio.getWeaknesses());
			preparedStatement.setString(6,portifolio.getInterests());
			preparedStatement.setString(7, portifolio.getAchievements());
			preparedStatement.setString(8, portifolio.getCareer_objective());
			preparedStatement.setString(9, portifolio.getLinks());

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
	public Portifolio get(long portifolio_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Portifolio  portifolio = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM portifolios WHERE portifolio_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, portifolio_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				portifolio = new Portifolio();
				portifolio.setPortifolio_id(resultSet.getLong("portifolio_id"));
				portifolio.setPortifolio_profile_id(resultSet.getLong("portifolio_profile_id"));
				portifolio.setAbout_yourself(resultSet.getString("about_yourself"));
				portifolio.setStrengths(resultSet.getString("strengths"));
				portifolio.setWeaknesses(resultSet.getString("weaknesses"));
				portifolio.setInterests(resultSet.getString("interests"));
				portifolio.setAchievements(resultSet.getString("achievements"));
				portifolio.setCareer_objective(resultSet.getString("career_objective"));
				portifolio.setLinks(resultSet.getString("links"));
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

		return portifolio;
	}

	@Override
	public Portifolio getByProfileId(long portifolio_profile_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Portifolio  portifolio = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM portifolios WHERE portifolio_profile_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, portifolio_profile_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				portifolio = new Portifolio();
				portifolio.setPortifolio_id(resultSet.getLong("portifolio_id"));
				portifolio.setPortifolio_profile_id(resultSet.getLong("portifolio_profile_id"));
				portifolio.setAbout_yourself(resultSet.getString("about_yourself"));
				portifolio.setStrengths(resultSet.getString("strengths"));
				portifolio.setWeaknesses(resultSet.getString("weaknesses"));
				portifolio.setInterests(resultSet.getString("interests"));
				portifolio.setAchievements(resultSet.getString("achievements"));
				portifolio.setCareer_objective(resultSet.getString("career_objective"));
				portifolio.setLinks(resultSet.getString("links"));
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

		return portifolio;

	}

	@Override
	public boolean update(Portifolio portifolio, long portifolio_id) {
		boolean isUpdated =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE portifolios SET about_yourself = ? ,strengths =? ,weaknesses=?,interests=?,achievements=?,career_objective=?,links=? WHERE portifolio_id=?";
			preparedStatement  =connection.prepareStatement(sql);
			preparedStatement.setString(1, portifolio.getAbout_yourself());
			preparedStatement.setString(2,portifolio.getStrengths());
			preparedStatement.setString(3,portifolio.getWeaknesses());
			preparedStatement.setString(4,portifolio.getInterests());
			preparedStatement.setString(5,portifolio.getAchievements());
			preparedStatement.setString(6,portifolio.getCareer_objective());
			preparedStatement.setString(7,portifolio.getLinks());
			preparedStatement.setLong(8, portifolio_id );
			 
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
	public Portifolio deleteByProfileId(long portifolio_profile_id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		Portifolio  portifolio = null;

		try {
			connection = DataBaseUtil.getConnection();
			portifolio = get(portifolio_profile_id);
			String sql = "DELETE FROM profiles WHERE portifolio_profile_id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, portifolio_profile_id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return portifolio;
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
