package com.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springmvc.entity.Book;

@Service
@Repository
public class BookService {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Book> getBooks() {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book ORDER BY title", Book.class);
		List<Book> listBook = theQuery.getResultList();
		return listBook;
	}

	@Transactional
	public void saveBook(Book theBook) {
		Session cunrrentSession = sessionFactory.getCurrentSession();
		cunrrentSession.saveOrUpdate(theBook);
	}
	
	@Transactional
	public Book getBook(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Book theBook = currentSession.get(Book.class,theId);
		return theBook;
	}
	
	@Transactional
	public void deleteBook(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
			  currentSession.createQuery("delete from Book where id=:bookId");
		theQuery.setParameter("bookId", theId);
		
		theQuery.executeUpdate();
		
	}
	
	
	@Transactional
	public List<Book> searchBooks(String theSearchName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            theQuery =currentSession.createQuery("from Book where lower(title) like :search", Book.class);
            theQuery.setParameter("search", "%" + theSearchName.toLowerCase() + "%");
        }
        else {
            theQuery =currentSession.createQuery("from Book", Book.class);            
        }
        
        List<Book> books = theQuery.getResultList();
                
        return books;

	}
	
	

}
