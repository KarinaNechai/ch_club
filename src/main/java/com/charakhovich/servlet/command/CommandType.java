package com.charakhovich.servlet.command;

import com.charakhovich.servlet.command.impl.EmptyCommand;
import com.charakhovich.servlet.command.impl.LoginCommand;

public enum CommandType {
    LOGIN {{
        this.command = new LoginCommand();
    }},
    LOGOUT{{
        this.command = new LoginCommand();
    }},
    EMPTY {{
        this.command = new EmptyCommand();
    }
    };
    Command command;

    public Command getCommand() {
        return command;
    }
}
