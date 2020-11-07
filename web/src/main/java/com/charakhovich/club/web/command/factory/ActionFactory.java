package com.charakhovich.club.web.command.factory;

import com.charakhovich.club.web.command.Command;
import com.charakhovich.club.web.command.CommandType;
import com.charakhovich.club.web.command.PageParam;
import com.charakhovich.club.web.command.PagePath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActionFactory {
    private static Logger logger = LogManager.getLogger(ActionFactory.class);
    private static final String COMMAND_REGEX = "(/.+/)";
    private static final String EMPTY_VALUE = "";
    private static final String PATH_REGEX_START = "/do.+";

    public static Command defineCommand(HttpServletRequest request) {
     /*   String requestUri = request.getRequestURI();
        if (requestUri == null || requestUri.isEmpty()) {
            return CommandType.EMPTY.getCommand();
        }
        requestUri = subStringPathWithRegex(requestUri);
        CommandType cmdType;
        Command command;
        try {

            cmdType = CommandType.valueOf(requestUri.toUpperCase().replaceAll(COMMAND_REGEX, EMPTY_VALUE));
            command = cmdType.getCommand();
        } catch (IllegalArgumentException e) {
            logger.error("Wrong command parameter: ", e);
            return CommandType.EMPTY.getCommand();
        }
        return command;*/
        CommandType cmdType;
        Command command;
        String reqCommand = request.getParameter(PageParam.PARAM_COMMAND);
        try {

            cmdType = CommandType.valueOf(reqCommand.toUpperCase());
            command = cmdType.getCommand();
        } catch (IllegalArgumentException e) {
            logger.error("Wrong command parameter: ", e);
            return CommandType.EMPTY.getCommand();
        }
        return command;

    }

    public static String subStringPathWithRegex(String url) {
        final String PATH_REGEX_START = "/do.+";
        Pattern pattern = Pattern.compile(PATH_REGEX_START);
        String path = null;
        if (url != null) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                path = matcher.group(0);
            } else {
                path = PagePath.MAIN;
            }
        }
        int indexStart=path.indexOf("/do/");
        String str1=path.replaceAll("/do/","");
        int indexEnd=url.indexOf("?");
   /*     String str1="";
        if (indexStart!=-1 &&indexEnd==-1)  str1= url.substring(indexStart,url.length());
        if (indexStart!=-1 &&indexEnd!=-1)  str1= url.substring(indexStart,indexEnd);
        if (indexStart!=-1)  str1= url;
        return str1;*/

        return indexEnd==-1?(str1):str1.substring(0,indexEnd);
    }
}
