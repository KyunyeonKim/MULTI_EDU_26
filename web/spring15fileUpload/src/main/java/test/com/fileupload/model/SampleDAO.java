package test.com.fileupload.model;

import java.util.List;

public interface SampleDAO {
	
	public int insert(SampleVO vo);

	public List<SampleVO> selectAll();

}
