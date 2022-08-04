package com.techelevator.model;

public class Card {

    private int cardId;
    private String img;
    private String title;
    private String caption;
    private boolean isDetrimental;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean isDetrimental() {
        return isDetrimental;
    }

    public void setDetrimental(boolean detrimental) {
        isDetrimental = detrimental;
    }
}
