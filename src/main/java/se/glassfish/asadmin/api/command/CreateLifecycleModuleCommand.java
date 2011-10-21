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

public class CreateLifecycleModuleCommand extends RemoteCommand<Integer> {

/*
 * Usage: create-lifecycle-module --className className [--terse=false] [--echo=false] [--interactive=true]
 * [--host localhost] [--port 4848|4849] [--secure | -s] [--user admin_user] [--passwordfile file_name]
 * [--classpath classpath] [--loadorder load_order] [--failurefatal=false] [--enabled=true] [--description description]
 * [--target target(Default server)] [--property (name=value)[:name=value]*] modulename
 * */

    private final String className;
    private final String name;

    private String target;

    public CreateLifecycleModuleCommand(GlassFishEnvironment environment, String target, String classname, String name) {
        super(environment);
        this.className = classname;
        this.name = name;
        this.target = target;
    }

    @Override
    public String getCommandName() {
        return "create-lifecycle-module";
    }


    @Override
    public Integer execute() throws CommandException {

        addParam("classname", className);
        addParam("target", target);
        addArg(name);

        return executeCommand().getReturnCode();
    }

}
