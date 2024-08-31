package test.com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.product.model.ProductDAO;
import test.com.product.model.ProductVO;


@Service
public class ProductService {

	@Autowired
	ProductDAO dao;

	public int insert(ProductVO vo) {
		return dao.insert(vo);
	}

	public int update(ProductVO vo) {
		return dao.update(vo);
	}

	public int delete(ProductVO vo) {
		return dao.delete(vo);
	}

	public ProductVO selectOne(ProductVO vo) {
		return dao.selectOne(vo);
	}

	public List<ProductVO> selectAll() {
		return dao.selectAll();
	}

	public List<ProductVO> searchList(String searchKey, String searchWord) {
		return dao.searchList(searchKey, searchWord);
	}

}
