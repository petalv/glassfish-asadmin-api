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

public class CreateJavaMailResourceCommand extends RemoteCommand<Integer> {

    /*
    Usage: create-javamail-resource --mailhost hostname --mailuser username --fromaddress address
    [--terse=false] [--echo=false] [--interactive=true] [--host localhost] [--port 4848|4849]
    [--secure | -s] [--user admin_user] [--passwordfile file_name] [--storeprotocol imap]
    [--storeprotocolclass com.sun.mail.imap.IMAPStore] [--transprotocol smtp]
    [--transprotocolclass com.sun.mail.smtp.SMTPTransport] [--debug=false] [--enabled=true]
    [--description text] [--property (name=value)[:name=value]*]
    [--target target(Default server)] jndi_name
    */


    private String mailhost;
    private String mailuser;
    private String fromaddress;
    private String jndi_name;

    private boolean enabled = true;
    private String storeprotocol = "imap";

    private String target;

    public CreateJavaMailResourceCommand(GlassFishEnvironment environment, String target, String mailhost, String mailuser, String fromaddress, String jndi_name) {
        super(environment);
        this.mailhost = mailhost;
        this.mailuser = mailuser;
        this.fromaddress = fromaddress;
        this.jndi_name = jndi_name;
        this.target = target;
    }

    public String getCommandName() {
        return "create-javamail-resource";
    }

    public Integer execute() throws CommandException {
        addParam("mailhost", mailhost);
        addParam("mailuser", mailuser);
        addParam("fromaddress", fromaddress);
        addParam("storeprotocol", storeprotocol);
        addParam("target", target);
        addParam("enabled", enabled);

        addArg(jndi_name);
        return executeCommand().getReturnCode();

    }


}
