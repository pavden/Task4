package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Enum that stores application commands and emulates factory
 * @author Pavel Denisenko
 * @since 05.03.2019
 */
public enum Commands implements Command {

    LOAD_TRACKLIST("LoadTracklist", new LoadTracklist()),
    SHOW_TRACKLIST("ShowTracklist", new ShowTracklist()),
    SHUFFLE_TRACKLIST("ShuffleTracklist", new ShuffleTracklist()),
    CLEAR_TRACKLIST("ClearTracklist", new ClearTracklist()),
    MAKE_ALBUM("MakeAlbum", new MakeAlbum()),
    SHOW_ALBUM("ShowAlbum", new ShowAlbum()),
    SHUFFLE_ALBUM("ShuffleAlbum", new ShuffleAlbum()),
    CLEAR_ALBUM("ClearAlbum", new ClearAlbum()),
    SHOW_ALBUM_DURATION("ShowAlbumDuration", new ShowAlbumDuration()),
    SORT_ALBUM_BY_GENRE("SortAlbumByGenre", new SortAlbumByGenre()),
    SEARCH_TRACKS_BY_DURATION("SearchTracksByDuration", new SearchTracksByDuration());

    private final String name;
    private final Command command;

    private static final Map<String, Command> lookup = new HashMap<>();
    static {
        for (Commands c : Commands.values()) {
            lookup.put(c.name, c.command);
        }
    }

    Commands(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public static Command getCommandByName(String name) {
        return lookup.getOrDefault(name, SHOW_TRACKLIST.command);
    }

    @Override
    public String execute(HttpServletRequest request) {
        return command.execute(request);
    }

}
