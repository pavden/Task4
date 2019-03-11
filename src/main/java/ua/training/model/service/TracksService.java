package ua.training.model.service;

import ua.training.model.entity.Track;
import ua.training.model.TracklistDB;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Service that provides common tracklist/album operations
 * @author Pavel Denisenko
 * @since 05.03.2019
 */
public class TracksService {

    /**
     * Method that loads tracklist from database emulator
     * @param tracklist Tracklist from database
     */
    public void load(List<Track> tracklist) {
        clear(tracklist);
        Stream.of(TracklistDB.values()).map(t -> new Track(t.getId(), t.getName(), t.getPerformer(),
                                                           t.getGenre(), t.getDuration()))
                                       .forEach(tracklist::add);
    }

    /**
     * Method that clears tracklist/album
     * @param tracklist Tracklist from database or album
     */
    public void clear(List<Track> tracklist) {
        tracklist.clear();
    }

    /**
     * Method that shuffles tracklist/album
     * @param tracklist Tracklist from database or album
     */
    public void shuffle(List<Track> tracklist) {
        Collections.shuffle(tracklist);
    }

    /**
     * Method that creates album from tracklist
     * @param tracklist Tracklist from database
     * @param album Album
     * @param capacity Capacity of album in seconds
     */
    public void write(List<Track> tracklist, List<Track> album, String capacity) {
        clear(album);
        AtomicInteger albumCapacity = new AtomicInteger(Integer.parseInt(capacity));
        tracklist.stream().filter(t -> albumCapacity.addAndGet(-t.getDuration()) >= 0).forEach(album::add);
    }

    /**
     * Method that calculates album duration in seconds
     * @param album Album
     * @return Album duration in seconds
     */
    public int getDuration(List<Track> album) {
        return album.stream().mapToInt(Track::getDuration).sum();
    }

    /**
     * Method that sorts album tracks by music genre
     * @param album Album
     */
    public void sortByGenre(List<Track> album) {
        Collections.sort(album);
    }

    /**
     * Method that searches for tracks having duration in the range [min, max] seconds
     * @param album Album
     * @param min Minimum duration of track
     * @param max Maximum duration of track
     * @return List of tracks from album that have duration in the range [min, max] seconds
     */
    public List<Track> searchByDuration(List<Track> album, String min, String max) {
        return album.stream().filter(t -> (t.getDuration() >= Integer.parseInt(min)
                                           && t.getDuration() <= Integer.parseInt(max)))
                             .collect(Collectors.toList());
    }

}
