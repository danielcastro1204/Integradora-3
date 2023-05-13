package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller{

    private ArrayList <BibliographicProduct> bibliographicProducts;
    private ArrayList <User> users;
    private ArrayList <Transaction> transactions;
    public Controller(){

        bibliographicProducts = new ArrayList <BibliographicProduct>();
        users = new ArrayList <User>();
        transactions = new ArrayList <Transaction>();
    }

    /**
     * Description: This method calls the constructors of the objects with default values and saves them to the system
     */

    public void testCases(){

        bibliographicProducts.add(new Book("A29", "Harry Potter and the Philosopher's Stone", 223, new GregorianCalendar(1997, 5, 26), "www.readx.com/book/HarryPotter1", "Primer libro de la serie literaria Harry Potter", Genre.FANTASY, 69));
        bibliographicProducts.add(new Book("B56", "To Kill a Mockingbird", 281, new GregorianCalendar(1960, 6, 11), "www.readx.com/book/ToKillAMockingbird", "Novela de Harper Lee publicada en 1960", Genre.HISTORICAL_NOVEL, 85));
        bibliographicProducts.add(new Book("C89", "The Hitchhiker's Guide to the Galaxy", 193, new GregorianCalendar(1979, 8, 12), "www.readx.com/book/TheHitchhikersGuide", "Comedia de ciencia ficción de Douglas Adams", Genre.SCIENCE_FICTION, 55));
        bibliographicProducts.add(new Book("D12", "1984", 328, new GregorianCalendar(1949, 5, 8), "www.readx.com/book/1984", "Novela distópica de George Orwell", Genre.HISTORICAL_NOVEL, 95));
        bibliographicProducts.add(new Book("E45", "The Lord of the Rings", 1031, new GregorianCalendar(1954, 7, 29), "www.readx.com/book/TheLordOfTheRings", "Novela de fantasía épica de J.R.R. Tolkien", Genre.FANTASY, 120));
        bibliographicProducts.add(new Magazine("L5G", "Vogue", 53, new GregorianCalendar(2023, 4, 11), "www.readx.com/magazine/Vogue", Category.DESIGN, 19.99, PublicationPeriodicity.DAILY));
        bibliographicProducts.add(new Magazine("M8F", "National Geographic", 108, new GregorianCalendar(1888, 10, 1), "www.readx.com/magazine/NationalGeographic", Category.SCIENTIFIC, 7.99, PublicationPeriodicity.MONTHLY));
        bibliographicProducts.add(new Magazine("N7B", "Time", 68, new GregorianCalendar(1923, 2, 3), "www.readx.com/magazine/Time", Category.VARIETIES, 12.99, PublicationPeriodicity.WEEKLY));
        bibliographicProducts.add(new Magazine("P3E", "Wired", 80, new GregorianCalendar(1993, 1, 1), "www.readx.com/magazine/Wired", Category.SCIENTIFIC, 9.99, PublicationPeriodicity.MONTHLY));
        bibliographicProducts.add(new Magazine("Q9L", "Rolling Stone", 98, new GregorianCalendar(1967, 11, 9), "www.readx.com/magazine/RollingStone", Category.VARIETIES, 11.99, PublicationPeriodicity.WEEKLY));
        users.add(new Standard("J.K. Rowling", "ROWL01"));
        users.add(new Standard("Stephen King", "KING01"));
        users.add(new Standard("George R.R. Martin", "MART01"));
        users.add(new Standard("Agatha Christie", "CHRI01"));
        users.add(new Standard("Gabriel García Márquez", "GARC01"));
        users.add(new Premium("Oprah Winfrey", "WINF01"));
        users.add(new Premium("Bill Gates", "GATE01"));
        users.add(new Premium("Barack Obama", "OBAM01"));
        users.add(new Premium("Emma Watson", "WATS01"));
        users.add(new Premium("Tom Hanks", "HANK01"));
    }

    /**
     * Description: This method uses all the received parameters to create the necessary classes, and with them create and save an object of type Book
     * @param id String
     * @param name String
     * @param pages int
     * @param publishingDate String
     * @param review String
     * @param genre int
     * @param saleValue double
     * @return boolean
     */

    public boolean registerBook(String id, String name, int pages, String publishingDate, String review, int genre, double saleValue){
        
        String[] parts = publishingDate.split("/");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        Calendar bookPublishingDate = new GregorianCalendar(year, month-1, day);

        Genre genreBook = null;

        if(genre == 1){
            genreBook = Genre.SCIENCE_FICTION;
        }
        else if(genre == 2){
            genreBook = Genre.FANTASY;
        }
        else if(genre == 3){
            genreBook = Genre.HISTORICAL_NOVEL;
        }

        String url = "www.readx.com/book/" + name;

        Book newBook = new Book(id, name, pages, bookPublishingDate, url, review, genreBook, saleValue);

        if(bibliographicProducts.add(newBook)){
            return true;
        }

        else{
            return false;
        }
    }

    /**
     * Description: This method uses all the received parameters to create the necessary classes, and with them create and save an object of type Magazine
     * @param id String
     * @param name String
     * @param pages int
     * @param publishingDate String
     * @param category int
     * @param subscriptionValue double
     * @param publicationPeriodicity int
     * @return boolean
     */

    public boolean registerMagazine(String id, String name, int pages, String publishingDate, int category, double subscriptionValue, int publicationPeriodicity){

        String[] parts = publishingDate.split("/");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        Calendar magazinePublishingDate = new GregorianCalendar(year, month-1, day);

        Category categoryMagazine = null;

        if(category == 1){
            categoryMagazine = Category.VARIETIES;
        }
        else if(category == 2){
            categoryMagazine = Category.DESIGN;
        }
        else if(category == 3){
            categoryMagazine = Category.SCIENTIFIC;
        }

        PublicationPeriodicity publicationPeriodicityMagazine = null;

        if(publicationPeriodicity == 1){
            publicationPeriodicityMagazine = PublicationPeriodicity.DAILY;
        }
        else if(publicationPeriodicity == 2){
            publicationPeriodicityMagazine = PublicationPeriodicity.WEEKLY;
        }
        else if(publicationPeriodicity == 3){
            publicationPeriodicityMagazine = PublicationPeriodicity.MONTHLY;
        }

        String url = "www.readx.com/magazine/" + name;

        Magazine newMagazine = new Magazine(id, name, pages, magazinePublishingDate, url, categoryMagazine, subscriptionValue, publicationPeriodicityMagazine);

        if(bibliographicProducts.add(newMagazine)){
            return true;
        }

        else{
            return false;
        }
    }

    /**
     * Description: This method uses all the received parameters to create an object of type Standard
     * @param name String
     * @param id String
     * @return boolean
     */

    public boolean registerStandardUser(String name, String id){

        Standard newStandardUser = new Standard(name, id);

        if(users.add(newStandardUser)){
            return true;
        }

        else{
            return false;
        }
    }

    /**
     * Description: This method uses all the received parameters to create an object of type Premium
     * @param name String
     * @param id String
     * @return boolean
     */

    public boolean registerPremiumUser(String name, String id){

        Premium newPremiumUser = new Premium(name, id);

        if(users.add(newPremiumUser)){
            return true;
        }

        else{
            return false;
        }
    }

    /**
     * Description: This method iterates through the ArrayList of bibliographic products and generates a list of all the objects that are registered.
     * @return msg String
     */

    public String getBibliographicProductsList(){

        String msg = "";

        for(int i = 0; i < bibliographicProducts.size(); i++){
            msg += "\n" + (i+1) + ". " + bibliographicProducts.get(i).getName();
            if(bibliographicProducts.get(i) instanceof Book){
                msg += " (Book) " + ((Book)(bibliographicProducts.get(i))).getUnitsSold();
            }
            else if(bibliographicProducts.get(i) instanceof Magazine){
                msg += " (Magazine) " + ((Magazine)(bibliographicProducts.get(i))).getActiveSubscriptions();
            }
        }

        return msg;
    }

    /**
     * Description: This method iterates through the ArrayList of users and generates a list of all the objects that are registered.
     * @return msg String
     */

    public String getUsersList(){

        String msg = "";

        for(int i = 0; i < users.size(); i++){
            msg += "\n" + (i+1) + ". " + users.get(i).getName();
            if(users.get(i) instanceof Standard){
                msg += " (Standard)";
            }
            else if(users.get(i) instanceof Premium){
                msg += " (Premium)";
            }
        }

        return msg;
    }

    /**
     * Description: This method iterates through the ArrayList of BibliographicProducts and generates a list of all the objects of type Book that are registered.
     * @return msg String
     */

    public String getBooksList(){

        String msg = "";

        for(int i = 0; i < bibliographicProducts.size(); i++){
            if(bibliographicProducts.get(i) instanceof Book){
                msg += "\n" + (i+1) + ". " + bibliographicProducts.get(i).getName();
            }
        }

        return msg;
    }

    /**
     * Description: This method iterates through the ArrayList of BibliographicProducts and generates a list of all the objects of type Magazine that are registered.
     * @return msg String
     */

    public String getMagazinesList(){

        String msg = "";

        for(int i = 0; i < bibliographicProducts.size(); i++){
            if(bibliographicProducts.get(i) instanceof Magazine){
                msg += "\n" + (i+1) + ". " + bibliographicProducts.get(i).getName();
            }
        }

        return msg;
    }

    /**
     * Description: This method iterates through a specific user's personal library and gets the list of magazines they are subscribed to.
     * @param userPosition int
     * @return msg String
     */

    public String getMagazinesListForAUser(int userPosition){

        String msg = "";

        if(users.get(userPosition) instanceof Standard){
            for(int i = 0; i < ((Standard)(users.get(userPosition))).getMagazines().length; i++){
                if(((Standard)(users.get(userPosition))).getMagazines()[i] != null){
                    msg += "\n" + (i+1) + ". " + ((Standard)(users.get(userPosition))).getMagazines()[i].getName();
                }
            }
        }

        else if(users.get(userPosition) instanceof Premium){
            for(int i = 0; i < ((Premium)(users.get(userPosition))).getPremiumLibrary().size(); i++){
                if(((Premium)(users.get(userPosition))).getPremiumLibrary().get(i) instanceof Magazine){
                    msg += "\n" + (i+1) + ". " + ((Premium)(users.get(userPosition))).getPremiumLibrary().get(i).getName();
                }
            }
        }

        return msg;
    }

    /**
     * Description: This method iterates through a specific standard user's personal library and gets the list of bibliographic products they are subscribed to.
     * @param userPosition int
     * @return msg String
     */

    public String getBibliographicProductsListForAStandardUser(int userPosition){

        String msg = "";
        User user = users.get(userPosition);

        for(int i = 0; i < ((Standard)(user)).getBooks().length; i++){
            if(((Standard)(user)).getBooks()[i] != null){
                msg += "\n" + (i+1) + ". " + ((Standard)(user)).getBooks()[i].getName() + " (Libro)";
            }
        }
        for(int i = 0; i < ((Standard)(user)).getMagazines().length; i++){
            if(((Standard)(user)).getMagazines()[i] != null){
                msg += "\n" + (i+6) + ". " + ((Standard)(user)).getMagazines()[i].getName() + " (Revista)";
            }
        }    
        
        return msg;
    }

    /**
     * Description: Description: This method iterates through a specific premium user's personal library and gets the list of bibliographic products they are subscribed to.
     * @param userPosition int
     * @return msg String
     */

    public String getBibliographicProductsListForAPremiumUser(int userPosition){

        String msg = "";
        User user = users.get(userPosition);

        for(int i = 0; i < ((Premium)(user)).getPremiumLibrary().size(); i++){
            msg += "\n" + (i+1) + ". " + ((Premium)(user)).getPremiumLibrary().get(i).getName();
            if(((Premium)(user)).getPremiumLibrary().get(i) instanceof Book){
                msg += " (Book)";
            }
            else if(((Premium)(user)).getPremiumLibrary().get(i) instanceof Magazine){
                msg += " (Magazine)";
            }
        }

        return msg;
    }

    /**
     * Description: This method validates that the entered String has three hexadecimal characters
     * @param id int
     * @return boolean
     */

    public boolean validateHexadecimal(String id){

        if(id.length() != 3){
            return false;
        }

        for(char c : id.toCharArray()){
            if(!Character.isDigit(c) && (c < 'A' || c > 'F') && (c < 'a' || c > 'f')){
                return false;
            }
        }
      
        return true;
    }

    /**
     * Description: This method validates that the entered String has three alphanumeric characters
     * @param id String
     * @return boolean
     */

    public boolean validateAlphanumeric(String id){

        if(id.length() != 3){
            return false;
        }

        for(char c : id.toCharArray()){
            if(!Character.isLetterOrDigit(c)){
                return false;
            }
        }

        return true;
    }

    /**
     * Description: This method gets the instance of a bibliographic product in the ArrayList
     * @param position int
     * @return String
     */

    public String getInstanceOfBibliographicProduct(int position){

        String msg = "";

        if(bibliographicProducts.get(position) instanceof Book){
            msg = "Book";
        }

        else if(bibliographicProducts.get(position) instanceof Magazine){
            msg = "Magazine";
        }

        return msg;
    }

    /**
     * Description: This method gets the instance of a user in the ArrayList
     * @param position int
     * @return String
     */

    public String getInstanceOfUser(int position){

        String msg = "";

        if(users.get(position) instanceof Standard){
            msg = "Standard";
        }

        else if(users.get(position) instanceof Premium){
            msg = "Premium";
        }

        return msg;
    }

    /**
     * Description: This method modifies the attributes of a book according to the received parameters
     * @param position int
     * @param newName String
     * @param newPages int
     * @param newPublishingDate String
     * @param newReview String
     * @param newGenre int
     * @param newSaleValue double
     */

    public void modifyBook(int position, String newName, int newPages, String newPublishingDate, String newReview, int newGenre, double newSaleValue){

        String[] parts = newPublishingDate.split("/");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        Calendar newBookPublishingDate = new GregorianCalendar(year, month-1, day);

        Genre newGenreBook = null;

        if(newGenre == 1){
            newGenreBook = Genre.SCIENCE_FICTION;
        }
        else if(newGenre == 2){
            newGenreBook = Genre.FANTASY;
        }
        else if(newGenre == 3){
            newGenreBook = Genre.HISTORICAL_NOVEL;
        }

        bibliographicProducts.get(position).setName(newName);
        bibliographicProducts.get(position).setPages(newPages);
        bibliographicProducts.get(position).setPublishingDate(newBookPublishingDate);
        ((Book)(bibliographicProducts.get(position))).setReview(newReview);
        ((Book)(bibliographicProducts.get(position))).setGenre(newGenreBook);
        ((Book)(bibliographicProducts.get(position))).setSaleValue(newSaleValue);
    }

    /**
     * Description: This method modifies the attributes of a magazine according to the received parameters
     * @param position
     * @param newName
     * @param newPages
     * @param newPublishingDate
     * @param newCategory
     * @param newSubscriptionValue
     * @param newPublicationPeriodicity
     */

    public void modifyMagazine(int position, String newName, int newPages, String newPublishingDate, int newCategory, double newSubscriptionValue, int newPublicationPeriodicity){

        String[] parts = newPublishingDate.split("/");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        Calendar newMagazinePublishingDate = new GregorianCalendar(year, month-1, day);

        Category newCategoryMagazine = null;

        if(newCategory == 1){
            newCategoryMagazine = Category.VARIETIES;
        }
        else if(newCategory == 2){
            newCategoryMagazine = Category.DESIGN;
        }
        else if(newCategory == 3){
            newCategoryMagazine = Category.SCIENTIFIC;
        }

        PublicationPeriodicity newPublicationPeriodicityMagazine = null;

        if(newPublicationPeriodicity == 1){
            newPublicationPeriodicityMagazine = PublicationPeriodicity.DAILY;
        }
        else if(newPublicationPeriodicity == 2){
            newPublicationPeriodicityMagazine = PublicationPeriodicity.WEEKLY;
        }
        else if(newPublicationPeriodicity == 3){
            newPublicationPeriodicityMagazine = PublicationPeriodicity.MONTHLY;
        }

        bibliographicProducts.get(position).setName(newName);
        bibliographicProducts.get(position).setPages(newPages);
        bibliographicProducts.get(position).setPublishingDate(newMagazinePublishingDate);
        ((Magazine)(bibliographicProducts.get(position))).setCategory(newCategoryMagazine);
        ((Magazine)(bibliographicProducts.get(position))).setSubscriptionValue(newSubscriptionValue);
        ((Magazine)(bibliographicProducts.get(position))).setPublicationPeriodicity(newPublicationPeriodicityMagazine);
    }

    /**
     * Description: This method removes a bibliographic product from a given position in the ArrayList
     * @param position int
     */

    public void deleteBibliographicProduct(int position){

        bibliographicProducts.remove(position);
    }

    /**
     * Description: This method allows a user to purchase a book, associating it with his personal bookstore, generating a sales bill and updating the units sold.
     * @param userPosition int
     * @param bookPosition int
     * @return boolean
     */

    public boolean buyABook(int userPosition, int bookPosition){

        User user = users.get(userPosition);
        Book book = ((Book)(bibliographicProducts.get(bookPosition)));
        double amountPaid = ((Book)(bibliographicProducts.get(bookPosition))).getSaleValue();
        int newUnitsSold = ((Book)(bibliographicProducts.get(bookPosition))).getUnitsSold() + 1;

        Transaction newTransaction = new Transaction(user, book, amountPaid);

        if(users.get(userPosition) instanceof Standard){
            for(int i = 0; i < ((Standard)(users.get(userPosition))).getBooks().length; i++){
                if(((Standard)(users.get(userPosition))).getBooks()[i] == null){
                    ((Standard)(users.get(userPosition))).getBooks()[i] = book;
                    book.setUnitsSold(newUnitsSold);
                    transactions.add(newTransaction);
                    return true;
                }
            }
        }

        else if(users.get(userPosition) instanceof Premium){
            ((Premium)(users.get(userPosition))).getPremiumLibrary().add(book);
            book.setUnitsSold(newUnitsSold);
            transactions.add(newTransaction);
            return true;
        }

        return false;
    }

    /**
     * Description: This method allows a user to subscribe to a magazine, associating it with his personal bookstore, generating a bill and updating the active subscription.
     * @param userPosition int
     * @param magazinePosition int
     * @return boolean
     */

    public boolean subscribeToAMagazine(int userPosition, int magazinePosition){

        User user = users.get(userPosition);
        Magazine magazine = ((Magazine)(bibliographicProducts.get(magazinePosition)));
        double amountPaid = ((Magazine)(bibliographicProducts.get(magazinePosition))).getSubscriptionValue();
        int newActiveSubscriptions = ((Magazine)(bibliographicProducts.get(magazinePosition))).getActiveSubscriptions() + 1;

        Transaction newTransaction = new Transaction(user, magazine, amountPaid);
        
        if(users.get(userPosition) instanceof Standard){
            for(int i = 0; i < ((Standard)(users.get(userPosition))).getMagazines().length; i++){
                if(((Standard)(users.get(userPosition))).getMagazines()[i] == null){
                    ((Standard)(users.get(userPosition))).getMagazines()[i] = magazine;
                    transactions.add(newTransaction);
                    ((Magazine)(bibliographicProducts.get(magazinePosition))).setActiveSubscriptions(newActiveSubscriptions);
                    return true;
                }
            }
        }

        else if(users.get(userPosition) instanceof Premium){
            ((Premium)(users.get(userPosition))).getPremiumLibrary().add(magazine);
            transactions.add(newTransaction);
            ((Magazine)(bibliographicProducts.get(magazinePosition))).setActiveSubscriptions(newActiveSubscriptions);
            return true;
        }

        return false;
    }

    /**
     * Description: This method allows a user to cancel a subscription to a magazine, removing it from their personal bookstore and updating the active subscriptions.
     * @param userPosition int
     * @param magazinePosition int
     * @return boolean
     */

    public boolean cancelSubscriptionToAMagazine(int userPosition, int magazinePosition){

        User user = users.get(userPosition);
        Magazine magazine = null;
        
        if(user instanceof Standard){
            magazine = ((Standard)(user)).getMagazines()[magazinePosition];
            ((Standard)(user)).getMagazines()[magazinePosition] = null;
        }

        else if(user instanceof Premium){
            magazine = (Magazine)((Premium)(user)).getPremiumLibrary().get(magazinePosition);
            ((Premium)(user)).getPremiumLibrary().remove(magazinePosition);
        }

        int newActiveSubscriptions = magazine.getActiveSubscriptions() - 1;

        for(int i = 0; i < bibliographicProducts.size(); i++){
            if(bibliographicProducts.get(i) instanceof Magazine){
                if(bibliographicProducts.get(i).equals(magazine)){
                    ((Magazine)(bibliographicProducts.get(i))).setActiveSubscriptions(newActiveSubscriptions);
                    return true;
                }        
            }
        }

        return false;
    }

    /**
     * Description: This method allows to reset the page counters of a Standard user of a reading session for a specific product.
     * @param userPosition int
     * @param bibliographicProductPosition int
     */

    public void setBibliographicProductPagesToCeroStandard(int userPosition, int bibliographicProductPosition){

        Standard user = (Standard)users.get(userPosition);

        if(bibliographicProductPosition > 4){
            int newbibliographicProductPosition = bibliographicProductPosition -5;
            Magazine magazine = user.getMagazines()[newbibliographicProductPosition];
            magazine.setCurrentPage(1);
            magazine.setReadingSessionPagesRead(0);
        }
        else{
            Book book = user.getBooks()[bibliographicProductPosition];
            book.setCurrentPage(1);
            book.setReadingSessionPagesRead(0);
        }
    }

    /**
     * Description: This method allows to reset the page counters of a Premium user of a reading session for a specific product
     * @param userPosition int
     * @param bibliographicProductPosition int
     */

    public void setBibliographicProductPagesToCeroPremium(int userPosition, int bibliographicProductPosition){

        Premium user = (Premium)users.get(userPosition);
        BibliographicProduct bibliographicProduct = user.getPremiumLibrary().get(bibliographicProductPosition);
        bibliographicProduct.setCurrentPage(1);
        bibliographicProduct.setReadingSessionPagesRead(0);
    }

    /**
     * Description: This method allows a reading session of a bibliographic product in the library of a Standard user
     * @param userPosition int
     * @param bibliographicProductPosition int
     * @param action int
     * @return msg String
     */

    public String readBibliographicProductOnAStandardUser(int userPosition, int bibliographicProductPosition, int action){

        String msg = "";
        Standard user = (Standard)users.get(userPosition);
        Magazine magazine = null;
        Book book = null;

        if(bibliographicProductPosition > 4){
            int newbibliographicProductPosition = bibliographicProductPosition -5;
            magazine = user.getMagazines()[newbibliographicProductPosition];
        }
        else{
            book = user.getBooks()[bibliographicProductPosition];
        }

        if(magazine == null){
            msg += book.readBibliographicProductForStandard(action);
        }
        if(book == null){
            msg += magazine.readBibliographicProductForStandard(action);
        }

        return msg;
    }

    /**
     * Description: This method allows a reading session of a bibliographic product in the library of a Premium user
     * @param userPosition int
     * @param bibliographicProductPosition int
     * @param action int
     * @return msg String
     */

    public String readBibliographicProductOnAPremiumUser(int userPosition, int bibliographicProductPosition, int action){

        String msg = "";
        Premium user = (Premium)users.get(userPosition);
        BibliographicProduct bibliographicProduct = user.getPremiumLibrary().get(bibliographicProductPosition);

        if(bibliographicProduct instanceof Book){
            msg += ((Book)(bibliographicProduct)).readBibliographicProductForPremium(action);
        }

        else if(bibliographicProduct instanceof Magazine){
            msg += ((Magazine)(bibliographicProduct)).readBibliographicProductForPremium(action);
        }

        return msg;
    }
}