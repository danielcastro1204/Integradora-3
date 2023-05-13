package model;

import java.util.ArrayList;

public class Premium extends User{

    private ArrayList <BibliographicProduct> premiumLibrary;

    public Premium(String name, String id) {
        super(name, id);
        this.premiumLibrary = new ArrayList <BibliographicProduct>();

    }

    public ArrayList<BibliographicProduct> getPremiumLibrary() {
        return premiumLibrary;
    }

    public void setPremiumLibrary(ArrayList<BibliographicProduct> premiumLibrary) {
        this.premiumLibrary = premiumLibrary;
    }
}