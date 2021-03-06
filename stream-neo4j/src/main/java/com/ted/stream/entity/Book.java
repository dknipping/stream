package com.ted.stream.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@NodeEntity
public class Book implements Serializable {
	
	private static final long serialVersionUID = 8257147750897767747L;

	@GraphId
	private Long id;
	private String title;
	private String subtitle;
	private Set<String> authors = new HashSet<>();
	private String isbn;
	
	@RelatedTo(type="CATEGORIES", direction = Direction.BOTH)
	private @Fetch Set<Category> categories = new HashSet<>();
	
	public Book() {
	}
	
	public Book(String title, String isbn) {
		this.title = title;
		this.isbn = isbn;
		this.subtitle = "";
		this.authors = new HashSet<String>();
		this.categories = new HashSet<Category>();
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSubtitle() {
		return subtitle;
	}
	
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	
	public Set<String> getAuthors() {
		return authors;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result
				+ ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result
				+ ((subtitle == null) ? 0 : subtitle.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null) {
				return false;
			}
		} else if (!authors.equals(other.authors)) {
			return false;
		}
		if (categories == null) {
			if (other.categories != null) {
				return false;
			}
		} else if (!categories.equals(other.categories)) {
			return false;
		}
		if (isbn == null) {
			if (other.isbn != null) {
				return false;
			}
		} else if (!isbn.equals(other.isbn)) {
			return false;
		}
		if (subtitle == null) {
			if (other.subtitle != null) {
				return false;
			}
		} else if (!subtitle.equals(other.subtitle)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [");
		if (title != null) {
			builder.append("title=");
			builder.append(title);
			builder.append(", ");
		}
		if (subtitle != null) {
			builder.append("subtitle=");
			builder.append(subtitle);
			builder.append(", ");
		}
		if (authors != null) {
			builder.append("authors=");
			builder.append(authors);
			builder.append(", ");
		}
		if (isbn != null) {
			builder.append("isbn=");
			builder.append(isbn);
			builder.append(", ");
		}
		if (categories != null) {
			builder.append("category=");
			builder.append(categories);
		}
		builder.append("]");
		return builder.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
