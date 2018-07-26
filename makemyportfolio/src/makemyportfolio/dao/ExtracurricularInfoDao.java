package makemyportfolio.dao;

import java.util.List;

import makemyportfolio.bo.ExtracurricularInfo;


public interface ExtracurricularInfoDao {
	public boolean add(ExtracurricularInfo extracurricularInfo);
	public ExtracurricularInfo get(long id);
	public List<ExtracurricularInfo> getByProfileId(long extracur_profile_id);
	public boolean updateById(long id,ExtracurricularInfo extracurricularInfo);
	public ExtracurricularInfo deleteById(long id);
}
