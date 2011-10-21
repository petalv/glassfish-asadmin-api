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

public class CreateNodeAgentCommand extends AuthCommand<Integer> {
/*
    Usage: create-node-agent [--terse=false] [--echo=false] [--interactive=true] [--host DAS_host(Default localhost)] [--port 4848|4849] [--user DAS_user] [--passwordfile file_name] [--agentdir nodeagent_path] [--agentport port_number] [--savemasterpassword=false] [--secure=true] [--agentproperties (name=value)[:name=value]*] [nodeagent_name]
*/

    private String name;

    private String host = "localhost";
    private int port = 4848;
    private boolean savemasterpassword = false;


    public CreateNodeAgentCommand(GlassFishEnvironment environment, String name) {
        super(environment);
        this.name = name;
    }

    @Override
    public Integer execute() throws CommandException {
        addParam("host", host);
        addParam("port", port);
        addParam("savemasterpassword", savemasterpassword);
        addArg(name);
        return executeCommand().getReturnCode();
    }

    @Override
    public String getCommandName() {
        return "create-node-agent";
    }
}
