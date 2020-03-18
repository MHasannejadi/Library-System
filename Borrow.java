import java.util.*;
import java.text.*;
import java.time.*;

/**
 * The Borrow class handle a range of tasks for our program such as 
 * saving information of a borrow and getter and setter methods.
 * 
 * @author Mohamad hasannejadi
 * @version 1.0 
 * @since 2020-3-12
 * 
 */

public class Borrow{

    private User borrower;
    private Book book;
    private Date issuedDate;
    private Date deadlineDate;
    
    /**
    * this constructor is used to assign a borrow object.

    * @param borrower borrower
    * @param book borrower
    * @param deadlineDate deadline
    */

    public Borrow(User borrower, Book book, Date deadlineDate){
        
        this.borrower = borrower;
        this.book = book;
        this.deadlineDate = deadlineDate;
        this.issuedDate = new Date();
        
    }
    
    /**
     * setter for book
     * @param book book
     */

    public void setBook(Book book){
        this.book = book;
    }
   
    /**
     * getter method for book
     * @return book
     */

    public Book getBookFromBorrow(){
    return book;
    }

    /**
     * setter for borrower
     * @param borrower borrower
     */

    public void setBorrower(User borrower){
        this.borrower = borrower;
    }

    /**
     * getter method for borrower
     * @return borrower user
     */

    public User getUserFromBorrow(){
        return borrower;
    }

    /**
     * setter for deadline
     * @param deadlineDate deadline
     */

    
     public void setDeadline(Date deadlineDate){
        this.deadlineDate = deadlineDate;
    }


    /**
     * getter method for deadline 
     * @return deadline 
     */

    public Date getDeadline(){
        return deadlineDate;
    }

    
    /**
     * print method is used to print all information of borrow 
     */

    public void print(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH aa"); 
    
        String issuedDatePrint = sdf.format(issuedDate);
        String deadlineDatePrint = sdf.format(deadlineDate);
        System.out.println("Borrower => Full Name: "+borrower.getFirstNameUser()+" "+borrower.getLastNameUser()+" | ID: "+borrower.getIdUser());
        System.out.println("Book => Title: "+book.getNameBook()+" | Author: "+book.getAuthor());
        System.out.println("IssuedDate => "+issuedDatePrint);
        System.out.println("Deadline => "+deadlineDatePrint);
        long remainingTime = deadlineDate.getTime() - issuedDate.getTime();
        if(remainingTime<0){
            System.out.println("Deadline is passed");
            return;
        }
        long hour = (remainingTime/1000/60/60)%24+2;
        LocalDate issued = issuedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate deadline = deadlineDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period diff = Period.between(issued,deadline);
        
        System.out.println("Remaining => "+ diff.getYears()+" year, "+diff.getMonths()+" month, "+diff.getDays()+" day, "+hour+" hours remained.");
    

    }

}