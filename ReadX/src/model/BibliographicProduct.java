package model;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public abstract class BibliographicProduct implements Readable {

    private String id;
    private String name;
    private int pages;
    private Calendar publishingDate;
    private String url;
    private int pagesRead;
    private int currentPage;
    private int readingSessionPagesRead;
    
    public BibliographicProduct(String id, String name, int pages, Calendar publishingDate, String url){

        new SimpleDateFormat("yyyy/MM/dd");

        this.id = id;
        this.name = name;
        this.pages = pages;
        this.publishingDate = publishingDate;
        this.url = url;
        this.pagesRead = 0;
        this.currentPage = 1;
        this.readingSessionPagesRead = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Calendar getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Calendar publishingDate) {
        this.publishingDate = publishingDate;
    } 
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    public String toString() {
        return "BibliographicProduct [id=" + id + ", name=" + name + ", pages=" + pages + ", publishingDate="
                + publishingDate + ", url=" + url + ", pagesRead=" + pagesRead + "]\n";
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getReadingSessionPagesRead() {
        return readingSessionPagesRead;
    }

    public void setReadingSessionPagesRead(int readingSessionPagesRead) {
        this.readingSessionPagesRead = readingSessionPagesRead;
    } 
}