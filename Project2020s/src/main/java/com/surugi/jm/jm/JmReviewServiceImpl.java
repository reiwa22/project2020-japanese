package com.surugi.jm.jm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.surugi.jm.domain.JmPagingDto;
import com.surugi.jm.domain.JmReviewVo;

@Service
public class JmReviewServiceImpl implements JmReviewService {

	@Inject
	private JmReviewDao jmReviewDao;
	
	//レビュー掲示板目録照会
	@Override
	public List<JmReviewVo> selectReviewList() throws Exception {
		List<JmReviewVo> list = jmReviewDao.selectReviewList();
		return list;
	}
	
	//レビュー掲示板info照会
	@Override
	public JmReviewVo selectReviewInfo(int r_info) throws Exception {
		JmReviewVo jmReviewVo = jmReviewDao.selectReviewInfo(r_info);
		jmReviewDao.updateViewCount(r_info);
		
		return jmReviewVo;
	}

	//掲示板の書き込み
	@Override
	public void insertReview(JmReviewVo jmReviewVo) throws Exception {
		int r_info = jmReviewDao.getNextVal();
		jmReviewVo.setR_info(r_info);
		jmReviewDao.insertReview(jmReviewVo);
		
		//attach - insert
		String[] files = jmReviewVo.getR_files();
		for(String file : files) {
			System.out.println("jmReviewVo::insertReview"+jmReviewVo);
			jmReviewDao.insertReviewAttach(file, r_info);
		}
	}

	//レビュー掲示板アップデート
	@Override
	public void updateReview(JmReviewVo jmReviewVo) throws Exception {
		int r_info = jmReviewVo.getR_info();
		jmReviewDao.updateReview(jmReviewVo);
		String[] files = jmReviewVo.getR_files();
		for(String file: files) {
			jmReviewDao.insertReviewAttach(file, r_info);
		}

	}
	
	//レビュー掲示板削除機能
	@Override
	public void deleteReivew(int r_info) throws Exception {
		jmReviewDao.deleteReivew(r_info);

	}
	
	//リストページング
	@Override
	public List<JmReviewVo> selectPaging(JmPagingDto jmPagingDto) throws Exception {
		List<JmReviewVo> list = jmReviewDao.selectPaging(jmPagingDto);
		return list;
	}
	
	//投稿数の照会
	@Override
	public int selectCount(JmPagingDto jmPagingDto) throws Exception {
		
		return jmReviewDao.selectCount(jmPagingDto);
	}

	//レビュー掲示板info -写真
	@Override
	public List<String> selectReviewInfoImage(int r_filesinfo) throws Exception {
		
		return jmReviewDao.selectReviewInfoImage(r_filesinfo);
	}

}
