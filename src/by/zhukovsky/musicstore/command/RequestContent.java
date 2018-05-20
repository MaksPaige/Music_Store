package by.zhukovsky.musicstore.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maksim Zhukovsky on 24.03.2018.
 */

public class RequestContent {

    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;

    public RequestContent() {
        this.requestParameters = new HashMap<>();
        this.requestAttributes = new HashMap<>();
        this.sessionAttributes = new HashMap<>();
    }

    public void extractValues(HttpServletRequest request) {
        this.requestParameters = new HashMap<>(request.getParameterMap());
        this.requestAttributes = new HashMap<>();
        this.sessionAttributes = new HashMap<>();
        Enumeration<String> requestAttributeNames = request.getAttributeNames();
        while (requestAttributeNames.hasMoreElements()) {
            String name = requestAttributeNames.nextElement();
            this.requestAttributes.put(name, request.getAttribute(name));
        }
        HttpSession session = request.getSession();
        Enumeration<String> sessionAttributeNames = session.getAttributeNames();
        while (sessionAttributeNames.hasMoreElements()) {
            String name = sessionAttributeNames.nextElement();
            this.sessionAttributes.put(name, session.getAttribute(name));
        }
    }

    public void insertAttributes(HttpServletRequest request) {
        for (String name : requestAttributes.keySet()) {
            request.setAttribute(name, requestAttributes.get(name));
        }
        HttpSession session = request.getSession();
        for (String name : sessionAttributes.keySet()) {
            session.setAttribute(name, sessionAttributes.get(name));
        }
    }

    public String getParameter(String key) {
        return requestParameters.get(key)[0];
    }

    public void setAttribute(String name, Object attribute) {
        requestAttributes.put(name, attribute);
    }

    public void setSessionAttribute(String name, Object attribute) {
        sessionAttributes.put(name, attribute);
    }

    public Object getAttribute(String key) {
        return requestAttributes.get(key);
    }

    public Object getSessionAttribute(String key) {
        return sessionAttributes.get(key);
    }

}
