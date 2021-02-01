package com.surugi.jm.jm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.surugi.jm.domain.JmContactVo;
import com.surugi.jm.domain.JmMemberVo;
import com.surugi.jm.domain.JmPagingDto;

@Controller
@RequestMapping("/jm")
public class jm_ManagerController {

	@Inject
	private JmMemberService jmMemberService;
	
	//管理者ページの一般会員リスト照会
	@RequestMapping(value = "/jm_userList",method = RequestMethod.GET)
	public String selectList(JmPagingDto jmPagingDto,Model model)throws Exception{
		jmPagingDto.setPageInfo();
		int totalCount = jmMemberService.selectUserCount(jmPagingDto);
		jmPagingDto.setTotalCount(totalCount);
		List<JmMemberVo> list = jmMemberService.selectUserPaging(jmPagingDto);
		model.addAttribute("list",list);
		model.addAttribute("jmPagingDto",jmPagingDto);
		return "/jm/jm_userList";
	}
	
	//管理者ページ一般会員個人別情報照会
	@RequestMapping(value = "/jm_userUpdate",method = RequestMethod.GET)
	public void selectById(String u_id,Model model)throws Exception{
		JmMemberVo jmMemberVo = jmMemberService.selectByid(u_id);
		System.out.println("jmMemberVo"+jmMemberVo);
		model.addAttribute("jmMemberVo",jmMemberVo);
	}
	
	//管理者ページの一般会員修正
	@RequestMapping(value = "/jm_userUpdateRun",method = RequestMethod.POST)
	public String userUpdate(JmMemberVo jmMemberVo)throws Exception{
		jmMemberService.updateUser(jmMemberVo);
		return "redirect:/jm/jm_userList";
	}
	
	//管理者ページ一般会員削除
	@RequestMapping(value = "/jm_userDelete",method = RequestMethod.GET)
	public String userDelete(String u_id)throws Exception{
		jmMemberService.deleteUser(u_id);
		return "redirect:/jm/jm_userList";
	}
	
	//管理者Q&A掲示板の書き込みフォーム
	@RequestMapping(value = "/jm_contactManagerInsert/{c_info}",method = RequestMethod.GET)
	public String jmContactManagerInsertFrom(@PathVariable("c_info") int c_info,Model model)throws Exception{
		int origin = jmMemberService.selectOriginNum(c_info);
		model.addAttribute("origin",origin);
		return "/jm/jm_contactManagerInsert";
	}
	
	//管理者Q&A掲示板の書き込み機能
	@RequestMapping(value = "/jm_contactManagerInsertRun", method = RequestMethod.POST)
	public String jmContactManagerInserRun(JmContactVo jmContactVo ,Model model)throws Exception{
		jmMemberService.contactManagerInsert(jmContactVo);
		model.addAttribute("jmContactVo",jmContactVo);
		return "redirect:/jm/jm_contact";
	}
	
	//Q&A掲示板管理者削除機能
	@RequestMapping(value = "/jm_deleteContact/{c_info}",method = RequestMethod.GET)
	public String deleteContact(@PathVariable("c_info") int c_info)throws Exception{
		jmMemberService.deleteContact(c_info);
		return "redirect:/jm/jm_contact";
	}
	
}
