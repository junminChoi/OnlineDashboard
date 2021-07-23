package com.dashboard.mini;

import java.util.Locale;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dashboard.mini.cookies.CookieUserID;
import com.dashboard.mini.cookies.CookieUserPW;
import com.dashboard.mini.service.IMemberService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class MemberController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(MemberController.class);

	@Autowired
	IMemberService service;

	/*
	 * @RequestMapping(value = "/LogIn/Join") public String login(Locale locale,
	 * Model model) { return "LogIn/Join"; }
	 */
	@RequestMapping(value = "/joinMember")
	public String JoinMembers(Locale locale, Model model, HttpServletRequest request) throws Exception {
		String id = request.getParameter("inputID");
		String pw = request.getParameter("inputPW");
		String pwCheck = request.getParameter("userPWCheck");

		String pwReg = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&~*+-=])(?=.*[0-9]).{7,15}$";
		boolean regex = Pattern.matches(pwReg, pw);
		System.out.println(id + "���" + pw + "���Ȯ��" + pwCheck);

		// if���� ���� ����ϸ� �ش� �����ʹ� ��� ������ ���̵��̸�, �˻� ����� ��� ��ģ �н������̴�.
		if (service.chkAvailableID(id)) {
			if (regex) {
				if (pw.equals(pwCheck)) {
					service.insertMember(id, pw);
					
					System.out.println("ȸ������ �Ϸ�");
					return "home";
				}
			}
		}
		System.out.println("�� ������ �ʱ�ȭ��~");
		// ������ �ʱ�ȭ
		return "Join";
	}

	/*
	 * @RequestMapping(value = "/LogIn/login", method = RequestMethod.GET) public
	 * ModelAndView loginCheck(HttpServletRequest request, ModelAndView mav) {
	 * 
	 * return mav; }
	 */

	@RequestMapping(value = "/LogIn/login")
	public String login(Model model , HttpServletRequest request , @CookieValue(value = "CookieID", required = false) Cookie CookieID, @CookieValue(value = "CookiePW", required = false) Cookie CookiePW) {
		model.addAttribute("cookieID" , CookieID.getValue());
		model.addAttribute("cookiePW", CookiePW.getValue());
		return "LogIn/login";
	}

	@RequestMapping(value = "/LogIn/loginCheck", method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest request,  HttpServletResponse response) {
		String userID = request.getParameter("userID");
		String userPwd = request.getParameter("userPwd");
		
		String chkBox = request.getParameter("isIDSave");
		//System.out.println(userID + userPwd + chkBox);
		if (service.chkLoginID(userID) == null) {
			return "redirect:login";
		}
		//�α��� ����
		if (service.chkLoginPW(service.chkLoginID(userID), userPwd)) {
			if(chkBox!=null) {
				Cookie idCookie = new Cookie("CookieID", userID);
				Cookie pwCookie = new Cookie("CookiePW", userPwd);
				
				response.addCookie(idCookie);
				response.addCookie(pwCookie);
				
			}
			//��Ű ������ ���� 
			/*
			 * if(cookieUserID.isCookieDel()) {
			 * 
			 * }
			 * 
			 * if(userID.equals("junmin")) { Cookie idCookie = new Cookie("CookieID",
			 * cookieUserID.getCookieID()); Cookie pwCookie = new Cookie("CookiePW",
			 * cookieUserPW.getCookiePW());
			 * 
			 * }
			 */
			
			
			
			
			//���ǿ� ���̵� �����Ͽ� ������ ����մµ��� �α��εȻ��¸� �����ϵ��� ��
			HttpSession session = request.getSession();
			session.setAttribute("memberID", userID);

		} else {
			return "redirect:login";
		}

		return "redirect:/";
	}
}
