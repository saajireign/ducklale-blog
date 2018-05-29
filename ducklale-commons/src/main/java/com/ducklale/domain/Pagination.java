package com.ducklale.domain;

import java.util.List;

public  class Pagination<T> {

		private static final int DEFAULT_PAGE_SIZE = 20;

		private List<T> records;

		private int pageNo = 1;

		private int pageSize = DEFAULT_PAGE_SIZE;

		private long totalPages;





	public Pagination(){
			
		}
		public <O> Pagination(Pagination<O> p){
			this.totalPages = p.totalPages;
			this.pageNo = p.pageNo;
			this.pageSize = p.pageSize;
		}
		public List<T> getRecords() {
			return records;
		}

		public void setRecords(List<T> records) {
			this.records = records;
		}

		public int getPageNo() {
			return pageNo;
		}

		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public long getTotalPages() {
			if (totalPages < 0) {
				return -1;
			}

			long count = totalPages / pageSize;
			if (totalPages % pageSize > 0) {
				count++;
			}
			return count;
		}

		public void setTotalPages(long totalPages) {
			this.totalPages = totalPages;
		}

		public boolean hasNext() {
			return (pageNo + 1 <= this.getTotalPages());
		}

		public boolean hasPrev() {
			return (pageNo - 1 >= 1);
		}

		public int getNextPage() {
			if (hasNext()) {
				return pageNo + 1;
			} else {
				return pageNo;
			}
		}

		public int getPrevPage() {
			if (hasPrev()) {
				return pageNo - 1;
			} else {
				return pageNo;
			}
		}

	}