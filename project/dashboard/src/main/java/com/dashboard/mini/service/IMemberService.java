package com.dashboard.mini.service;

import java.util.List;

import com.dashboard.mini.domain.MemberVO;

public interface IMemberService {
	
	public String showMember();
	
	public void insertMember(String ID , String PW)  throws Exception;

	public List<MemberVO> showMemberList();
	
	public boolean chkAvailableID(String ID);
	
	public String chkLoginID(String ID);
	
	public boolean chkLoginPW(String ID , String PW);
}
