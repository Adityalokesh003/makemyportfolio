package makemyportfolio.dao;

import java.util.List;

import makemyportfolio.bo.TechnicalInfo;


public interface TechnicalInfoDao {
	public boolean add(TechnicalInfo technicalInfo);
	public TechnicalInfo get(long id);
	public List<TechnicalInfo> getByProfileId(long tech_profile_id);
	public boolean updateById(long id,TechnicalInfo technicalInfo);
	public TechnicalInfo deleteById(long id);

}
