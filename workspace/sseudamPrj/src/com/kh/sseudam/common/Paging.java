package com.kh.sseudam.common;

public class Paging {
	
	public static PageVo paging(int listCount, int currentPage, int pageLimit, int boardLimit) {
		

		int maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		int startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		
		int endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
//		System.out.println("listCount"+listCount);
//		System.out.println(currentPage);
//		System.out.println(pageLimit);
//		System.out.println(boardLimit);
//		System.out.println(startPage);
//		System.out.println(endPage);
//		System.out.println(maxPage);

		PageVo pv = new PageVo();
		pv.setListCount(listCount);
		pv.setCurrentPage(currentPage);
		pv.setPageLimit(pageLimit);
		pv.setBoardLimit(boardLimit);
		pv.setMaxPage(maxPage);
		pv.setStartPage(startPage);
		pv.setEndPage(endPage);
		
		return pv;
	}

}
