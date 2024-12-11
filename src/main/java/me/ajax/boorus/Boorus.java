package me.ajax.boorus;

public enum Boorus {
    SAFEBOORU("https://safebooru.org"),
    RULE34("https://rule34.xxx"),
    GELBOORU("https://gelbooru.com/"),
    THE_BIG_IMAGEBOARD("https://tbib.org/"),
    MSPA("http://mspabooru.com/"),
    PONI_BOORU("http://pbooru.com/"),
    XBOORU("https://xbooru.com/");

    public final String baseUrl;

    Boorus(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
