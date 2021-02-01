package com.surugi.jm.jm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.surugi.jm.domain.JmPagingDto;
import com.surugi.jm.domain.JmReviewVo;

@Repository
public class JmReviewDaoImpl implements JmReviewDao {

	public static final String NAMESPACE ="mappers.review-mapper.";
	
	@Inject
	private SqlSession sqlSession;
	
	//レビュー掲示板目録照会
	@Override
	public List<JmReviewVo> selectReviewList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"selectReviewList");
	}
	
	//レビュー掲示板info照会
	@Override
	public JmReviewVo selectReviewInfo(int r_info) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"selectReviewInfo",r_info);
	}

	//掲示板の書き込み
	@Override
	public void insertReview(JmReviewVo jmReviewVo) throws Exception {
		if(jmReviewVo.getR_files() !=null && jmReviewVo.getR_files()[0] !=null) {
			jmReviewVo.setR_file(jmReviewVo.getR_files()[0]);
		}
		sqlSession.insert(NAMESPACE+"insertReview",jmReviewVo);
	}

	//レビュー掲示板アップデート
	@Override
	public void updateReview(JmReviewVo jmReviewVo) throws Exception {
		
		String[] r_files = jmReviewVo.getR_files();
		if(r_files != null && !r_files[0].equals("")) {
			String r_file = r_files[0];
			jmReviewVo.setR_file(r_file);
		
		}
		System.out.println("jmReviewVo::::::::update"+jmReviewVo);	
		sqlSession.update(NAMESPACE+"updateReview",jmReviewVo);

	}

	//レビュー掲示板削除機能
	@Override
	public void deleteReivew(int r_info) throws Exception {
		sqlSession.delete(NAMESPACE+"deleteReview",r_info);

	}

	//リストページング
	@Override
	public List<JmReviewVo> selectPaging(JmPagingDto jmPagingDto) throws Exception {
		List<JmReviewVo>list = sqlSession.selectList(NAMESPACE+"selectPaging",jmPagingDto);
		
		return list;
	}
	
	//投稿数の照会
	@Override
	public int selectCount(JmPagingDto jmPagingDto) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"selectCount",jmPagingDto);
	}
	//投稿の閲覧数増加
	@Override
	public void updateViewCount(int r_info) throws Exception {
		sqlSession.selectOne(NAMESPACE+"updateViewCount",r_info);

	}

	//レビュー掲示板シーケンス
	@Override
	public int getNextVal() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getNextVal");
	}

	//レビュー掲示板のイメージシーケンス
	@Override
	public void insertReviewAttach(String r_files, int r_filesinfo) throws Exception {
		Map<String, Object> pramMap = new HashMap<>();
		pramMap.put("r_files", r_files);
		pramMap.put("r_filesinfo", r_filesinfo);
		sqlSession.insert(NAMESPACE+"insertReviewAttach",pramMap);

	}

	//レビュー掲示板info -写真
	@Override
	public List<String> selectReviewInfoImage(int r_filesinfo) throws Exception {
		List<String> list = sqlSession.selectList(NAMESPACE+"selectReviewInfoImage",r_filesinfo);
		return list;
	}

	

}
