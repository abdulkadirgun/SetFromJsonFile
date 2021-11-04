package com.example.calisma4_recyclerviewornek2;


public class Card {
    private final String id;
    private final String title;
    private final String fact;
    private final String source;

    public Card(String id, String title, String fact, String source) {
        this.id = id;
        this.title = title;
        this.fact = fact;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFact() {
        return fact;
    }

    public String getSource() {
        return source;
    }
}