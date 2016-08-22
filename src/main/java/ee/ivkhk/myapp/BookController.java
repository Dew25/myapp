/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ivkhk.myapp;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jvm
 */
@Named
@RequestScoped
public class BookController {
    @Inject
    private BookEJB bookEJB;
    private Book book = new Book();
    
    public String doCreateBook(){
        bookEJB.createBook(book);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Book created","Книга"+book.getTitle()+" была создана с id="+ book.getId()));
        return "newBook.xhtml";
    }
    public void doFindBookById(){
        book = bookEJB.findBookById(book.getId());
    }
}
