package com.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "title")
	private String title;
	
	@Column(name = "yearPublic")
	private int yearPublic;
	
	
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name = "idCategory")
	private Category category;
	
	public Book() {
		
	}

	public Book(String title, int yearPublic, Category category) {
		super();
		this.title = title;
		this.yearPublic = yearPublic;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearPublic() {
		return yearPublic;
	}

	public void setYearPublic(int yearPublic) {
		this.yearPublic = yearPublic;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
