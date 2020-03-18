import java.util.*;

/**
 * The Library class handle a range of tasks for our program such as 
 * saving list of books and users and borrows and add users and books
 * and borrows to list and remove those
 * 
 * @author Mohamad hasannejadi
 * @version 1.0 
 * @since 2020-3-12
 * 
 */


public class Library{

    private ArrayList<Book> books = new ArrayList<Book>();  
    private ArrayList<Book> restBooks = new ArrayList<Book>();  
    private ArrayList<User> users = new ArrayList<User>();  
    private ArrayList<Borrow> borrows = new ArrayList<Borrow>();
    private String name;
    private String address;

    /**
     * This constructor is used to assign name and address of library TestLibrarySystem class 
     * to list of libraries.
     * @param name this is the name of library.
     * @param address this is the address of library.
     */
    
    public Library(String name, String address){
        this.name = name;
        this.address = address;
    }

    /**
     * this method is getter of linbrary name.
     * @return name of library
     */

    public String getNameLibrary(){
        return name;
    }

    /**
     * this method is getter of linbrary address.
     * @return address of library
     */

    public String getAddressLibrary(){
        return address;
    }

    /**
     * this method is getter of borrows
     * @return list of borrows
     */

    public ArrayList<Borrow> getBorrows(){
        return borrows;
    }

    /**
     * This method is used to add a user from TestLibrarySystem class 
     * to list of users.
     * @param userToAdd this is the user that we want to add to
     * users list.
     * @return nothing
     */

    public void addUser(User userToAdd){
        
        int counter = 0;
        Iterator<User> it = users.iterator();
        while(it.hasNext()){
            User user = it.next();
            if (user.equals(userToAdd)){
                System.out.println("this user is already existing");
                counter++;
                break;
            }
        }
        if(counter == 0){
        users.add(userToAdd);
        }
    }

    /**
     * This method is used to add a book from TestLibrarySystem class 
     * to list of books.
     * @param bookToAdd this is the book that we want to add to
     * books list.
     * @return nothing
     */

    public void addBook(Book bookToAdd){
        int counter = 0;
        Iterator<Book> it = books.iterator(); // // / // / // doubtdul books or restbooks
        while(it.hasNext()){
            Book book = it.next();
            if (book.equals(bookToAdd)){
                System.out.println("this book is already existing");
                counter++;
                break;
            }
        }
        if(counter == 0){
        books.add(bookToAdd);
        restBooks.add(bookToAdd);
        }

    }

    /**
     * This method is used to remove a user from list of users.
     * @param userToRemove this is the user that we want to remove
     * from users list.
     * @return nothing
     */

    public void removeUser(User userToRemove){
        
        int counter = 0;
        Iterator<Borrow> it1 = borrows.iterator();
        while(it1.hasNext()){
            Borrow borrow = it1.next();
            if(borrow.getUserFromBorrow().equals(userToRemove)){
                System.out.println("Can not remove this user because he is a borrower");    
                counter++;
                break;
            }
        }

        if(counter == 0){
            Iterator<User> it2 = users.iterator();
            while(it2.hasNext()){
                User user = it2.next();
                if (user.equals(userToRemove)){
                    it2.remove();
                    break;
                }
            }
        }

    }

    /**
     * This method is used to remove a book from list of books.
     * @param bookToRemove this is the book that we want to remove
     * from books list.
     * @return nothing
     */


    public void removeBook(Book bookToRemove){

        int counter = 0;

        Iterator<Book> it1 = books.iterator();
        while(it1.hasNext()){
            Book book = it1.next();
            if(book.equals(bookToRemove)){
                counter = 0;
                break;
            }
            else{

                counter++;

            }

        }
        if(counter != 0){
            System.out.println("Can not remove this book because it is not existing");
            return;
        }

        Iterator<Borrow> it2 = borrows.iterator();
        while(it2.hasNext()){
            Borrow borrow = it2.next();
            Book book = borrow.getBookFromBorrow();
            if(bookToRemove.equals(book)){
                System.out.println("Can not remove this book because it is borrowed");
                return;
            }

        }
        
        Iterator<Book> it3 = restBooks.iterator();
        while(it3.hasNext()){
            Book book = it3.next();
            if (book.equals(bookToRemove)){
                it3.remove();
            }
        }
     
    }

    /**
     * This method is used to create a new borrow and add it to list of 
     * borrows when everything is going well.
     * @param bookToBorrow this is the book that we want to borrow.
     * @param borrower this is user that borrows a book.
     * @param deadline this is the deadline date of borrow.
     * @return nothing
     */
        
    public void borrowBook(Book bookToBorrow, User borrower, Date deadline){

        int tmp = 0;
        Iterator<Book> it1 = restBooks.iterator();
        while(it1.hasNext()){
            Book book = it1.next();
            
            if(book.equals(bookToBorrow)){  
               
                it1.remove();                     
                tmp++;
                break;
            }

        }
        Iterator<User> it2 = users.iterator();
        while(it2.hasNext()){
            User user = it2.next();
            if(user.equals(borrower)){                     
                tmp+=2;
                break;
            }

        }

        if(tmp == 3){
            Borrow borrow = new Borrow(borrower, bookToBorrow, deadline);
            borrows.add(borrow);System.out.println();
        }
        else if(tmp == 1){
            System.out.println("this user is not available!");
        }
        else{
            System.out.println("this book is not available!");
        }


        
    
    }


    /**
     * this method used to check a borrow that is givenback and 
     * if every thing is going well remove that borrow.
     * @param borrow this is the borrow that we want to giveback 
     * to library.
     * @return nothing
     */

    public void giveBackBook(Borrow borrow){
        Iterator<Borrow> it = borrows.iterator();
       
        while(it.hasNext()){
            Borrow borrow1 = it.next();
            if(borrow.equals(borrow1)){
                restBooks.add(borrow.getBookFromBorrow());
                it.remove();
            
                return;
            } 
        }
    
        System.out.println("your giveback is incorrect");

    }

    /**
     * This method is used to print list of borrows that is passed 
     * their deadline.
     * @return nothing
     */

    public void printPassedDeadlineBorrows(){
        Iterator<Borrow> it = borrows.iterator();
        while(it.hasNext()){
            Borrow borrow = it.next();
            Date now = new Date();
            if(now.after(borrow.getDeadline())){   
                borrow.print();
            }
        }
    }

}
