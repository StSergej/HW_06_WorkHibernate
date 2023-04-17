package org.example.ex_03;

import org.example.ex_03.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookHelper {

    private SessionFactory sessionFactory;

    public BookHelper(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Book getBookId(long id){
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);

        session.close();
        return book;
    }

    public Book deletingBookId(long id){
        System.out.println("\nStart of DELETE_BOOK_BY_ID...");
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Book book = session.get(Book.class, id);
        session.delete(book);

        session.getTransaction().commit();
        session.close();

        return book;
    }

    public void deletingBookByAuthor(){
        System.out.println("\nStart of DELETE.....");
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaDelete<Book> criteriaDelete = cb.createCriteriaDelete(Book.class);

        Root<Book> root = criteriaDelete.from(Book.class);

        criteriaDelete.where(cb.equal(root.get("author"), 2));

        Query query = session.createQuery(criteriaDelete);
        int deleted = query.executeUpdate();

        session.getTransaction().commit();
        System.out.println("Deleted lines: " + deleted);
        System.out.println("--------------------------------------");
        session.close();
    }


    public List<Book> getAllBook(){
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Book.class);

        Root<Book> root = cq.from(Book.class);
        cq.select(root);

        Query query = session.createQuery(cq);

        List<Book> bookList = query.getResultList();

        session.close();
        return bookList;

    }
}
