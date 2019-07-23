package com.museum.domain;

import java.util.List;

public class Page {
	private int p;//��ǰҳ��
	private int rowCount;//������
	private int maxPage;//��ҳ��
	private int prev;//��һҳ
	private int next;//��һҳ
	private int startPage;//��ʼҳ
	private int endPage;//����ҳ
	private int startLine;//��ʼ��
	private int size;//ÿҳ����
	private List list;//��ҳ����
	
	public Page(int p_,int rowCount_,int size_){
		p = p_;
		rowCount = rowCount_;
		size = size_;
		
		
		maxPage = (int) Math.ceil(rowCount*1.0 / size);
		
		
		if(p > maxPage)p = maxPage;
		if(p<1)p = 1;
		
		prev = p - 1;
		next = p + 1;
		
		startLine = (p - 1) * size;
		
	}
	
	
	
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
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
	public int getStartLine() {
		return startLine;
	}
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [list=" + list + "]";
	}
	
	
}
