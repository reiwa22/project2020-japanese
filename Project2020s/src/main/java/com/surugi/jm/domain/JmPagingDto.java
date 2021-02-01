package com.surugi.jm.domain;

public class JmPagingDto {
	
	
	private int page = 1;        	//ページ数
	private int perPage = 10; 	//1ページの中から出てくる掲示物数のスタート行
	private int startRow = 1;  	//ページの最初の番号
	private int endRow = 10; 	//ページの最後の番号
	private String searchType; 
	private String keyword;
	private int totalCount;     //掲示物の数
	private int totalPage;	      //総ページ数
	private int startPage;		  //スタートページ
	private int endPage;      //最後のページ
	private final int PAGE_BLOAK =10;
	
	
	
	public void setPageInfo() {
		this.endRow = page*perPage;
		this.startRow = this.endRow - this.perPage+1;
		
		this.endPage = (int)Math.ceil((double)page/PAGE_BLOAK)*PAGE_BLOAK;
		this.startPage = this.endPage - PAGE_BLOAK +1; 		
	}

	public JmPagingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		//総ページ
		this.totalPage=(int)Math.ceil((double)totalCount/perPage);
		
		if(endPage>totalPage) {
			endPage=totalPage;
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPAGE_BLOAK() {
		return PAGE_BLOAK;
	}

	@Override
	public String toString() {
		return "JmPagingDto [page=" + page + ", perPage=" + perPage + ", startRow=" + startRow + ", endRow=" + endRow
				+ ", searchType=" + searchType + ", keyword=" + keyword + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", startPage=" + startPage + ", endPage=" + endPage + ", PAGE_BLOAK=" + PAGE_BLOAK + "]";
	}

	



	
	
	
	
	
	
	
	
	
	
	
	
}
