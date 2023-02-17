package com.iu.s1.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.util.Pager;

public class ProductDAOTest extends MyTestCase{
	
	@Autowired //주입
	private ProductDAO productDAO;
	
	@Test
	public void getProductListTest(Pager pager)throws Exception {
		List<ProductDTO> ar = productDAO.getProductList(pager);
		//단정문
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getProductDetailTest() throws Exception{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(11L);
		productDTO = productDAO.getProductDetail(productDTO);
		assertNotNull(productDTO);
	}

	@Test
	public void getProductAddTest() throws Exception{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(500L);
		productDTO.setProductName("s");
		productDTO.setProductDetail("s");
		int result = productDAO.setProductAdd(productDTO);
		assertEquals(1, result);
	}
}
