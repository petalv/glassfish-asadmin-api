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

import java.io.File;
import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class ListJvmOptionsCommand extends AbstractGetCommand<List<String>> {

    public ListJvmOptionsCommand(GlassFishEnvironment environment) {
        super(environment, "server.java-config.jvm-options");
    }

    public ListJvmOptionsCommand(GlassFishEnvironment environment, String target) {
        super(environment, target + ".java-config.jvm-options");
    }

    public List<String> execute() throws CommandException {
        String result = get();
        String[] options = result.split(",-");
        List<String> list = new ArrayList<String>();

        for (String option : options) {
            if (option.startsWith("-")) {
                list.add(option);
            } else {
                list.add("-" + option);
            }
        }

        return list;
    }
}
