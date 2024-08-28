package com.kosal.my_upload_video_authority.utilPage;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface PageUtility {
	int DEFAUL_PAGE_LIMIT=3;
	int DEFAULT_PAGE_NUM=1;
	String PAGE_LIMIT="_limit";
	String PAGE_NUM="_page";
	static Pageable pageable(int pageNumber,int pageSize) {
		if(pageNumber<DEFAULT_PAGE_NUM) {
			pageNumber=DEFAULT_PAGE_NUM;
		}
		if(pageSize<1) {
			pageSize=DEFAUL_PAGE_LIMIT;
		}
		Pageable pageable=PageRequest.of(pageNumber-1, pageSize);
		return pageable;
		
	}

}
