
/**
 * The User class is used to save information of a book of library.
 * 
 * @author Mohamad hasannejadi
 * @version 1.0 
 * @since 2020-3-12
 * 
 */

public class Book{
    
    private String title;
    private String author;

    /**
     * this constructor is used to assign title and author of book.
     * @param title book title
     * @param author book author
     */

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    /**
     * getter method of bookname
     * @return name of book
     */
    
    public String getNameBook(){
        return title;
    }

    /**
     * getter method of bookauthor
     * @return author of book
     */

    public String getAuthor(){
        return author;
    }
    
    /**
     * this method prints all information of book.
     * @param book book
     */

    public void print(Book book){
        System.out.printf("Title: %s| Author: %s",book.title,book.author);
        System.out.println();
    }

    /**
     * this method checks equality of two users.
     * @param book1 a book
     * @param book2 another book
     */

    public boolean checkEqualityBook(Book book1, Book book2){
        
        if((book1.title.equals(book2.title))&&(book1.author.equals(book2.author))){
            return true;
        }
        else
        {
            return false;
        }

    }

    

}