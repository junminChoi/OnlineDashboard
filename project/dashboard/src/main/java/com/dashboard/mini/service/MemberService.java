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

		MemberVO vo = dao.selectMember("�ع�");
		return vo.getID() + "/" + vo.getPW() + "/";

	}

	// DB�� ���(ID,PW) �÷��� ����Ʈ Ÿ������ ��ȯ
	public List<MemberVO> showMemberList() {
		return dao.selectALLMembers();
	}

	// �޾ƿ� ID�� DB�� ���̵��߿� ��ġ�ϴ°��� ������ F, ��ġ�ϴ� ���̵� ������ T
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

	// logIn�ÿ� ���̵� Ȯ���Ͽ� ���� ���̵� ������ ���� ��ȯ
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
