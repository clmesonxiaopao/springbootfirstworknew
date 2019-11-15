package shawn.springexample.firstwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xjiao on 11/14/19.
 */

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastName;

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();

	public Author(String firstname, String lastName, Set<Book> books) {
		this.firstname = firstname;
		this.lastName = lastName;
		this.books = books;
	}

	public Author(String firstname, String lastName) {
		this.firstname = firstname;
		this.lastName = lastName;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Author))
			return false;

		Author author = (Author) o;

		return getId().equals(author.getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}

	@Override public String toString() {
		return "Author{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastName='" + lastName + '\'' +
				", books=" + books +
				'}';
	}
}
