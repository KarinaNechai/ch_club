package com.charakhovich.servlet.command.factory;

import com.charakhovich.servlet.command.Command;
import com.charakhovich.servlet.command.CommandType;

public class ActionFactory {
    public static Command defineCommand(String action) {
        Command resultCommand = null;
        try {
            CommandType currentType = CommandType.valueOf(action.toUpperCase());
            resultCommand = currentType.getCommand();
        } catch (IllegalArgumentException e) {
            resultCommand = CommandType.EMPTY.getCommand();
        }
        return resultCommand;
    }
}

