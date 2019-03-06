package ua.training.controller.command;

import ua.training.controller.ConfigManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Class that implements Command interface
 * @author Pavel Denisenko
 * @since 05.03.2019
 */
public class ShowAlbum implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return ConfigManager.getProperty("path.page.album");
    }

}
