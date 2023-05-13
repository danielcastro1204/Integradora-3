package model;

import java.util.Calendar;
import java.util.Random;

public class Magazine extends BibliographicProduct{

    private Category category;
    private double subscriptionValue;
    private PublicationPeriodicity publicationPeriodicity;
    private int activeSubscriptions;

    public Magazine(String id, String name, int pages, Calendar publishingDate, String url, Category category, double subscriptionValue, PublicationPeriodicity publicationPeriodicity){
        
        super(id, name, pages, publishingDate, url);
        this.category = category;
        this.subscriptionValue = subscriptionValue;
        this.publicationPeriodicity = publicationPeriodicity;
        this. activeSubscriptions = 0;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getSubscriptionValue() {
        return subscriptionValue;
    }

    public void setSubscriptionValue(double subscriptionValue) {
        this.subscriptionValue = subscriptionValue;
    }

    public PublicationPeriodicity getPublicationPeriodicity() {
        return publicationPeriodicity;
    }

    public void setPublicationPeriodicity(PublicationPeriodicity publicationPeriodicity) {
        this.publicationPeriodicity = publicationPeriodicity;
    }

    public int getActiveSubscriptions() {
        return activeSubscriptions;
    }

    public void setActiveSubscriptions(int activeSubscriptions) {
        this.activeSubscriptions = activeSubscriptions;
    }

    /**
     * Description: This method is responsible for the reading simulation of the magazine according to the action selected by the standard user, in addition to managing the possible advertisements
     * @param action int
     * @return msg String
     */

    @Override
    public String readBibliographicProductForStandard(int action){

        String msg = "";
        Random random = new Random();
        int ad = random.nextInt(3)+1;

        if(action == 1 && this.getCurrentPage() < this.getPages()){
            this.setCurrentPage(this.getCurrentPage() + 1);
            this.setPagesRead(this.getPagesRead() + 1);
            this.setReadingSessionPagesRead(this.getReadingSessionPagesRead() + 1);
        }
    
        else if(action == 2 && this.getCurrentPage() > 1){
            this.setCurrentPage(this.getCurrentPage() - 1);
            this.setPagesRead(this.getPagesRead() + 1);
            this.setReadingSessionPagesRead(this.getReadingSessionPagesRead() + 1);
        }
    
        msg += "Reading session in progress\n";
    
        msg += "\nReading: " + this.getName() + "\n";

        if((this.getReadingSessionPagesRead() % 5) == 0){
            if(ad == 1){
                msg += "\n" + ADVERTISEMENT_1 + "\n";
            }
            else if(ad == 2){
                msg += "\n" + ADVERTISEMENT_2 + "\n";
            }
            else if(ad == 3){
                msg += "\n" + ADVERTISEMENT_3 + "\n";
            }
        }
    
        msg += "\nReading page " + this.getCurrentPage() + " of " + this.getPages() + "\n";
    
        if(this.getCurrentPage() < this.getPages()){
            msg += "\nType 1 to go to the next page";
        }
    
        if(this.getCurrentPage() > 1){
            msg += "\nType 2 to go to the previous page";
        }
    
        msg += "\nType 3 to go back to the menu";
    
        return msg;
    }

    /**
     * Description: Description: This method is responsible for the reading simulation of the magazine according to the action selected by the premium user
     * @param action int
     * @return msg String
     */

    @Override
    public String readBibliographicProductForPremium(int action){

        String msg = "";

        if(action == 1 && this.getCurrentPage() < this.getPages()){
            this.setCurrentPage(this.getCurrentPage() + 1);
            this.setPagesRead(this.getPagesRead() + 1);
            this.setReadingSessionPagesRead(this.getReadingSessionPagesRead() + 1);
        }
    
        else if(action == 1 && this.getCurrentPage() > 1){
            this.setCurrentPage(this.getCurrentPage() - 1);
            this.setPagesRead(this.getPagesRead() + 1);
            this.setReadingSessionPagesRead(this.getReadingSessionPagesRead() + 1);
        }
    
        msg += "Reading session in progress\n";
    
        msg += "\nReading: " + this.getName() + "\n";
    
        msg += "\nReading page " + this.getCurrentPage() + " of " + this.getPages() + "\n";
    
        if(this.getCurrentPage() < this.getPages()){
            msg += "\nType 1 to go to the next page";
        }
    
        if(this.getCurrentPage() > 1){
            msg += "\nType 2 to go to the previous page";
        }
    
        msg += "\nType 3 to go back to the menu";
    
        return msg;
    } 
}