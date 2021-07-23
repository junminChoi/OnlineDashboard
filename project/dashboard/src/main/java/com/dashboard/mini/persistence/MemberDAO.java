package com.dashboard.mini.persistence;

import java.util.List;

import com.dashboard.mini.domain.MemberVO;


public interface MemberDAO {

	public String getTime();
	
	public void insertMember(MemberVO vo);
	
	public MemberVO selectMember(String userid);
	
	public List<MemberVO> selectALLMembers();
	
}
