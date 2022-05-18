package PruralRestAssured.SerializationAndDeserialization;

import java.util.List;

public class FullJson {
	
	private int page;
	
	private int per_page;
	
	private int total;
	
	private int total_pages;
	
	private Support support;
	
	private List<Data> data;

	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public Support getSupport() {
		return support;
	}

	public void setSupoort(Support support) {
		this.support = support;
	}

	@Override
	public String toString() {
		return "FullJson [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages=" + total_pages
				+ ", support=" + support + ", data=" + data + ", getPage()=" + getPage() + ", getPer_page()="
				+ getPer_page() + ", getTotal()=" + getTotal() + ", getTotal_pages()=" + getTotal_pages()
				+ ", getSupoort()=" + getSupport() + ", getData()=" + getData() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

}
