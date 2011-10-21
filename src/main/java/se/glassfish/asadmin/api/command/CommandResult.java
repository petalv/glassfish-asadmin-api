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

import java.util.List;

public class CommandResult {

    private Integer returnCode;
    private List<String> output;
    private List<String> errors;

    public CommandResult(Integer returnCode, List<String> output, List<String> errors) {
        this.returnCode = returnCode;
        this.output = output;
        this.errors = errors;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public List<String> getOutput() {
        return output;
    }

    public List<String> getErrors() {
        return errors;
    }
}
