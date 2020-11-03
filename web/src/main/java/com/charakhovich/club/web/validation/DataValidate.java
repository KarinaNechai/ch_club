package com.charakhovich.club.web.validation;

import com.charakhovich.club.web.command.RequestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static com.charakhovich.club.web.command.PageAttribute.*;

public class DataValidate {
    static final Logger logger = LogManager.getLogger(DataValidate.class);
    public static final String ERROR_MESSAGE = "error";
    public static final String XSS_ATTACK = "</?script>";
    private static final String PASSWORD_PATTERN = "?!^[0-9]*$)(?!^[a-zA-Z]*$)^(.{8,15})$";
    private static final String LOGIN_PATTERN = "\\?!^[0-9]*$)(?!^[a-zA-Z]*$)^(.{8,15})$";
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isValidPageParameters(RequestContext requestContext) {
        boolean result = true;
        for (Map.Entry<String, Object> entry : requestContext.getReqParams().entrySet()) {
            switch (entry.getKey()) {
                case USER_LOGIN:
                    String value = (String) entry.getValue();
                    boolean flag = value.matches(EMAIL_PATTERN);
                    if (!flag) {
                        entry.setValue(ERROR_MESSAGE);
                        result = false;
                    }
                    break;
                case USER_PASSWORD:
                    value = (String) entry.getValue();
                    flag = value.matches(PASSWORD_PATTERN);
                    if (!flag) {
                        entry.setValue(ERROR_MESSAGE);
                        result = false;
                    }
                    break;
                case EVENT_DESCRIPTION:
                    value = (String) entry.getValue();
                    flag = value.matches(XSS_ATTACK);
                    if (flag) {
                        entry.setValue(ERROR_MESSAGE);
                        result = false;
                    }
                default:
                    value = (String) entry.getValue();
                    flag = value.matches(XSS_ATTACK);
                    if (flag) {
                        entry.setValue(ERROR_MESSAGE);
                        result = false;
                    }
            }
        }
        return result;
    }
}
