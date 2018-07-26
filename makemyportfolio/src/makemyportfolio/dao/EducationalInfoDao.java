package makemyportfolio.dao;

import java.util.List;

import makemyportfolio.bo.EducationalInfo;

public interface EducationalInfoDao {
	public boolean add(EducationalInfo educationalInfo);
	public EducationalInfo get(long id);
	public List<EducationalInfo> getByProfileId(long education_profile_id);
	public boolean updateById(EducationalInfo educationalInfo,long id);
	public EducationalInfo deleteById(long id);
}
