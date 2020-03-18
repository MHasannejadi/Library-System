import java.util.*;
//import java.text.*;
/**
 * TestLibrarySystem class is used to run and test the program and main assign of any object.
 */

public class TestLibrarySystem{

    /**
   * This is the main method which run the program.
   * @param args Unused.
   * @return Nothing.
   * 
   */
    public static void main(String[] args){
        
        Library library1 = new Library("one", "tabriz");
        Library library2 = new Library("two", "tehran");
        LibrarySystem librarySystem1 = new LibrarySystem();
        librarySystem1.addLibrary(library1);
        librarySystem1.addLibrary(library2); 
        User user1 = new User("George", "Clooney", "0000000001");
        User user2 = new User("Brad", "Pitt", "0000000002");
        User user3 = new User("Leonardo", "Dicaprio", "0000000003");
        User user4 = new User("johnny", "Depp", "0000000004");
        User user5 = new User("Morgan", "Freeman" , "0000000005");
        Book book1 = new Book("Romeo", "Shekspier");
        Book book2 = new Book("Atom", "Clear");
        Book book3 = new Book("C program", "Deitel");
        Book book4 = new Book("Magic", "StephenKing");
        Book book5 = new Book("Tom", "McGlass");
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2025);
        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DAY_OF_MONTH, 19);
        calendar.set(Calendar.HOUR_OF_DAY, 16);
        Date date1 = calendar.getTime(); //DEADLINE
        
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DAY_OF_MONTH, 19);
        calendar.set(Calendar.HOUR_OF_DAY, 16);
        Date date2 = calendar.getTime(); //Deadline

        
        library1.addUser(user1);
        library1.addUser(user2);
        library2.addUser(user3);
        library2.addUser(user4);
        library2.addUser(user5);

        library1.addBook(book1);
        library1.addBook(book2);
        library1.addBook(book3);
        library2.addBook(book4);
        library2.addBook(book5);

        library2.borrowBook(book4, user4, date1);
        library1.borrowBook(book3, user1, date1);
        library1.borrowBook(book2, user2, date2);
        
        library1.getBorrows().get(0).print();

        library1.giveBackBook(library1.getBorrows().get(0));

        library1.printPassedDeadlineBorrows();

        library1.removeBook(book2);
    }
}