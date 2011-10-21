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
import se.glassfish.asadmin.api.PasswordFile;
import se.glassfish.asadmin.api.CommandException;

import java.io.IOException;

public abstract class AuthCommand<E> extends Command<E> {

    private PasswordFile passwordFile = null;

    protected AuthCommand(GlassFishEnvironment environment) {
        super(environment);
    }

    public void setPasswordFile(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }

    @Override
    protected CommandResult executeCommand() throws CommandException {
        try {
            addParam("terse", true);
            addParam("interactive", false);
            if (!environment.isUselocalAuth()) {
                if (passwordFile == null) {
                    passwordFile = new PasswordFile(environment.getMasterAdminPassword(), environment.getAdminPassword(), null, null, environment.getVersion());
                }
                addParam("user", environment.getAdminUsername());
                addParam("passwordfile", passwordFile.getLocation());
            }
            return super.executeCommand();
        } catch (IOException e) {
            throw new CommandException(e);
        } finally {
            if (passwordFile != null) {
                passwordFile.delete();
            }
        }
    }
}
