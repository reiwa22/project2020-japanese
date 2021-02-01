package com.surugi.jm.jm;

import java.util.List;

import com.surugi.jm.domain.JmPagingDto;
import com.surugi.jm.domain.JmReviewVo;

public interface JmReviewDao {
	
	//レビュー掲示板目録照会
	public List<JmReviewVo> selectReviewList()throws Exception;
	
	//レビュー掲示板info照会
	public JmReviewVo selectReviewInfo(int r_info)throws Exception;
	
	//掲示板の書き込み
	public void insertReview(JmReviewVo jmReviewVo)throws Exception;
	
	//レビュー掲示板アップデート
	public void updateReview(JmReviewVo jmReviewVo)throws Exception;
	
	//レビュー掲示板削除機能
	public void deleteReivew(int r_info)throws Exception;
	
	//リストページング
	public List<JmReviewVo>selectPaging(JmPagingDto jmPagingDto)throws Exception;
	
	//投稿数の照会
	public int selectCount(JmPagingDto jmPagingDto)throws Exception;
	
	//投稿の閲覧数増加
	public void updateViewCount(int r_info)throws Exception;
	
	//レビュー掲示板シーケンス
	public int getNextVal()throws Exception;
	
	//レビュー掲示板のイメージシーケンス
	public void insertReviewAttach(String r_files,int r_filesinfo)throws Exception;
	
	//レビュー掲示板info -写真を読み込む
	public List<String>selectReviewInfoImage(int r_filesinfo)throws Exception;

}
