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

import java.util.ArrayList;
import java.util.List;

public class ListComponentsCommand extends RemoteCommand<List<Component>> {

    private ComponentType type;
    private String target;

    public ListComponentsCommand(GlassFishEnvironment environment, String target) {
        super(environment);
        this.target = target;
    }

    public ListComponentsCommand(GlassFishEnvironment environment, String target, ComponentType type) {
        super(environment);
        this.target = target;
        this.type = type;
    }

    public String getCommandName() {
        return "list-components";
    }


    public List<Component> execute() throws CommandException {
        addArg(target);
        if (type != null) {
            addParam("type", type.getName());
        }
        CommandResult commandResult = executeCommand();
        List<Component> result = new ArrayList<Component>();
        List<String> components = commandResult.getOutput();
        for (String component : components) {
            int index = component.indexOf(" ");
            String name = component.substring(0, index);
            String type = component.substring(index + 1, component.length()).trim();
            result.add(new Component(name, parseComponent(type)));
        }

        return result;
    }

    private ComponentType parseComponent(String type) {
        if (type.equals("<web-module>")) {
            return ComponentType.WEB_MODULE;
        }
        if (type.equals("<connector-module>")) {
            return ComponentType.CONNECTOR_MODULE;
        }
        if (type.equals("<j2ee-application>")) {
            return ComponentType.APPLICATION_MODULE;
        }
        if (type.equals("<extension-module>")) {
            return ComponentType.EXTENSION_MODULE;
        }
        if (type.equals("<webservice>")) {
            return ComponentType.WEBSERVICE_MODULE;
        }
        return ComponentType.UNKNOWN_MODULE;
    }
}