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
public class SearchTracksByDuration implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        List<Track> tracksByDuration = new TracksService().searchByDuration((List<Track>) request.getAttribute("album"),
                                                                            request.getParameter("min"),
                                                                            request.getParameter("max"));
        request.setAttribute("searchresults", tracksByDuration);
        return ConfigManager.getProperty("path.page.album");
    }

}
