package by.zhukovsky.musicstore.servlet;

import by.zhukovsky.musicstore.command.ActionCommand;
import by.zhukovsky.musicstore.command.ActionFactory;
import by.zhukovsky.musicstore.command.RequestContent;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maksim Zhukovsky on 20.03.2018.
 */

@WebServlet("/controller")
public class Controller extends HttpServlet {

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = null;
        ActionFactory client = new ActionFactory();
        RequestContent requestContent = new RequestContent();
        requestContent.extractValues(req);
        ActionCommand command = client.defineCommand(requestContent);
        page = command.execute(requestContent);
        if (page != null) {
            requestContent.insertAttributes(req);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }
    }

}



