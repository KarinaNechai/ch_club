package com.charakhovich.club.web.command;

import com.charakhovich.club.web.command.impl.*;

public enum CommandType {
    LOCALE {{this.command = new LocaleCommand();
    }},
    EVENT_ADD {{this.command = new EventAddCommand();
    }},
    EVENTS {{this.command = new ViewEventsCommand();
    }},
    EVENT_VIEW
    {{this.command = new EventViewCommand();
    }},
    LOGIN {{
        this.command = new LoginCommand();
    }},
    LOGOUT{{
        this.command = new LogoutCommand();
    }},
    EMPTY {{
        this.command = new EmptyCommand();
    }}/*,
 /*   REFRESH_PAGE{{
        this.command = new RefreshPageCommand();
    }
    }*/;
    Command command;

    public Command getCommand() {
        return command;
    }
}
