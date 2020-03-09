/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author akil
 */
public class SessionUtils {

    public static String fetchData(String variableName, HttpServletRequest request, HttpSession session, String defaultValue) {
        String value;
        String tmpValue = ((String) session.getAttribute(variableName) == null ? defaultValue : (String) session.getAttribute(variableName));
        value = (request.getParameter(variableName) == null ? tmpValue : (String) request.getParameter(variableName));
        putData(variableName, session, value);
        return value;
    }

    public static int fetchData(String variableName, HttpServletRequest request, HttpSession session, int defaultValue) {
        Integer value;
        Integer tmpValue = ((Integer) session.getAttribute(variableName) == null ? defaultValue : (Integer) session.getAttribute(variableName));
        try {
            value = (request.getParameter(variableName) == null ? tmpValue : Integer.parseInt((String) request.getParameter(variableName)));
        } catch(NumberFormatException n) {
            value = defaultValue;
        }
        putData(variableName, session, value);
        return value.intValue();
    }

    public static void putData(String variableName, HttpSession session, String value) {
        session.setAttribute(variableName, value);
    }

    public static void putData(String variableName, HttpSession session, int value) {
        session.setAttribute(variableName, value);
    }
}
