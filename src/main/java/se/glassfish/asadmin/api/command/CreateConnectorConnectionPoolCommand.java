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

public class CreateConnectorConnectionPoolCommand extends RemoteCommand<Integer> {

    /*
Usage: create-connector-connection-pool --raname resource_adapter_name --connectiondefinition connection_definition_name [--terse=false]
[--echo=false] [--interactive=true] [--host localhost] [--port 4848|4849] [--secure | -s] [--user admin_user] [--passwordfile file_name]
[--steadypoolsize 8] [--maxpoolsize 32] [--maxwait 60000] [--poolresize 2] [--idletimeout 300] [--failconnection=false]
[--transactionsupport transaction_support] [--isconnectvalidatereq=false] [--description text] [--property (name=value)[:name=value]*] poolname
     */

    private String raname;
    private String connectiondefinition;

    private int steadypoolsize = 8;
    private int maxpoolsize = 32;
    private int maxwait = 60000;
    private int poolresize = 2;
    private int idletimeout = 300;
    private boolean failconnection = false;
    private boolean isconnectvalidatereq = false;

    private String description;

    private String poolname;

    public CreateConnectorConnectionPoolCommand(GlassFishEnvironment environment, String raname, String connectiondefinition, String poolname) {
        super(environment);
        this.raname = raname;
        this.connectiondefinition = connectiondefinition;
        this.poolname = poolname;
    }


    @Override
    public Integer execute() throws CommandException {
        addParam("steadypoolsize", steadypoolsize);
        addParam("maxpoolsize", maxpoolsize);
        addParam("maxwait", maxwait);
        addParam("poolresize", poolresize);
        addParam("idletimeout", idletimeout);
        addParam("failconnection", failconnection);
        addParam("isconnectvalidatereq", isconnectvalidatereq);

        if (description != null) {
            addParam("description", description);
        }

        addParam("raname", raname);
        addParam("connectiondefinition", connectiondefinition);


        addArg(poolname);

        return executeCommand().getReturnCode();
    }

    @Override
    public String getCommandName() {
        return "create-connector-connection-pool";
    }

    public void setRaname(String raname) {
        this.raname = raname;
    }

    public void setConnectiondefinition(String connectiondefinition) {
        this.connectiondefinition = connectiondefinition;
    }

    public void setSteadypoolsize(int steadypoolsize) {
        this.steadypoolsize = steadypoolsize;
    }

    public void setMaxpoolsize(int maxpoolsize) {
        this.maxpoolsize = maxpoolsize;
    }

    public void setMaxwait(int maxwait) {
        this.maxwait = maxwait;
    }

    public void setPoolresize(int poolresize) {
        this.poolresize = poolresize;
    }

    public void setIdletimeout(int idletimeout) {
        this.idletimeout = idletimeout;
    }

    public void setFailconnection(boolean failconnection) {
        this.failconnection = failconnection;
    }

    public void setIsconnectvalidatereq(boolean isconnectvalidatereq) {
        this.isconnectvalidatereq = isconnectvalidatereq;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPoolname(String poolname) {
        this.poolname = poolname;
    }
}
