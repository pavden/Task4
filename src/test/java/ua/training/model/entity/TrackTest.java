package ua.training.model.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackTest {

    @Test(expected = IllegalArgumentException.class)
    public void testTrackConstructorNegativeDuration() {
        Track track = new Track(1, "Track", "Performer", Genre.ROCK, -180);
    }

    @Test
    public void testEqualsForEqualTracks() {
        Track track1 = new Track(3, "Track", "Performer", Genre.ROCK, 320);
        Track track2 = new Track(5, "Track", "Performer", Genre.ROCK, 320);
        assertTrue(track1.equals(track2));
    }

    @Test
    public void testEqualsForNonEqualTracks() {
        Track track1 = new Track(3, "Track", "Performer", Genre.ROCK, 320);
        Track track2 = new Track(5, "Track", "Singer", Genre.ROCK, 320);
        assertFalse(track1.equals(track2));
    }

}
