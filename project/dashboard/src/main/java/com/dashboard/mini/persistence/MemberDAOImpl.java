package com.dashboard.mini.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dashboard.mini.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String GetTime = "MemberMapper.getTime";
	private static final String InsertMember = "MemberMapper.insertMember";
	private static final String SelectMember = "MemberMapper.selectMember";
	private static final String SelectALLMember = "MemberMapper.selectALLID";
	
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(GetTime);
		
	}
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(InsertMember,vo);
	}
	@Override
	public MemberVO selectMember(String userid) {
		return (MemberVO)sqlSession.selectOne(SelectMember,userid);
	}
	
	public List<MemberVO> selectALLMembers() {
		return sqlSession.selectList(SelectALLMember);
	}
	
	

}
