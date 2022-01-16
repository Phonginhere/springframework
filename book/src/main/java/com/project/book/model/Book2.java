package com.project.book.model;

public class Book2 {
    private String bookID;
    private String title;
    private float price;
    private String categoryName;

    public Book2() {
    }

    public Book2(String bookID, String title, float price, String categoryName) {
        this.bookID = bookID;
        this.title = title;
        this.price = price;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Book2{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
