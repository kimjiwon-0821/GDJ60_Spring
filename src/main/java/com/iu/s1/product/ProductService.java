package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.product.Product_OptionDTO;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
 // 여기서만 쓰세요~~~(이 클래스 내에서만 사용 가능 멤버변수)

	public int setAddProduct(ProductDTO productDTO, List<Product_OptionDTO> ar ) throws Exception{
		//product, option
		Long productNum=productDAO.getpProductNum();
		productDTO.setPRODUCTNUM(productNum);
		int result = productDAO.setAddProduct(productDTO);
		if(ar!=null) {
			for(Product_OptionDTO product_OptionDTO : ar) {
				product_OptionDTO.setPRODUCTNUM(productNum);
				result = productDAO.setAddProductOption(product_OptionDTO);
			}
		}
		return result;
	}
		
	public List<ProductDTO> getProductList()throws Exception {
		return productDAO.getProductList();
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO)throws Exception {
		return productDAO.getProductDetail(productDTO);	
	}
	
	
}