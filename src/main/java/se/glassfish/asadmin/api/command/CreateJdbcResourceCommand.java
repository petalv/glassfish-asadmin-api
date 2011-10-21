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

import se.glassfish.asadmin.api.GlassFishEnvironment;
import se.glassfish.asadmin.api.CommandException;

import java.util.Properties;


public class CreateJdbcResourceCommand extends RemoteCommand<Integer> {

    /*    $ asadmin.bat create-jdbc-resource
   Usage: create-jdbc-resource --connectionpoolid id [--terse=false] [--echo=false] [--interactive=true] [--host localhost]
    [--port 4848|4849] [--secure | -s] [--user admin_user] [--passwordfile file_name] [--enabled=true] [--description text]
    [--target target(Default server)] [--property (name=value)[:name=value]*] jndi_name
    */
    private String connectionpoolid;
    private String jndi_name;
    private boolean enabled = true;
    private String description = null;
    private Properties properties = null;


    public CreateJdbcResourceCommand(GlassFishEnvironment environment, String connectionpoolid, String jndi_name) {
        super(environment);
        this.connectionpoolid = connectionpoolid;
        this.jndi_name = jndi_name;
    }

    public String getCommandName() {
        return "create-jdbc-resource";
    }

    public Integer execute() throws CommandException {
        addParam("connectionpoolid", connectionpoolid);
        //addParam("enabled", enabled);
        if (description != null) {
            addParam("description", description);
        }
        if (properties != null) {
            addParam("property", properties);
        }
        addArg(jndi_name);
        return executeCommand().getReturnCode();
    }
}
