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

public class CreateThreadPoolCommand extends RemoteCommand<Integer> {


    private int maxsize;
    private int minsize;
    private int idletimout;
    private int workqueues;
    private String threadpool_id;

    public CreateThreadPoolCommand(GlassFishEnvironment environment, int maxsize, int minsize, int idletimout, int workqueues, String threadpool_id) {
        super(environment);
        this.maxsize = maxsize;
        this.minsize = minsize;
        this.idletimout = idletimout;
        this.workqueues = workqueues;
        this.threadpool_id = threadpool_id;
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    public int getMinsize() {
        return minsize;
    }

    public void setMinsize(int minsize) {
        this.minsize = minsize;
    }

    public int getIdletimout() {
        return idletimout;
    }

    public void setIdletimout(int idletimout) {
        this.idletimout = idletimout;
    }

    public int getWorkqueues() {
        return workqueues;
    }

    public void setWorkqueues(int workqueues) {
        this.workqueues = workqueues;
    }

    public String getThreadpool_id() {
        return threadpool_id;
    }

    public void setThreadpool_id(String threadpool_id) {
        this.threadpool_id = threadpool_id;
    }

    public String getCommandName() {
        return "create-threadpool";
    }

/*
Usage: create-threadpool [--terse=false] [--echo=false] [--interactive=true] [--host localhost]
[--port 4848|4849] [--secure | -s] [--user admin_user] [--passwordfile file_name]
[--maxthreadpoolsize max_thread_pool_size] [--minthreadpoolsize min_thread_pool_size]
[--idletimeout idle_thread_timeout_in_seconds] [--workqueues number_work_queues]
[--target target(Default server)] threadpool_id
*/


    public Integer execute() throws CommandException {
        addParam("maxthreadpoolsize", maxsize);
        addParam("minthreadpoolsize", minsize);
        addParam("idletimeout", idletimout);
        addParam("workqueues", workqueues);
        addArg(threadpool_id);
        return executeCommand().getReturnCode();
    }
}
