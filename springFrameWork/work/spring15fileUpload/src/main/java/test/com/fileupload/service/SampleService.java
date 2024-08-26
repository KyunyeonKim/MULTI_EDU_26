package test.com.fileupload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.fileupload.model.SampleDAO;
import test.com.fileupload.model.SampleVO;

@Service
public class SampleService {

	@Autowired
	SampleDAO dao;
	
	public int insert(SampleVO vo) {
		return dao.insert(vo);
	}

	public List<SampleVO> selectAll() {
		return dao.selectAll();
	}
	
	
}
