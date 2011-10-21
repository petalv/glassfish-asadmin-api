/**
 * Java API for management of GlassFish servers.
 * Copyright (C) 2010 Patrik Boström
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package se.glassfish.asadmin.api.command;

import se.glassfish.asadmin.api.CommandException;
import se.glassfish.asadmin.api.GlassFishEnvironment;

import java.util.Properties;

public class CreateJmsDestCommand extends RemoteCommand<Integer> {

    /*
    Usage: create-jmsdest --desttype|-T topic|queue [--terse=false] [--echo=false] [--interactive=true]
    [--host localhost] [--port 4848|4849] [--secure | -s] [--user admin_user] [--passwordfile file_name]
    [--target target (Default server)] [--property (name=value)[:name=value]*] destname
    */

    private JmsDestType desttype;
    private String destname;
    private Properties properties;

    public CreateJmsDestCommand(GlassFishEnvironment environment, JmsDestType desttype, String destname, Properties properties) {
        super(environment);
        this.desttype = desttype;
        this.destname = destname;
        this.properties = properties;
    }

    public String getCommandName() {
        return "create-jmsdest";
    }


    public Integer execute() throws CommandException {

        switch (desttype) {
            case QUEUE:
                addParam("desttype", "queue");
                break;
            case TOPIC:
                addParam("desttype", "topic");
        }
        if (properties != null) {
            addParam("property", properties);
        }
        addArg(destname);
        return executeCommand().getReturnCode();
    }

}
