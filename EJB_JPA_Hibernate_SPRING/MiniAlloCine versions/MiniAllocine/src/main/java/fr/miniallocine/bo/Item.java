package fr.miniallocine.bo;

import java.time.LocalDate;

public class Item {
	
	private int id;
	private String title;
	private String category;
	private String type;
	private String description;
	private LocalDate date;
	
	public Item() { }

	public Item(int id, String title, String category,String  type, String description, LocalDate date) {
		this.setId(id);
		this.setTitle(title);
		this.setCategory(category);
		this.setDescription(description);
		this.setDate(date);
		this.setType(type);
	}

	public Item(String title, String category,String type,  String description, LocalDate date) {
		this.setTitle(title);
		this.setCategory(category);
		this.setDescription(description);
		this.setDate(date);
		this.setType(type);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", category=" + category + ", description=" + description
				+ ", date=" + date + "]";
	}
	
	
	
}
