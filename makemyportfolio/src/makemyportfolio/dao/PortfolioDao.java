package makemyportfolio.dao;

import makemyportfolio.bo.Portfolio;

public interface PortfolioDao {
	public boolean add(Portfolio portfolio);
	public Portfolio get(long portfolio_id);
	public Portfolio getByProfileId(long portfolio_profile_id);
	public boolean update(Portfolio portifolio , long portfolio_id);
	public Portfolio deleteByProfileId(long  portfolio_profile_id);
}
