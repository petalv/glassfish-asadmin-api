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
import se.glassfish.asadmin.api.PasswordFile;

import java.io.IOException;


public class CreateFileUserCommand extends RemoteCommand {

    private String username;
    private String password;
    private String[] groups;
    private String authrealmname;

    public CreateFileUserCommand(GlassFishEnvironment environment, String username, String password, String[] groups, String authrealmname) {
        super(environment);
        this.username = username;
        this.password = password;
        this.groups = groups;
        this.authrealmname = authrealmname;
    }

    public String getCommandName() {
        return "create-file-user";
    }


    public Object execute() throws CommandException {
        try {
            PasswordFile file = new PasswordFile(environment.getMasterAdminPassword(), environment.getAdminPassword(), null, password, environment.getVersion());
            setPasswordFile(file);
            if (groups != null) {
                addParam("groups", groups);
            }
            if (authrealmname != null) {
                addParam("authrealmname", authrealmname);
            }
            addArg(username);

            return executeCommand();
        } catch (IOException e) {
            throw new CommandException(e);
        }
    }

}