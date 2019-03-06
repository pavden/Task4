package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface that defines basic contract for commands implementation
 * @author Pavel Denisenko
 * @since 05.03.2019
 */
public interface Command {
    String execute(HttpServletRequest request);
}
