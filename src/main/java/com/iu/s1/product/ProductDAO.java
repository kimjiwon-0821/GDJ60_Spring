package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.product.Product_OptionDTO;
import com.iu.s1.util.DBConnection;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.product.ProductDAO.";
	
	//delete
	public int setProductDelete(Long productNum) throws Exception{
		return sqlSession.delete(NAMESPACE+"setProductDelete", productNum);
	}
	
	//add
	public int setAddProduct(ProductDTO productDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddProduct", productDTO);
		
	}	
	
	//getDetail
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);
		//selectone은 1개만 받아올 수 있음
	}
	
	//getList
	public List<ProductDTO> getProductList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getProductList");
	}
	
	//getNum
	public Long getpProductNum() throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT BANK_SEQ.NEXTVAL FROM DUAL";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		Long num = rs.getLong(1);
		DBConnection.disConnection(rs, st, connection);
		return num;
	}
//	----------------------------------------------------------------------
	public int setAddProductOption(Product_OptionDTO product_OptionDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCT_OPTION VALUES(BANK_SEQ.NEXTVAL,?,?,?,?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setLong(1,product_OptionDTO.getPRODUCTNUM());
		st.setString(2,product_OptionDTO.getOPTIONNAME());
		st.setLong(3, product_OptionDTO.getOPTIONPRICE());
		st.setLong(4,product_OptionDTO.getJEGO());
		int result = st.executeUpdate();
		DBConnection.disConnection(st, connection);
		return result;
		
		
	}
	public List<Product_OptionDTO> getProduct_OptionList() throws Exception{
		List<Product_OptionDTO> arr = new ArrayList<Product_OptionDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCT_OPTION ";
		PreparedStatement st =connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Product_OptionDTO product_OptionDTO = new Product_OptionDTO();
			product_OptionDTO.setOPTIONNUM(rs.getLong("OPTIONNUM"));
			product_OptionDTO.setPRODUCTNUM(rs.getLong("PRODUCTNUM"));
			arr.add(product_OptionDTO);
		}
		DBConnection.disConnection(rs, st, connection);
		return arr;
	}


	
	
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		try {
			List<Product_OptionDTO> ar = productDAO.getProduct_OptionList();
			System.out.println(ar.size()!=0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
