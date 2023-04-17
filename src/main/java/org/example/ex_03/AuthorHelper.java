package org.example.ex_03;

import org.example.ex_03.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Author getAuthorId(long id){
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id);

        session.close();
        return author;
    }

}
