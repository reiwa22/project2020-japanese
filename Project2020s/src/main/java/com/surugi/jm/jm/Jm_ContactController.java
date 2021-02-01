package com.surugi.jm.jm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.surugi.jm.domain.JmContactVo;
import com.surugi.jm.domain.JmPagingDto;

@Controller
@RequestMapping("/jm")
public class Jm_ContactController {

	@Inject
	private JmContactService jmContactService;
	
	//Q&A掲示板リスト
	@RequestMapping(value = "/jm_contact", method = RequestMethod.GET)
	public String jmContact(JmPagingDto jmPagingDto, Model model)throws Exception{
		jmPagingDto.setPageInfo();
		int totalCount = jmContactService.selectCount(jmPagingDto);
		jmPagingDto.setTotalCount(totalCount);
		List<JmContactVo> list = jmContactService.selectPaging(jmPagingDto);
		model.addAttribute("list",list);
		model.addAttribute("jmPagingDto",jmPagingDto);

		return "/jm/jm_contact";
	}
	
	//Q&A掲示板info照会
	@RequestMapping(value = "/jm_contactInfo/{c_info}" ,method = RequestMethod.GET)
	public String jmContactInfo(@PathVariable("c_info")int c_info,Model model)throws Exception{
		JmContactVo jmContactVo = jmContactService.selectContactInfo(c_info);
		model.addAttribute("jmContactVo",jmContactVo);
		
		return "/jm/jm_contactInfo";
	}
	
	//Q&A掲示板の書き込みフォーム
	@RequestMapping(value = "/jm_insertContactForm",method = RequestMethod.GET)
	public void insertContactForm()throws Exception{
	}
	
	//Q&A掲示板の書き込み作業
	@RequestMapping(value = "/jm_insertContactRun", method = RequestMethod.POST)
	public String insertContactRun(JmContactVo jmContactVo,Model model)throws Exception{
		jmContactService.insertContact(jmContactVo);
		model.addAttribute("jmContactVo",jmContactVo);
		
		return "redirect:/jm/jm_contact";
	}
	
	//Q&A掲示板アップデートフォーム
	@RequestMapping(value = "/jm_updateContact",method = RequestMethod.GET)
	public void updateContactForm (int c_info , Model model)throws Exception{
		JmContactVo jmContactVo = jmContactService.selectContactInfo(c_info);
		model.addAttribute("jmContactVo",jmContactVo);	
	}
	
	//Q&A掲示板アップデート作業
	@RequestMapping(value = "/jm_updateContactRun",method = RequestMethod.POST)
	public String updateContactRun(JmContactVo jmContactVo)throws Exception{
		jmContactService.upadateContact(jmContactVo);
		
		return "redirect:/jm/jm_contact";
	}
}
