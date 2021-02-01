package com.surugi.jm.jm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.surugi.jm.domain.JmIntroVo;
import com.surugi.jm.domain.JmPagingDto;

@Controller
@RequestMapping("/jm")
public class Jm_IntroController {

	@Inject
	private JmIntroService jmIntroService;
	
	//紹介掲示板リスト
	@RequestMapping(value = "/jm_introForm",method = RequestMethod.GET)
	public String jmIntroForm(JmPagingDto jmPagingDto, Model model)throws Exception{
		jmPagingDto.setPageInfo();
		int totalCount = jmIntroService.selectCount(jmPagingDto);
		jmPagingDto.setTotalCount(totalCount);
		List<JmIntroVo> list = jmIntroService.selectPaging(jmPagingDto);
		model.addAttribute("list",list);
		model.addAttribute("jmPagingDto",jmPagingDto);
		return "/jm/jm_introForm";
	}
	
	//紹介掲示板info照会
	@RequestMapping(value = "/jm_introInfo/{i_filesinfo}",method = RequestMethod.GET)
	public String jmIntroInfo(@PathVariable("i_filesinfo") int i_filesinfo,Model model)throws Exception{
		JmIntroVo jmIntroVo = jmIntroService.selectIntroInfo(i_filesinfo);
		List<String> image = jmIntroService.selectIntroInfoImage(i_filesinfo);
		model.addAttribute("image",image);
		model.addAttribute("jmIntroVo",jmIntroVo);
		return "/jm/jm_introInfo";
	}
	
	//紹介掲示板の書き込みフォーム
	@RequestMapping(value = "/jm_insertIntroForm",method = RequestMethod.GET)
	public void insertIntroForm()throws Exception{
		
	}
	
	//紹介掲示板の書き込み作業
	@RequestMapping(value = "/jm_insertIntroRun",method = RequestMethod.POST)
	public String insertIntroRun(JmIntroVo jmIntroVo,Model model)throws Exception{
		System.out.println("jmIntroVo::::::!!!!"+jmIntroVo);
		jmIntroService.insertIntro(jmIntroVo);
		model.addAttribute("jmIntroVo",jmIntroVo);
		
		return "redirect:/jm/jm_introForm";
	}
	
	//紹介掲示板アップデートフォーム
	@RequestMapping(value = "/jm_updateIntro",method = RequestMethod.GET)
	public void updateReviewForm(int i_info,Model model)throws Exception{
		JmIntroVo jmIntroVo = jmIntroService.selectIntroInfo(i_info);
		List<String> images = jmIntroService.selectIntroInfoImage(i_info);
		model.addAttribute("jmIntroVo",jmIntroVo);
		model.addAttribute("images",images);
	}
	
	//紹介掲示板アップデートラン
	@RequestMapping(value = "/jm_updateIntroRun",method = RequestMethod.POST)
	public String updateIntroRun(JmIntroVo jmIntroVo)throws Exception{
		jmIntroService.updateIntro(jmIntroVo);
		return "redirect:/jm/jm_introForm";
	}
	
	//紹介掲示板削除機能
	@RequestMapping(value = "/jm_deleteIntro/{i_info}",method = RequestMethod.GET)
	public String deleteIntro(@PathVariable("i_info")int i_info)throws Exception{
		jmIntroService.deleteIntro(i_info);
		return "redirect:/jm/jm_introForm";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
