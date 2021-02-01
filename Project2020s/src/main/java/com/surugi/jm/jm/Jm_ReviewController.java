package com.surugi.jm.jm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.surugi.jm.domain.JmPagingDto;
import com.surugi.jm.domain.JmReviewVo;

@Controller
@RequestMapping("/jm")
public class Jm_ReviewController {

	@Inject
	private JmReviewService jmReviewService;
	
	//レビュー掲示板リスト
	@RequestMapping(value = "/jm_reviewForm",method = RequestMethod.GET)
	public String jmReviewForm(JmPagingDto jmPagingDto,Model model)throws Exception{
		jmPagingDto.setPageInfo();
		int totalCount = jmReviewService.selectCount(jmPagingDto);
		jmPagingDto.setTotalCount(totalCount);
		List<JmReviewVo> list = jmReviewService.selectPaging(jmPagingDto);
		
		model.addAttribute("list",list);
		model.addAttribute("jmPagingDto",jmPagingDto);
	
		return "/jm/jm_reviewForm";
	}
	
	//レビュー掲示板info照会
	@RequestMapping(value = "/jm_reviewInfo/{r_filesinfo}", method = RequestMethod.GET)
	public String jmReviewInfo(@PathVariable("r_filesinfo") int r_filesinfo,  Model model)throws Exception{
		
		JmReviewVo jmReviewVo = jmReviewService.selectReviewInfo(r_filesinfo);
		List<String> images = jmReviewService.selectReviewInfoImage(r_filesinfo);
	
		model.addAttribute("images",images);
		model.addAttribute("jmReviewVo",jmReviewVo);
		return "/jm/jm_reviewInfo";
	}
	
	//レビュー掲示板の書き込みフォーム
	@RequestMapping(value = "/jm_insertReviewForm",method = RequestMethod.GET)
	public void insertInfoForm()throws Exception{
		
	}
	
	//レビュー掲示板の書き込み作業
	@RequestMapping(value = "/jm_insertReviewRun",method = RequestMethod.POST)
	public String insertReviewRun(JmReviewVo jmReviewVo, Model model)throws Exception{
	
		jmReviewService.insertReview(jmReviewVo);
		
		System.out.println("jmReviewVo:insertReviewRun"+jmReviewVo);
		model.addAttribute("jmReviewVo",jmReviewVo);
		
	return "redirect:/jm/jm_reviewForm";	
	}
	
	//レビュー掲示板アップデートフォーム
	@RequestMapping(value = "/jm_updateReview" ,method = RequestMethod.GET)
	public void updateReviewForm(int r_info,Model model)throws Exception{
		JmReviewVo jmReviewVo = jmReviewService.selectReviewInfo(r_info);
		List<String> images = jmReviewService.selectReviewInfoImage(r_info);
		
		model.addAttribute("jmReviewVo",jmReviewVo);
		model.addAttribute("images",images);
	}
	
	//レビュー掲示板アップデートラン
	@RequestMapping(value = "/jm_updateReviewRun",method = RequestMethod.POST)
	public String upadateReviewRun(JmReviewVo jmReviewVo)throws Exception{
		jmReviewService.updateReview(jmReviewVo);
		System.out.println("jm_upadateReviewRun vo::::"+jmReviewVo);
		return "redirect:/jm/jm_reviewForm";
	}
	
	//レビュー掲示板削除機能
	@RequestMapping(value = "/jm_deleteReview/{r_info}",method = RequestMethod.GET)
	public String deleteReview(@PathVariable("r_info") int r_info)throws Exception{
		jmReviewService.deleteReivew(r_info);
		return "redirect:/jm/jm_reviewForm";
	}
}
