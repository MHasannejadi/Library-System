
/**
 * The User class is used to save information of a user of library.
 * 
 * @author Mohamad hasannejadi
 * @version 1.0 
 * @since 2020-3-12
 */

public class User{

    private String firstName;
    private String lastName;
    private String idNum;

    /**
     * this constructor is used to assign first name and last name and 
     * id nember of user
     * @param firstName first name of user 
     * @param lastName last name of user 
     * @param idNum id number of user
     */

    public User(String firstName, String lastName, String idNum){
        this.firstName = firstName;
        this.lastName = lastName;
        if(idNum.length() !=10){
            System.out.println("Id number must be 10 digits. Please try again");
        }
        else{
            this.idNum = idNum;
        }    
    }

    /**
     * getter method of firstname
     * @return first name of user
     */
    
    public String getFirstNameUser(){
        return firstName;
    }

    /**
     * getter method of lastname
     * @return last name of user
     */

    public String getLastNameUser(){
        return lastName;
    }

    /**
     * getter method of idnumber
     * @return id number of user
     */

    public String getIdUser(){
        return idNum;
    }

    /**
     * this method prints all information of user.
     * @param user user
     */
    public void print(User user){
        System.out.printf("Full Name: %s %s| ID: %s",user.firstName,user.lastName,user.idNum);
        System.out.println();
    }

    /**
     * this method checks equality of two users.
     * @param user1 a user
     * @param user2 another user
     */

    public boolean checkEqualityUser(User user1, User user2){
        if(user1.idNum.equals(user2.idNum)){
            return true;
        }
        else{
            return false;
        }
    }

}