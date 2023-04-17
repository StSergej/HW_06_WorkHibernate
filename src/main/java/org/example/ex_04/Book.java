package org.example.ex_04;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<AuthorBook> authorBooksById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Collection<AuthorBook> getAuthorBooksById() {
        return authorBooksById;
    }

    public void setAuthorBooksById(Collection<AuthorBook> authorBooksById) {
        this.authorBooksById = authorBooksById;
    }
}
