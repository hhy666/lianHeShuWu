package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private String bookId;
    private String name;
    private String author;
    private String cover;
    private String press;
    private Date pressDate;
    private String edition; 
    private Date printDate;
    private String impression;
    private String isbn;
    private Integer wordNum; 
    private Integer pageNum;
    private String sizes;
    private String paper;
    private String pack;
    private Double price;
    private Double dprice;
    private Date createDate;
    private String editorRecomment;
    private String contentAbstract;
    private String authorAbstract;
    private String director;
    private String mediaCommentary;
    private Integer ale;
    private Integer stock;
    private String categoryId;
	
	public Book() {
		super();
	}
	public Book(String bookId, String name, String author, String cover,
			String press, Date pressDate, String edition, Date printDate,
			String impression, String isbn, Integer wordNum, Integer pageNum,
			String sizes, String paper, String pack, Double price,
			Double dprice, Date createDate, String editorRecomment,
			String contentAbstract, String authorAbstract, String director,
			String mediaCommentary, Integer ale, Integer stock,
			String categoryId) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.cover = cover;
		this.press = press;
		this.pressDate = pressDate;
		this.edition = edition;
		this.printDate = printDate;
		this.impression = impression;
		this.isbn = isbn;
		this.wordNum = wordNum;
		this.pageNum = pageNum;
		this.sizes = sizes;
		this.paper = paper;
		this.pack = pack;
		this.price = price;
		this.dprice = dprice;
		this.createDate = createDate;
		this.editorRecomment = editorRecomment;
		this.contentAbstract = contentAbstract;
		this.authorAbstract = authorAbstract;
		this.director = director;
		this.mediaCommentary = mediaCommentary;
		this.ale = ale;
		this.stock = stock;
		this.categoryId = categoryId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPressDate() {
		return pressDate;
	}
	public void setPressDate(Date pressDate) {
		this.pressDate = pressDate;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Date getPrintDate() {
		return printDate;
	}
	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getWordNum() {
		return wordNum;
	}
	public void setWordNum(Integer wordNum) {
		this.wordNum = wordNum;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public String getSizes() {
		return sizes;
	}
	public void setSizes(String sizes) {
		this.sizes = sizes;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDprice() {
		return dprice;
	}
	public void setDprice(Double dprice) {
		this.dprice = dprice;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getEditorRecomment() {
		return editorRecomment;
	}
	public void setEditorRecomment(String editorRecomment) {
		this.editorRecomment = editorRecomment;
	}
	public String getContentAbstract() {
		return contentAbstract;
	}
	public void setContentAbstract(String contentAbstract) {
		this.contentAbstract = contentAbstract;
	}
	public String getAuthorAbstract() {
		return authorAbstract;
	}
	public void setAuthorAbstract(String authorAbstract) {
		this.authorAbstract = authorAbstract;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMediaCommentary() {
		return mediaCommentary;
	}
	public void setMediaCommentary(String mediaCommentary) {
		this.mediaCommentary = mediaCommentary;
	}
	public Integer getAle() {
		return ale;
	}
	public void setAle(Integer ale) {
		this.ale = ale;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", author="
				+ author + ", cover=" + cover + ", press=" + press
				+ ", pressDate=" + pressDate + ", edition=" + edition
				+ ", printDate=" + printDate + ", impression=" + impression
				+ ", isbn=" + isbn + ", wordNum=" + wordNum + ", pageNum="
				+ pageNum + ", sizes=" + sizes + ", paper=" + paper + ", pack="
				+ pack + ", price=" + price + ", dprice=" + dprice
				+ ", createDate=" + createDate + ", editorRecomment="
				+ editorRecomment + ", contentAbstract=" + contentAbstract
				+ ", authorAbstract=" + authorAbstract + ", director="
				+ director + ", mediaCommentary=" + mediaCommentary + ", ale="
				+ ale + ", stock=" + stock + ", categoryId=" + categoryId + "]";
	}
}
