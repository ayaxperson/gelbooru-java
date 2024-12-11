package me.ajax.boorus;

public enum Boorus {
    SAFEBOORU("https://safebooru.org"),
    RULE34("https://rule34.xxx"),
    GELBOORU("https://gelbooru.com/"),
    THE_BIG_IMAGEBOARD("https://tbib.org/"),
    MSPA("http://mspabooru.com/"),
    XBOORU("https://xbooru.com/"),
    THE_COLLECTION("https://the-collection.booru.org/"),
    GARYCBOORU("https://garycbooru.booru.org/"),
    ALL_GIRL("https://allgirl.booru.org/"),
    THE_AZURE_BLADE("https://tab.booru.org/"),
    ROZEN_MAIDEN("https://rm.booru.org/"),
    DRAW_FRIENDS("https://drawfriends.booru.org/");

    public final String baseUrl;

    Boorus(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
