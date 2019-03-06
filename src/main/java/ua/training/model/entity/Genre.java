package ua.training.model.entity;

/**
 * Enum classifies common music genres
 * @author Pavel Denisenko
 * @since 05.03.2019
 */
public enum Genre {

    ALTERNATIVE("Alternative"),
    BLUES("Blues"),
    CLASSICAL("Classical"),
    COUNTRY("Country"),
    DANCE("Dance"),
    ELECTRONIC("Electronic"),
    INDUSTRIAL("Industrial"),
    JAZZ("Jazz"),
    POP("Pop"),
    RAP("Rap"),
    REGGAE("Reggae"),
    ROCK("Rock");

    private final String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
