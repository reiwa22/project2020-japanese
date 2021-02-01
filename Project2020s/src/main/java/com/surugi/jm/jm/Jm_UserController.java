package com.surugi.jm.jm;

import java.util.Enumeration;

import javax.inject.Inject;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.surugi.jm.domain.JmEmailDto;
import com.surugi.jm.domain.JmMemberVo;
import com.surugi.jm.domain.JmPwEmailDto;

@Controller
@RequestMapping("/jm")
public class Jm_UserController {

	@Inject
	private JmMemberService jmMemberService;
	
	@Inject
	private JavaMailSenderImpl MailSender;
	
	//ログインフォーム
	@RequestMapping(value = "/jm_login" ,method = RequestMethod.GET )
	public void jmLogin(/*String tagetLocation ,*/HttpSession session)throws Exception{
//		System.out.println("targetLocation"+tagetLocation);
//		session.setAttribute("targetLocation", tagetLocation);
		//TODO check
	}
	
	//ログイン処理
	@RequestMapping(value = "/jm_login" ,method = RequestMethod.POST)
	public String jmLoginPost(String u_id, String u_pw ,HttpSession session, RedirectAttributes rttr)
			throws Exception{
		
		
		boolean result = jmMemberService.selectMemberUserIdPw(u_id, u_pw);
		String u_grade = jmMemberService.selectGrade(u_id);
		
		if(result ==true) {
			session.setAttribute("u_id", u_id);
			session.setAttribute("u_grade", u_grade);
			//TODO targetLocation
//			String targetLocation = (String)session.getAttribute("targetLocation");
//			if(targetLocation !=null && !targetLocation.equals("")) {
//				session.removeAttribute("targetLocation");
//				return "redirect:" + targetLocation;
//			}
			
			Enumeration<String> enumer = session.getAttributeNames();
			while (enumer.hasMoreElements()) {
				String key = enumer.nextElement();
				System.out.println("key"+key);
		}
			return "redirect:/";	
		}
		return "redirect:/jm/jm_login";
	}
	//ログアウト
	@RequestMapping(value = "logout" , method = RequestMethod.GET)
	public String jmlogout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:/jm/jm_login";
	}
	
	//会員加入フォーム
	@RequestMapping(value = "/jm_signUp",method = RequestMethod.GET)
	public void jmSignUp() throws Exception{
		
	}
	
	//会員登録処理
	@RequestMapping(value = "/jm_signUpRun " ,method = RequestMethod.POST)
	public String jmMemberSignUpRun(JmMemberVo vo , JmEmailDto jmEmailDto)throws Exception{
		jmMemberService.insertMember(vo);
		//会員登録時のメール送信
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,false,"utf-8");
					helper.setFrom(jmEmailDto.getFrom());
					helper.setTo(jmEmailDto.getTo());
					helper.setSubject(jmEmailDto.getSubject());
					helper.setText(jmEmailDto.getContents());
				}
			};
		MailSender.send(preparator);
		return "redirect:/jm/jm_login";
	}
	
	//パスワード検索フォーム画面
	@RequestMapping(value = "/jm_userPw",method = RequestMethod.GET)
	public void userPwView(String u_id) throws Exception{
		
	}
	
	//パスワード検索データ(Eメール)
	@ResponseBody
	@RequestMapping(value = "/jm_userPwEmail" , method = RequestMethod.GET)
	public JmPwEmailDto userPw(String u_id)throws Exception{
		
		JmPwEmailDto jmPwEmailDto = jmMemberService.selectPw(u_id);
		return jmPwEmailDto;
	}
	
	//ID重複チェック
	@ResponseBody
	@RequestMapping(value = "/jm_selectIdCheck" ,method = RequestMethod.GET)
	public String selectId(String u_id)throws Exception{
		String id = jmMemberService.selectId(u_id);
		if( id !=null) {
			System.out.println("ok");
			return "success";
			
		}
		System.out.println("no");
		return "fail";
	}
	
	//個人情報照会
	@RequestMapping(value = "/jm_userInfo",method = RequestMethod.GET)
	public JmMemberVo selectUserInfo(HttpSession session,JmMemberVo jmMemberVo )throws Exception{
		String user_id = (String)session.getAttribute("u_id");
		jmMemberVo.setU_id(user_id);
		jmMemberVo = jmMemberService.selectUserById(user_id);
		return jmMemberVo;
	}
		
	//個人情報修正フォーム
	@RequestMapping(value = "/jm_userUpdateForm",method = RequestMethod.GET)
	public JmMemberVo selectUserById(HttpSession session, JmMemberVo jmMemberVo)throws Exception{
		String user_id = (String)session.getAttribute("u_id");
		//System.out.println("u_id;::"+user_id);
		jmMemberVo.setU_id(user_id);
		//System.out.println("jmMemberVo:::updateSelect"+jmMemberVo);
		jmMemberVo = jmMemberService.selectUserById(user_id);
		return jmMemberVo;
	}
	
	//個人情報修正実行
	@RequestMapping(value = "/jm_updateUserByIdRun",method = RequestMethod.POST)
	public String updateUserByIdRun(JmMemberVo jmMemberVo)throws Exception{
		System.out.println("jmMemberVo::"+jmMemberVo);
		jmMemberService.updateUserById(jmMemberVo);
		return "redirect:/jm/jm_userInfo";
	}
	
	//会員脱退
	@RequestMapping(value = "/jm_userInfoDelete",method = RequestMethod.GET)
	public String userInfoDelete(HttpSession session, String u_id)throws Exception{
		jmMemberService.deleteUser(u_id);
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
}
