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

public class CreateJmsResourceCommand extends RemoteCommand<Integer> {


    private String description;
    private Properties properties;
    private String target;
    private String jndi_name;
    private JmsResourceType restype;

    public CreateJmsResourceCommand(GlassFishEnvironment environment, String target, JmsResourceType restype, String jndi_name) {
        super(environment);
        this.restype = restype;
        this.jndi_name = jndi_name;
        this.target = target;
    }

    public CreateJmsResourceCommand(GlassFishEnvironment environment, String target, JmsResourceType restype, String jndi_name,String description, Properties properties) {
        super(environment);
        this.restype = restype;
        this.jndi_name = jndi_name;
        this.properties = properties;
        this.target = target;
        this.description = description;
    }

    public String getCommandName() {
        return "create-jms-resource";
    }

    public JmsResourceType getRestype() {
        return restype;
    }

    public void setRestype(JmsResourceType restype) {
        this.restype = restype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getJndi_name() {
        return jndi_name;
    }

    public void setJndi_name(String jndi_name) {
        this.jndi_name = jndi_name;
    }

/*
Usage: create-jms-resource --restype resource_type [--terse=false] [--echo=false
] [--interactive=true] [--host localhost] [--port 4848|4849] [--secure | -s] [--
user admin_user] [--passwordfile file_name] [--enabled=true] [--description text
] [--property (name=value)[:name=value]*] [--target target(Default server)] jndi
_name
CLI014 restype is a required option.
*/


    public Integer execute() throws CommandException {
        if (target != null) {
            addParam("target", target);
        }

        if (description != null) {
            addQuotedParam("description", description);
        }
        if (properties != null) {
            addParam("property", properties);
        }
        switch (restype) {
            case javax_jms_Queue:
                addParam("restype", "javax.jms.Queue");
                break;
            case javax_jms_Topic:
                addParam("restype", "javax.jms.Topic");
                break;
            case javax_jms_ConnectionFactory:
                addParam("restype", "javax.jms.ConnectionFactory");
                break;
            case javax_jms_QueueConnectionFactory:
                addParam("restype", "javax.jms.QueueConnectionFactory");
                break;
            case javax_jms_TopicConnectionFactory:
                addParam("restype", "javax.jms.TopicConnectionFactory");
                break;
        }
        addArg(jndi_name);
        return executeCommand().getReturnCode();
    }
}
