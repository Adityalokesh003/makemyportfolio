package makemyportfolio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import makemyportfolio.bo.Portfolio;
import makemyportfolio.dao.PortfolioDao;
import makemyportfolio.util.db.DataBaseUtil;

public class PortfolioDaoOracleImpl implements PortfolioDao {
	
	private long getNewID(Connection con) throws SQLException {

		String sql="SELECT NVL(MAX(portifolio_id),0)+1 FROM portifolios";
		ResultSet rs = con.createStatement().executeQuery(sql);
		if(rs.next()){
			return rs.getLong(1);
		}
		return 0;
	}
	
	@Override
	public boolean add(Portfolio portfolio) {
		boolean isAdded =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "INSERT INTO portfolios (portfolio_id,portfolio_profile_id,about_yourself,strengths,weaknesses,interests,achievements,career_objective,links)VALUES(?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			long portfolio_id  = getNewID(connection);
			preparedStatement.setLong(1, portfolio_id);
			preparedStatement.setLong(2, portfolio.getPortfolio_profile_id());
			preparedStatement.setString(3, portfolio.getAbout_yourself());
			preparedStatement.setString(4,portfolio.getStrengths());
			preparedStatement.setString(5,portfolio.getWeaknesses());
			preparedStatement.setString(6,portfolio.getInterests());
			preparedStatement.setString(7, portfolio.getAchievements());
			preparedStatement.setString(8, portfolio.getCareer_objective());
			preparedStatement.setString(9, portfolio.getLinks());

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
	public Portfolio get(long portfolio_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Portfolio  portfolio = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM portfolios WHERE portfolio_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, portfolio_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				portfolio = new Portfolio();
				portfolio.setPortfolio_id(resultSet.getLong("portfolio_id"));
				portfolio.setPortfolio_profile_id(resultSet.getLong("portfolio_profile_id"));
				portfolio.setAbout_yourself(resultSet.getString("about_yourself"));
				portfolio.setStrengths(resultSet.getString("strengths"));
				portfolio.setWeaknesses(resultSet.getString("weaknesses"));
				portfolio.setInterests(resultSet.getString("interests"));
				portfolio.setAchievements(resultSet.getString("achievements"));
				portfolio.setCareer_objective(resultSet.getString("career_objective"));
				portfolio.setLinks(resultSet.getString("links"));
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

		return portfolio;
	}

	@Override
	public Portfolio getByProfileId(long portfolio_profile_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Portfolio  portfolio = null;

		try {
			connection = DataBaseUtil.getConnection();
			String sql= "SELECT * FROM portfolios WHERE portfolio_profile_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, portfolio_profile_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				portfolio = new Portfolio();
				portfolio.setPortfolio_id(resultSet.getLong("portfolio_id"));
				portfolio.setPortfolio_profile_id(resultSet.getLong("portfolio_profile_id"));
				portfolio.setAbout_yourself(resultSet.getString("about_yourself"));
				portfolio.setStrengths(resultSet.getString("strengths"));
				portfolio.setWeaknesses(resultSet.getString("weaknesses"));
				portfolio.setInterests(resultSet.getString("interests"));
				portfolio.setAchievements(resultSet.getString("achievements"));
				portfolio.setCareer_objective(resultSet.getString("career_objective"));
				portfolio.setLinks(resultSet.getString("links"));
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

		return portfolio;

	}

	@Override
	public boolean update(Portfolio portfolio, long portfolio_id) {
		boolean isUpdated =false;
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DataBaseUtil.getConnection();
			String sql = "UPDATE portfolios SET about_yourself = ? ,strengths =? ,weaknesses=?,interests=?,achievements=?,career_objective=?,links=? WHERE portifolio_id=?";
			preparedStatement  =connection.prepareStatement(sql);
			preparedStatement.setString(1, portfolio.getAbout_yourself());
			preparedStatement.setString(2,portfolio.getStrengths());
			preparedStatement.setString(3,portfolio.getWeaknesses());
			preparedStatement.setString(4,portfolio.getInterests());
			preparedStatement.setString(5,portfolio.getAchievements());
			preparedStatement.setString(6,portfolio.getCareer_objective());
			preparedStatement.setString(7,portfolio.getLinks());
			preparedStatement.setLong(8, portfolio_id );
			 
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
	public Portfolio deleteByProfileId(long portfolio_profile_id) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		Portfolio  portfolio = null;

		try {
			connection = DataBaseUtil.getConnection();
			portfolio = get(portfolio_profile_id);
			String sql = "DELETE FROM portfolios WHERE portfolio_profile_id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, portfolio_profile_id);
			int result = preparedStatement.executeUpdate();
			if (result ==1) {
				return portfolio;
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
