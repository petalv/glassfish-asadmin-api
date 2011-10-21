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

import java.util.List;
import java.util.Properties;

public class CreateClusterCommand extends RemoteCommand<Integer> {
    /*
    Usage: create-cluster [--terse=false] [--echo=false] [--interactive=true] [--host localhost]
    [--port 4848|4849] [--secure|-s=true] [--user admin_user] [--passwordfile file_name]
    [--config config_name] [--systemproperties (name=value)[:name=value]*] [--hosts hadb-host-list]
    [--haagentport port_number] [--haadminpassword password] [--haadminpasswordfile file_name]
    [--devicesize devicesize] [--haproperty (name=value)[:name=value]*] [--autohadb=false]
    [--portbase port-number] cluster_name
    */

    private String config;
    private Properties systemproperties;
    private String name;

    public CreateClusterCommand(GlassFishEnvironment environment, String name) {
        super(environment);
        this.name = name;
    }

    @Override
    public Integer execute() throws CommandException {
        addArg(name);
        return executeCommand().getReturnCode();
    }

    @Override
    public String getCommandName() {
        return "create-cluster";
    }
}
