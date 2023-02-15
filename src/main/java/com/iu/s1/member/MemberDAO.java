package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.bankBook.BankBookDTO;
import com.iu.s1.product.ProductDTO;
import com.iu.s1.util.DBConnection;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.member.MemberDAO.";
	public int setMemberAdd(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setMemberAdd", memberDTO);
	}
	public List<MemberDTO> getMemberList() throws Exception {
	      return sqlSession.selectList(NAMESPACE+"getMemberList");
	   }
	public int setMemberRoleAdd(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setMemberRoleAdd", memberDTO);
	}
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getMemberLogin", memberDTO);
	}
	public int  setMemberUpdate(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setMemberUpdate",memberDTO );
		
	}
}
