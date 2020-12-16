package com.ermias.pagefeedsapp;

public class Card {

    private String card_type;
    // card type text
    private String card_text_value;
    private String card_text_color;
    private int card_text_size;

    //card type title
    private String card__title_text;
    private String card_title_color;
    private int card_title_size;

    //card type description
    private String card_description_value;
    private int card_description_size;
    private String card_description_color;

    // card type image
    private String image_url;
    private int image_width;
    private int image_height;

    public Card() {
    }

    public Card(String card_type, String card_text_value, String card_text_color,
                int card_text_size, String card__title_text, String card_title_color,
                int card_title_size, String card_description_value, int card_description_size,
                String card_description_color, String image_url, int image_width,
                int image_height) {
        this.card_type = card_type;
        this.card_text_value = card_text_value;
        this.card_text_color = card_text_color;
        this.card_text_size = card_text_size;
        this.card__title_text = card__title_text;
        this.card_title_color = card_title_color;
        this.card_title_size = card_title_size;
        this.card_description_value = card_description_value;
        this.card_description_size = card_description_size;
        this.card_description_color = card_description_color;
        this.image_url = image_url;
        this.image_width = image_width;
        this.image_height = image_height;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCard_text_value() {
        return card_text_value;
    }

    public void setCard_text_value(String card_text_value) {
        this.card_text_value = card_text_value;
    }

    public String getCard_text_color() {
        return card_text_color;
    }

    public void setCard_text_color(String card_text_color) {
        this.card_text_color = card_text_color;
    }

    public int getCard_text_size() {
        return card_text_size;
    }

    public void setCard_text_size(int card_text_size) {
        this.card_text_size = card_text_size;
    }

    public String getCard__title_text() {
        return card__title_text;
    }

    public void setCard__title_text(String card__title_text) {
        this.card__title_text = card__title_text;
    }

    public String getCard_title_color() {
        return card_title_color;
    }

    public void setCard_title_color(String card_title_color) {
        this.card_title_color = card_title_color;
    }

    public int getCard_title_size() {
        return card_title_size;
    }

    public void setCard_title_size(int card_title_size) {
        this.card_title_size = card_title_size;
    }

    public String getCard_description_value() {
        return card_description_value;
    }

    public void setCard_description_value(String card_description_value) {
        this.card_description_value = card_description_value;
    }

    public int getCard_description_size() {
        return card_description_size;
    }

    public void setCard_description_size(int card_description_size) {
        this.card_description_size = card_description_size;
    }

    public String getCard_description_color() {
        return card_description_color;
    }

    public void setCard_description_color(String card_description_color) {
        this.card_description_color = card_description_color;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getImage_width() {
        return image_width;
    }

    public void setImage_width(int image_width) {
        this.image_width = image_width;
    }

    public int getImage_height() {
        return image_height;
    }

    public void setImage_height(int image_height) {
        this.image_height = image_height;
    }
}
