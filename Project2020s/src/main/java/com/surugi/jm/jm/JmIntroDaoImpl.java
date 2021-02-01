package com.surugi.jm.jm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.surugi.jm.domain.JmIntroVo;
import com.surugi.jm.domain.JmPagingDto;

@Repository
public class JmIntroDaoImpl implements JmIntroDao {

	public static final String NAMESPACE = "mappers.intro-mapper.";
	
	@Inject
	private SqlSession sqlSession;
	
	//紹介掲示板目録照会
	@Override
	public List<JmIntroVo> selectIntroList() throws Exception {	
		return sqlSession.selectList(NAMESPACE+"selectIntroList");
	}

	//紹介掲示板info照会
	@Override
	public JmIntroVo selectIntroInfo(int i_info) throws Exception {	
		return sqlSession.selectOne(NAMESPACE+"selectIntroInfo",i_info);
	}

	//掲示板の書き込み
	@Override
	public void insertIntro(JmIntroVo jmIntroVo) throws Exception {
		if(jmIntroVo.getI_files() !=null && jmIntroVo.getI_files()[0] !=null) {
			jmIntroVo.setI_file(jmIntroVo.getI_files()[0]);
		}
		sqlSession.insert(NAMESPACE+"insertIntro",jmIntroVo);
	}

	//紹介掲示板アップデート
	@Override
	public void updateIntro(JmIntroVo jmIntroVo) throws Exception {
		String[] i_files = jmIntroVo.getI_files();
		if(i_files !=null && !i_files[0].equals("")) {
			String i_file = i_files[0];
			jmIntroVo.setI_file(i_file);
		}
		sqlSession.update(NAMESPACE+"updateIntro",jmIntroVo);
	}

	//紹介掲示板削除機能
	@Override
	public void deleteIntro(int i_info) throws Exception {
		sqlSession.delete(NAMESPACE+"deleteIntro",i_info);

	}

	//リストページング
	@Override
	public List<JmIntroVo> selectPaging(JmPagingDto jmPagingDto) throws Exception {
		List<JmIntroVo>list = sqlSession.selectList(NAMESPACE+"selectPaging",jmPagingDto);
		return list;
	}

	//投稿数の照会
	@Override
	public int selectCount(JmPagingDto jmPagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"selectCount",jmPagingDto);
	}

	//投稿の閲覧数増加
	@Override
	public void updateViewCount(int i_info) throws Exception {
		sqlSession.selectOne(NAMESPACE+"updateViewCount",i_info);

	}

	//紹介掲示板シーケンス
	@Override
	public int getNextVal() throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getNextVal");
	}

	//紹介掲示板のイメージシーケンス
	@Override
	public void insertIntroAttach(String i_files, int i_filesinfo) throws Exception {
		Map<String, Object> pramMap = new HashMap<>();
		pramMap.put("i_files", i_files);
		pramMap.put("i_filesinfo", i_filesinfo);
		sqlSession.insert(NAMESPACE+"insertIntroAttach",pramMap);

	}

	//紹介掲示板info -写真を読み込む
	@Override
	public List<String> selectIntroInfoImage(int i_filesinfo) throws Exception {
		List<String> list = sqlSession.selectList(NAMESPACE+"selectIntroInfoImage",i_filesinfo);
		return list;
	}

}
