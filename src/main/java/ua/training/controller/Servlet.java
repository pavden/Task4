package ua.training.controller;

import ua.training.controller.command.Command;
import ua.training.controller.command.Commands;
import ua.training.model.entity.Track;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Controller that processes http requests
 * @author Pavel Denisenko
 * @since 05.03.2019
 */
public class Servlet extends HttpServlet {

    private List<Track> tracklist;
    private List<Track> album;

    @Override
    public void init() throws ServletException {
        tracklist = new CopyOnWriteArrayList<>();
        album = new CopyOnWriteArrayList<>();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("tracklist", tracklist);
        request.setAttribute("album", album);
        Command command = Commands.getCommandByName(request.getParameter("command"));
        String page = command.execute(request);
        request.getRequestDispatcher(page).forward(request, response);
    }

    @Override
    public void destroy() {
        tracklist.clear();
        album.clear();
    }
}
