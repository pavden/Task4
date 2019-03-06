package ua.training.controller.command;

import ua.training.controller.ConfigManager;
import ua.training.model.entity.Track;
import ua.training.model.service.TracksService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Class that implements Command interface
 * @author Pavel Denisenko
 * @since 05.03.2019
 */
public class MakeAlbum implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        new TracksService().write((List<Track>) request.getAttribute("tracklist"),
                                  (List<Track>) request.getAttribute("album"),
                                  request.getParameter("capacity"));
        return ConfigManager.getProperty("path.page.album");
    }

}
