package com.surugi.jm.jm;

import java.util.List;

import com.surugi.jm.domain.JmIntroVo;
import com.surugi.jm.domain.JmPagingDto;

public interface JmIntroDao {

	//紹介掲示板目録照会
	public List<JmIntroVo> selectIntroList()throws Exception;
	
	//紹介掲示板info照会
	public JmIntroVo selectIntroInfo(int i_info)throws Exception;
	
	//掲示板の書き込み
	public void insertIntro(JmIntroVo jmIntroVo)throws Exception;
	
	//紹介掲示板アップデート
	public void updateIntro(JmIntroVo jmIntroVo)throws Exception;
	
	//紹介掲示板削除機能
	public void deleteIntro(int i_info)throws Exception;
	
	//リストページング
	public List<JmIntroVo>selectPaging(JmPagingDto jmPagingDto)throws Exception;
	
	//投稿数の照会
	public int selectCount(JmPagingDto jmPagingDto)throws Exception;
	
	//投稿の閲覧数増加
	public void updateViewCount(int i_info)throws Exception;
	
	//紹介掲示板シーケンス
	public int getNextVal()throws Exception;
	
	//紹介掲示板のイメージシーケンス
	public void insertIntroAttach(String i_files,int i_filesinfo)throws Exception;
	
	//紹介掲示板info -写真を読み込む
	public List<String>selectIntroInfoImage(int i_filesinfo)throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
