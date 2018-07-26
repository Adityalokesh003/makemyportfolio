package makemyportfolio.dao;

import makemyportfolio.bo.Portifolio;

public interface PortifolioDao {
	public boolean add(Portifolio portifolio);
	public Portifolio get(long portifolio_id);
	public Portifolio getByProfileId(long portifolio_profile_id);
	public boolean update(Portifolio portifolio , long portifolio_id);
	public Portifolio deleteByProfileId(long  portifolio_profile_id);
}
