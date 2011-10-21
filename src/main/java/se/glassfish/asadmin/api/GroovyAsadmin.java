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

package se.glassfish.asadmin.api;

import groovy.lang.GroovyObjectSupport;
import se.glassfish.asadmin.api.command.GroovyCommand;

import java.util.Map;
import java.util.Set;


public class GroovyAsadmin extends GroovyObjectSupport {

    private static final String DEFAULT_ADMIN_USERNAME = "admin";
    private static final String DEFAULT_ADMIN_PASSWORD = "adminadmin";
    private static final String DEFAULT_MASTER_PASSWORD = "changeit";
    private static final String DEFAULT_HOSTNAME = "localhost";
    private static final int DEFAULT_PORT = 4848;

    protected GlassFishEnvironment environment;

    public GroovyAsadmin(String glassFishHome) {
        environment = new GlassFishEnvironment(DEFAULT_ADMIN_USERNAME, DEFAULT_ADMIN_PASSWORD, DEFAULT_MASTER_PASSWORD, glassFishHome, true, DEFAULT_HOSTNAME, DEFAULT_PORT);
    }

    public GroovyAsadmin(String glassFishHome, String adminUsername, String adminPassword, String masterAdminPassword) {
        environment = new GlassFishEnvironment(adminUsername, adminPassword, masterAdminPassword, glassFishHome);
    }

    public GroovyAsadmin(String adminUsername, String adminPassword, String masterAdminPassword, String glassFishHome, String host, int port) {
        environment = new GlassFishEnvironment(adminUsername, adminPassword, masterAdminPassword, glassFishHome, true, host, port);
    }

    public GroovyAsadmin(String glassFishHome, int port, boolean useLocalAuth, boolean verbose) {
        environment = new GlassFishEnvironment(glassFishHome, useLocalAuth, port, verbose);
    }


    @Override
    public Object invokeMethod(String name, Object argsList) {

        System.out.println(name);

        Object[] args = (Object[]) argsList;

        Map params = (Map) args[0];
        String arg = (String) args[1];

        GroovyCommand command = new GroovyCommand(environment, name.replace('_', '-'));

        Set keys = params.keySet();
        for (Object key : keys) {
            Object value = params.get(key);
            command.addParam(key.toString(), value);
        }

        command.addArg(arg);

        try {
            command.execute();
        } catch (CommandException e) {
            e.printStackTrace();
            return null;
        }

        return null;


    }
}
