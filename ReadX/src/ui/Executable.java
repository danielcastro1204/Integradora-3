package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller controller;

	public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

    /**
     * Description: This method contains the system menu, in which the user is asked for the action they want to do until they decide to exit.
     */

	private void menu(){

		System.out.println("Welcome to ReadX");

		boolean flag = false;

		while (!flag) {

			//Ajuste en funcionalidad
			System.out.println("\n1 = Register a new bibliographic product");
			System.out.println("2 = Register a new user");
            System.out.println("3 = Manage bibliographic products");
            System.out.println("4 = Buy a book");
            System.out.println("5 = Subscribe to a magazine");
            System.out.println("6 = Cancel subscribtion to a magazine");
            System.out.println("7 = Start a reading session");
            System.out.println("8 = Get information of bibliographic products");
            System.out.println("9 = Generate test cases");
			System.out.println("10 = Leave the program");
			int option = reader.nextInt();

			switch (option) {

			case 1:
				registerBibliographicProduct();
				break;
			case 2:
				registerUser();
				break;
			case 3:
				manageBibliographicProducts();
                break;
            case 4: 
                buyABook();
                break;
            case 5: 
                subscribeToAMagazine();
                break;
            case 6: 
                cancelSubscriptionToAMagazine();
                break;
            case 7: 
                startReadingSession();
                break;
            case 8: 
                consultBibliographicProducts();
                break;
            case 9: 
                generateTestObjects();
                break;
            case 10:
                System.exit(0);
				break;
			}
		}
	}

    /**
     * Description: This method asks the user for all the information needed to register a new bibliographic product.
     */

    private void registerBibliographicProduct(){

        System.out.println("Insert the type of bibliographic product: \n1 = Book \n2 = Magazine");
        int type = reader.nextInt();
        reader.nextLine();

        System.out.println("Insert the name of the bibliographic product");
        String name = reader.nextLine();

        System.out.println("Insert the number of pages that the bibliographic product has");
        int pages = reader.nextInt();
        reader.nextLine();

        System.out.println("Insert the publishing date of the bibliographic product (In format YYYY/MM/DD)");
        String publishingDate = reader.nextLine();

        if(type == 1){

            System.out.println("Insert the id for the book. This id must have 3 hexadecimal characters");
            String id = reader.nextLine();

            if(controller.validateHexadecimal(id)){

                System.out.println("Insert the review for the book");
                String review = reader.nextLine();

                System.out.println("Insert the genre of the book: \n1 = Science fiction \n2 = Fantasy \n3 = Historical novel");
                int genre = reader.nextInt();

                System.out.println("Insert the sale value of the book");
                double saleValue = reader.nextDouble();

                if(controller.registerBook(id, name, pages, publishingDate, review, genre, saleValue)){
                    System.out.println("The book was registered successfully");
                }

                else{
                    System.out.println("The book was not registered. Try again");
                }
            }

            else{
                System.out.println("The id provided is not valid for a book product. Try again");
            }

            
        }

        else if(type == 2){

            System.out.println("Insert the id for the magazine. This id must have 3 alphanumeric characters");
            String id = reader.nextLine();

            if(controller.validateAlphanumeric(id)){

                System.out.println("Insert the category of the magazine: \n1 = Varieties \n2 = Design \n3 = Scientific");
                int category = reader.nextInt();

                System.out.println("Insert the subscription value of the magazine");
                double subscriptionValue = reader.nextDouble();

                System.out.println("Insert the publication periodicity of the magazine: \n1 = Daily \n2 = Weekly \n3 = Monthly");
                int publicationPeriodicity = reader.nextInt();

                if(controller.registerMagazine(id, name, pages, publishingDate, category, subscriptionValue, publicationPeriodicity)){
                    System.out.println("The magazine was registered successfully");
                }

                else{
                    System.out.println("The magazine was not registered. Try again");
                }
            }

            else{
                System.out.println("The id provided is not valid for a magazine product. Try again");
            }
        }
    }

    /**
     * Description: This method asks the user for all the information needed to register a new user in the system.
     */

    private void registerUser(){

        System.out.println("Insert the type of user: \n1 = Standard \n2 = Premium");
        int type = reader.nextInt();
        reader.nextLine();

        System.out.println("Insert the name of the user");
        String name = reader.nextLine();

        System.out.println("Insert your ID number");
        String id = reader.nextLine();

        if(type == 1){

            if(controller.registerStandardUser(name, id)){
                System.out.println("The standard user was registered successfully");
            }

            else{
                System.out.println("The user was not registered. Try again");
            }
        }
        else if(type == 2){

            if(controller.registerPremiumUser(name, id)){
                System.out.println("The premium user was registered successfully. You can now buy or subscribe to as many bibliographic products you want");
            }

            else{
                System.out.println("The user was not registered. Try again");
            }
        }
    }

    /**
     * Description: This method shows the bibliographic products found in the system
     */

    private void consultBibliographicProducts(){

        if(controller.getBibliographicProductsList().equals("")){
            System.out.println("There aren't bibliographic products registered on the system");
        }

        else{
            System.out.println("These are the bibliographic products registered");
            System.out.println(controller.getBibliographicProductsList());
        }
    }

    /**
     * Description: This method allows the user to manage the different bibliographic products, from modifying their information to deleting them.
     */

    private void manageBibliographicProducts(){

        System.out.println("Insert the action you want to do: \n1 = Modify bibliographic product \n2 = Delete bibliographic product");
        int action = reader.nextInt();

        if(controller.getBibliographicProductsList().equals("")){
            System.out.println("There aren't any bibliographic products registered on the system");
        }

        else{
            System.out.println("These are the bibliographic products registered:");
            System.out.println(controller.getBibliographicProductsList());

            System.out.println("Select the number of the bibliographic product you would like to manage:");
            int position = reader.nextInt();

            if(action == 1){

                reader.nextLine();
                System.out.println("Insert the new name for the bibliographic product");
                String newName = reader.nextLine();

                System.out.println("Insert the new number of pages that the bibliographic product has");
                int newPages = reader.nextInt();
                reader.nextLine();

                System.out.println("Insert the new publishing date of the bibliographic product (In format YYYY/MM/DD)");
                String newPublishingDate = reader.nextLine();

                if(controller.getInstanceOfBibliographicProduct(position-1).equals("Book")){

                    System.out.println("Insert the new review for the book");
                    String newReview = reader.nextLine();

                    System.out.println("Insert the new genre of the book: \n1 = Science fiction \n2 = Fantasy \n3 = Historical novel");
                    int newGenre = reader.nextInt();

                    System.out.println("Insert the new sale value of the book");
                    double newSaleValue = reader.nextDouble();

                    controller.modifyBook(position-1, newName, newPages, newPublishingDate, newReview, newGenre, newSaleValue);
                    System.out.println("The book was modified successfully");
                }
        
                else if(controller.getInstanceOfBibliographicProduct(position-1).equals("Magazine")){
        
                    System.out.println("Insert the new category of the magazine: \n1 = Varieties \n2 = Design \n3 = Scientific");
                    int newCategory = reader.nextInt();

                    System.out.println("Insert the new subscription value of the magazine");
                    double newSubscriptionValue = reader.nextDouble();

                    System.out.println("Insert the publication periodicity of the magazine: \n1 = Daily \n2 = Weekly \n3 = Monthly");
                    int newPublicationPeriodicity = reader.nextInt();

                    controller.modifyMagazine(position-1, newName, newPages, newPublishingDate, newCategory, newSubscriptionValue, newPublicationPeriodicity);
                    System.out.println("The book was modified successfully");
                }

            }

            else if(action == 2){

                controller.deleteBibliographicProduct(position-1);
                System.out.println("The bibliographic product was successfully deleted");
            }
        }
    }

    /**
     * Description: This method allows the user to provide all the information necessary to purchase a book
     */

    private void buyABook(){

        if(controller.getUsersList().equals("")){
            System.out.println("There aren't any users registered on the system");
        }

        else{
            System.out.println("These are the users registered");
            System.out.println(controller.getUsersList());

            System.out.println("Select the number of the user who wants to buy a book");
            int userPosition = reader.nextInt();

            if(controller.getBooksList().equals("")){
                System.out.println("There aren't any books registered on the system");
            }

            else{
                System.out.println("These are the available books");
                System.out.println(controller.getBooksList());

                System.out.println("Select the number of the book that you want to buy");
                int bookPosition = reader.nextInt();

                if(controller.buyABook(userPosition-1, bookPosition-1)){
                    System.out.println("The book was successfully purchased");
                }
                
                else{
                    System.out.println("Couldn't buy the book. Try again");
                }
            }
        }
    }

    /**
     * Description: This method allows the user to provide all the information necessary to subscribe to a magazine.
     */

    private void subscribeToAMagazine(){

        if(controller.getUsersList().equals("")){
            System.out.println("There aren't any users registered on the system");
        }

        else{
            System.out.println("These are the users registered");
            System.out.println(controller.getUsersList());

            System.out.println("Select the number of the user who wants to subscribe to a magazine");
            int userPosition = reader.nextInt();

            if(controller.getMagazinesList().equals("")){
                System.out.println("There aren't any magazines registered on the system");
            }

            else{
                System.out.println("These are the available magazines");
                System.out.println(controller.getMagazinesList());

                System.out.println("Select the number of the magazine that you want to subscribe to");
                int magazinePosition = reader.nextInt();

                if(controller.subscribeToAMagazine(userPosition-1, magazinePosition-1)){
                    System.out.println("The subscription to the magazine was successfully purchased");
                }
                
                else{
                    System.out.println("Couldn't subscribe to the magazine. Try again");
                }
            }
        }
    }

    /**
     * Description: This method allows the user to unsubscribe from a magazine from his personal library.
     */

    private void cancelSubscriptionToAMagazine(){

        if(controller.getUsersList().equals("")){
            System.out.println("There aren't any users registered on the system");
        }

        else{
            System.out.println("These are the users registered");
            System.out.println(controller.getUsersList());

            System.out.println("Select the number of the user who wants to cancel a subscription to a magazine");
            int userPosition = reader.nextInt();

            if(controller.getMagazinesListForAUser(userPosition-1).equals("")){
                System.out.println("This user isn't subscribed to any magazine");
            }

            else{
                System.out.println("These are the magazines to which this user is subscribed");
                System.out.println(controller.getMagazinesListForAUser(userPosition-1));

                System.out.println("Select the number of the magazine that you want to unsubscribe to");
                int magazinePosition = reader.nextInt();

                if(controller.cancelSubscriptionToAMagazine(userPosition-1, magazinePosition-1)){
                    System.out.println("The subscription to the magazine was successfully cancelled");
                }
                
                else{
                    System.out.println("Couldn't unsubscribe to the magazine. Try again");
                }
            }
        }
    }

    /**
     * Description: This method allows the user to start a reading session of a bibliographic product found in his personal library.
     */

    private void startReadingSession(){

        if(controller.getUsersList().equals("")){
            System.out.println("There aren't any users registered on the system");
        }

        else{
            System.out.println("These are the users registered");
            System.out.println(controller.getUsersList());

            System.out.println("Select the number of the user who wants to start a reading session");
            int userPosition = reader.nextInt();

            if(controller.getInstanceOfUser(userPosition-1).equals("Standard")){

                if(controller.getBibliographicProductsListForAStandardUser(userPosition-1).equals("")){
                    System.out.println("This standard user has not purchased any books or subscribed to a magazine");
                }

                else{

                    System.out.println("This is the user's library");
                    System.out.println(controller.getBibliographicProductsListForAStandardUser(userPosition-1));

                    System.out.println("Select the number of the bibliographic product that you want to read");
                    int bibliographicProductPosition = reader.nextInt();

                    controller.setBibliographicProductPagesToCeroStandard(userPosition-1, bibliographicProductPosition-1);

                    System.out.println("Starting reading session...\n");

                    int action = 0;

                    do {
                        System.out.println(controller.readBibliographicProductOnAStandardUser(userPosition-1, bibliographicProductPosition-1, action));
                        action = reader.nextInt();
                    } while(action == 1 || action == 2);   
                }
            }

            else if(controller.getInstanceOfUser(userPosition-1).equals("Premium")){

                if(controller.getBibliographicProductsListForAPremiumUser(userPosition-1).equals("")){
                    System.out.println("This premium user has not purchased any books or subscribed to a magazine");
                }

                else{

                    System.out.println("This is the user's library");
                    System.out.println(controller.getBibliographicProductsListForAPremiumUser(userPosition-1));

                    System.out.println("Select the number of the bibliographic product that you want to read");
                    int bibliographicProductPosition = reader.nextInt();

                    controller.setBibliographicProductPagesToCeroPremium(userPosition-1, bibliographicProductPosition-1);

                    System.out.println("Starting reading session...\n");

                    int action = 0;

                    do {
                        System.out.println(controller.readBibliographicProductOnAPremiumUser(userPosition-1, bibliographicProductPosition-1, action));
                        action = reader.nextInt();
                    } while(action == 1 || action == 2);

                }
            }
        }
    }

    /**
     * Description: This method allows you to generate test objects of type Standard, Premium, Magazine and Book
     */

    private void generateTestObjects(){
    
        controller.testCases();
        System.out.println("Test objects generated successfully");
    }
}