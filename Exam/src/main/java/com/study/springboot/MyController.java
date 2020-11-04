package com.study.springboot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.springboot.dto.MemberDto;
import com.study.springboot.service.IMemberService;



@Controller
public class MyController {
	@Autowired
	IMemberService member_service;
	/*
	 * @Autowired IBoardService board_service;
	 */

	@RequestMapping("/")
	public String root() throws Exception {
		return "redirect:login";
	}

	@RequestMapping("/login")
	public String login() throws Exception {
		return "login";
	}
	
	@RequestMapping("/main")
	public String main() throws Exception {
		return "main";
	}
	
	
	@RequestMapping("/findId")
	public String findId() throws Exception {
		return "findId";
	}
	
	@RequestMapping("/findPw")
	public String findPw() throws Exception {
		return "findPw";
	}
	
	@RequestMapping("/join")
	public String join() throws Exception {
		return "join";
	}
	
	@RequestMapping(value = "/JoinAction", method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String MemberJoinAction(HttpServletRequest req, Model model) throws Exception{
		req.setCharacterEncoding("utf-8"); // 인코딩
		
		int nResult = member_service.insertMember( req );
		if( nResult <= 0 ) {
			System.out.println("회원가입 실패");
			
	        model.addAttribute("msg","회원가입 실패");
	        model.addAttribute("url","/");
		}else {
			System.out.println("회원가입 성공");
			
			model.addAttribute("msg","회원가입 성공");
            model.addAttribute("url","/");
		}
		
		return "login";
	}
	
	@RequestMapping("/MemberLoginAction")
	public String MemberLoginAction(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		
		int nResult = member_service.loginCheck(id, pw);
		if( nResult <= 0 ) {
			System.out.println("로그인 실패");
			
	        model.addAttribute("msg","로그인 실패 - 아이디나 암호를 확인해주세요");
	        model.addAttribute("url","/login");
	        return "redirect:login";
		}else {
			System.out.println("로그인 성공");
			
			//로그인 성공 -> 세션에 아이디를 저장
			HttpSession session = req.getSession();
	   		session.setAttribute("sessionID", id);
			
			model.addAttribute("msg","로그인 성공");
            model.addAttribute("url","/main");
            return "redirect:main";
		}
		
        
		 //redirect.jsp
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpServletRequest req, RedirectAttributes redirect) {
		String id = req.getSession().getAttribute("sessionID").toString();
		
		MemberDto dto = member_service.getUserInfo(id);
		
		req.getSession().setAttribute("memberInfo", dto);
		  
		return "mypage";
	}
	
	@RequestMapping(value="/membermodify", method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String membermodify(HttpServletRequest req, Model model) throws Exception {
		System.out.println("name : "+req.getParameter("name"));
		
		req.setCharacterEncoding("utf-8"); // 인코딩
		
		int nResult = member_service.updateMember(req);
		
		if( nResult <= 0 ) {
			System.out.println("회원수정 실패");
			
			model.addAttribute("msg","회원수정 실패");
			model.addAttribute("url","/ModifyFrom");
			return "mypage";
		}else {
			System.out.println("회원수정 성공");
			
			model.addAttribute("msg","회원수정 성공");
			model.addAttribute("url","/UserInfoForm");
			return "main";
		}
	
	}
	

	
	@RequestMapping("/coment")
	public String coment() throws Exception {
		return "coment";
	}
	@RequestMapping("/contents")
	public String contents() throws Exception {
		return "contents";
	}
	@RequestMapping("/dropout")
	public String dropout() throws Exception {
		return "dropout";
	}
	@RequestMapping("/write")
	public String write() throws Exception {
		return "write";
	}
}
