import java.util.*;

/**
 * The LibrarySystem class saves a list of libraries and add or remove 
 * library from list of libraries.
 * 
 * @author Mohamad hasannejadi
 * @version 1.0 
 * @since 2020-3-12
 * 
 */

public class LibrarySystem
{

    private ArrayList<Library> libraries = new ArrayList<Library>();


    /**
     * This method is used to add a library from TestLibrarySystem class 
     * to list of libraries.
     * @param libraryToAdd this is the library that we want to add to
     * libraries list.
     * @return nothing
     */

    public void addLibrary(Library libraryToAdd){

        libraries.add(libraryToAdd);

    }

    /**
     * This method is used to remove a library from list of libraries
     * @param libraryToRemove this is the library that we want to remove
     * from libraries list.
     * @return nothing
     */

    public void removeLibrary(Library libraryToRemove){

        Iterator<Library> it = libraries.iterator();
        while(it.hasNext()){
            Library library = it.next();
            if (library.equals(libraryToRemove)){
                it.remove();
            }
        }

    }

    /**
     * This method is used to print list of libraries.
     * @return nothing
     */

    public void printAllLibraries(){
        Iterator<Library> it = libraries.iterator();
        while(it.hasNext()){
            Library library = it.next();
            String name = library.getNameLibrary();
            String address = library.getAddressLibrary();
            System.out.println(name);
            System.out.println(address);
            System.out.println();
        }
    }

}