package com.dashboard.mini;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.mini.service.IMemberService;

@RestController
@RequestMapping("/LogIn")
public class logIn {
	@Autowired
	IMemberService service;
	

	//����Ʈ���� ������ �ؽ�Ʈ�� id�� �������� �׽�Ʈ
	@RequestMapping("/chkAvailableID")
	public boolean returnIDAvailable(String inputID, HttpServletRequest request) {
		//id�� ���Խ� ǥ��
		String idReg = "^[A-Za-z0-9]{5,19}$";
		String id = request.getParameter("inputID");
		boolean regex = Pattern.matches(idReg, id);
		//���Խ�
		if(!regex) {
			return false;
		}
		//DB
		return service.chkAvailableID(id);
	}
	

	@RequestMapping("/chkAvailablePW")
	public boolean returnPWAvailable(String inputPW,  HttpServletRequest request) {
		//pw�� ���Խ� ǥ��
		String pwReg = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&~*+-=])(?=.*[0-9]).{7,15}$";
		String pw = request.getParameter("inputPW");
		boolean regex = Pattern.matches(pwReg, pw);
		return regex;
	}
	
	
	@RequestMapping("/chkisPWSame")
	public boolean returnisPWSame(HttpServletRequest request) {

		String pw = request.getParameter("UserPW");
		String pwCheck = request.getParameter("userPWCheck");
		if(pw.equals(pwCheck)) {
			return true;
		}
		return false;
	}
}
