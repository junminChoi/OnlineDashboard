package com.dashboard.mini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.mini.domain.MemberVO;
import com.dashboard.mini.persistence.MemberDAO;

@Service
public class MemberService implements IMemberService {
	@Autowired
	MemberDAO dao;

	public void insertMember(String ID, String PW) throws Exception {
		MemberVO vo = new MemberVO();
		vo.setID(ID);
		vo.setPW(PW);

		dao.insertMember(vo);
	}

	public String showMember() {

		MemberVO vo = dao.selectMember("준민");
		return vo.getID() + "/" + vo.getPW() + "/";

	}

	// DB의 멤버(ID,PW) 컬럼을 리스트 타입으로 반환
	public List<MemberVO> showMemberList() {
		return dao.selectALLMembers();
	}

	// 받아온 ID가 DB의 아이디중에 일치하는것이 있으면 F, 일치하는 아이디가 없으면 T
	@Override
	public boolean chkAvailableID(String ID) {
		List<MemberVO> memberList = dao.selectALLMembers();
		for (int i = 0; i < memberList.size(); i++) {
			if (ID.equals(memberList.get(i).getID())) {
				return false;
			}
		}
		return true;
	}

	// logIn시에 야이디를 확인하여 같은 아이디가 들어오면 값을 반환
	public String chkLoginID(String ID) {
		List<MemberVO> memberList = dao.selectALLMembers();
		for (int i = 0; i < memberList.size(); i++) {
			if (ID.equals(memberList.get(i).getID())) {
				return memberList.get(i).getID();
			}
		}
		return null;
	}

	@Override
	public boolean chkLoginPW(String ID, String PW) {
		MemberVO vo = dao.selectMember(ID);
		System.out.println(vo.getID() + vo.getPW());

		if (PW.equals(vo.getPW())) {
			return true;
		}

		return false;
	}

}
