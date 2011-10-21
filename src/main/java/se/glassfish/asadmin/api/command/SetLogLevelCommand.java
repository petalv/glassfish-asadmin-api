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

import java.util.List;
import java.util.logging.Level;

public class SetLogLevelCommand extends RemoteCommand<Integer> {

    private String loggerName;
    private Level level;

    private List<String> loggerNames;

    public SetLogLevelCommand(GlassFishEnvironment environment, String loggerName, Level level) {
        super(environment);
        this.loggerName = loggerName;
        this.level = level;
    }

    public SetLogLevelCommand(GlassFishEnvironment environment, List<String> loggerNames, Level level) {
        super(environment);
        this.loggerNames = loggerNames;
        this.level = level;
    }

    @Override
    public String getCommandName() {
        return "set-log-level";
    }


    @Override
    public Integer execute() throws CommandException {
        if (loggerNames == null) {
            addArg(loggerName + "=" + level.getName());
        } else {
            StringBuilder builder = new StringBuilder();
            for (String logger : loggerNames) {
                builder.append(logger);
                builder.append("=");
                builder.append(level.getName());
                builder.append(":");
            }
            addArg(builder.toString());
        }
        return executeCommand().getReturnCode();
    }

}
