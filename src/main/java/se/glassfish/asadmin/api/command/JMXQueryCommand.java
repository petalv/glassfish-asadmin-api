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

import javax.management.ObjectName;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.IOException;

public abstract class JMXQueryCommand<E> {

    private int port;
    private String host;
    private String username;
    private String password;
    private ObjectName query;


    public JMXQueryCommand(int port, String host, String username, String password, ObjectName query) {
        this.port = port;
        this.host = host;
        this.username = username;
        this.password = password;
        this.query = query;
    }

    public Set<ObjectInstance> executeCommand() throws CommandException {
        try {
            String url = "service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi";
            JMXServiceURL jmxUrl = new JMXServiceURL(url);
            Map<String, String[]> jmxEnv = new HashMap<String, String[]>();
            String[] credentials = new String[]{username, password};
            jmxEnv.put(JMXConnector.CREDENTIALS, credentials);
            JMXConnector connector = JMXConnectorFactory.connect(jmxUrl, jmxEnv);
            MBeanServerConnection connection = connector.getMBeanServerConnection();
            return connection.queryMBeans(query, null);
        } catch (IOException e) {
            throw new CommandException(e);
        }

    }

    public abstract E execute() throws CommandException;

}
