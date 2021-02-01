package com.surugi.jm;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.surugi.jm.domain.JmIntroVo;
import com.surugi.jm.domain.JmMemberVo;
import com.surugi.jm.domain.JmReviewVo;
import com.surugi.jm.jm.JmIntroDao;
import com.surugi.jm.jm.JmIntroService;
import com.surugi.jm.jm.JmMemberDao;
import com.surugi.jm.jm.JmMemberService;
import com.surugi.jm.jm.JmReviewDao;
import com.surugi.jm.jm.JmReviewService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class test {

	@Inject
	JmMemberDao jmMemberDao;
	@Inject
	JmMemberService JmMemberService;
	@Inject
	JmReviewDao jmReviewDao;
	@Inject
	JmReviewService jmReviewService;
	@Inject
	JmIntroDao jmIntroDao;
	@Inject
	JmIntroService JmIntroService;
	//ID重複チェック
	@Test
	public void selectIdd()throws Exception{
		jmMemberDao.selectId("aaa");
		}
	@Test
	public void selectIds()throws Exception{
		JmMemberService.selectId("aaa");
		}
	
	@Test
	public void insertMember()throws Exception{
		JmMemberVo vo = new JmMemberVo();
		
		vo.setU_id("123");
		vo.setU_pw("123");
		vo.setU_name("123");
		vo.setU_gender("f");
		vo.setU_email("123@123");
		vo.setU_address("123");
		vo.setU_phone("123");
		jmMemberDao.insertMember(vo);
		
		}
	
	@Test
	public void selectPw()throws Exception{
	 jmMemberDao.selectPw("tester");
	}
	@Test
	public void selectReviewInfoDao() throws Exception {
		jmReviewDao.selectReviewInfo(393);
	}
	@Test
	public void selectReviewInfo() throws Exception {
		jmReviewService.selectReviewInfo(393);
	}
	@Test
	public void selectReviewInfoImage() throws Exception {
		jmReviewService.selectReviewInfoImage(393);
	}
	@Test
	public void selectReviewInfoImageDao() throws Exception {
		jmReviewDao.selectReviewInfoImage(393);
	}
}
