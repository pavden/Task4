package ua.training.model.entity;

/**
 * Enum that emulates tracklist database
 * @author Pavel Denisenko
 * @since 05.03.2019
 */
public enum TracklistDB {

    TRACK_1(1, "Natural", "Imagine Dragons", Genre.ALTERNATIVE, 189),
    TRACK_2(2, "Still Got The Blues", "Gary Moore", Genre.BLUES, 251),
    TRACK_3(3, "Toccata and Fugue", "Johann Sebastian Bach", Genre.CLASSICAL, 535),
    TRACK_4(4, "Rhinestone Cowboy", "Glen Campbell", Genre.COUNTRY, 194),
    TRACK_5(5, "4 AM", "Scooter", Genre.DANCE, 197),
    TRACK_6(6, "Protection", "Massive Attack", Genre.ELECTRONIC, 290),
    TRACK_7(7, "Stigmata", "Ministry", Genre.INDUSTRIAL, 362),
    TRACK_8(8, "Let It Be", "Ray Charles", Genre.JAZZ, 215),
    TRACK_9(9, "I Believe", "Bad Boys Blue", Genre.POP, 210),
    TRACK_10(10, "Lose Yourself", "Eminem", Genre.RAP, 320),
    TRACK_11(11, "No Woman No Cry", "Bob Marley", Genre.REGGAE, 222),
    TRACK_12(12, "Who Wants to Live Forever", "Queen", Genre.ROCK, 303);

    private final int id;
    private final String name;
    private final String performer;
    private final Genre genre;
    private final int duration;

    TracklistDB(int id, String name, String performer, Genre genre, int duration) {
        this.id = id;
        this.name = name;
        this.performer = performer;
        this.genre = genre;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPerformer() {
        return performer;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

}
