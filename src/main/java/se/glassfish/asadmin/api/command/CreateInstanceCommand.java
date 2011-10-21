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

public class CreateInstanceCommand extends RemoteCommand<Integer> {

    private String nodeagent;
    private String config;
    private String cluster;
    private Properties systemproperties;
    private String name;

    public CreateInstanceCommand(GlassFishEnvironment environment, String nodeagent, String cluster, String name) {
        super(environment);
        this.nodeagent = nodeagent;
        this.name = name;
        this.cluster = cluster;
    }


    @Override
    public Integer execute() throws CommandException {
        addParam("nodeagent", nodeagent);
        addParam("cluster", cluster);
        addArg(name);

        return executeCommand().getReturnCode();

    }

    @Override
    public String getCommandName() {
        return "create-instance";
    }
}
