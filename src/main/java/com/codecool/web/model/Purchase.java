package com.codecool.web.model;

public class Purchase {

    int invoiceId;
    String artistName;
    String albumTitle;
    String trackTitle;
    int price;
    String genre;

    public Purchase(int invoiceId, String artistName, String albumTitle, String trackTitle, int price, String genre) {
        this.invoiceId = invoiceId;
        this.artistName = artistName;
        this.albumTitle = albumTitle;
        this.trackTitle = trackTitle;
        this.price = price;
        this.genre = genre;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public int getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }
}
