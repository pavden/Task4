package ua.training.model.entity;

import java.util.Objects;

/**
 * Model that describes common music track
 * @author Pavel Denisenko
 * @since 05.03.2019
 */
public class Track implements Comparable<Track> {

    private int id;
    private String name;
    private String performer;
    private Genre genre;
    private int duration;

    public Track(int id, String name, String performer, Genre genre, int duration) {
        this.id = requirePositiveInt(id, "ID must be greater than 0!");
        this.name = Objects.requireNonNull(name, "Name must not be null!");
        this.performer = Objects.requireNonNull(performer, "Performer must not be null!");
        this.genre = Objects.requireNonNull(genre, "Genre must not be null!");
        this.duration = requirePositiveInt(duration, "Duration must be greater than 0!");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = requirePositiveInt(id, "ID must be greater than 0!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name must not be null!");;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = Objects.requireNonNull(performer, "Performer must not be null!");
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = Objects.requireNonNull(genre, "Genre must not be null!");
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = requirePositiveInt(duration, "Duration must be greater than 0!");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() == obj.getClass()) {
            Track that = (Track) obj;
            return name.equals(that.name)
                    && performer.equals(that.performer)
                    && genre.equals(that.genre)
                    && duration == that.duration;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (31 * (31 * (31 * name.hashCode()
                               + performer.hashCode())
                               + genre.hashCode())
                               + duration);
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "@{ID: " + id
                + ", name: " + name
                + ", performer: " + performer
                + ", genre: " + genre
                + ", duration: " + duration + "}";
    }

    @Override
    public int compareTo(Track track) {
        return genre.getName().compareTo(track.getGenre().getName());
    }

    private int requirePositiveInt(int value, String message) {
        if (value <= 0) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

}
