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


public class SetModuleLogLevelCommand extends SetCommand {

    public SetModuleLogLevelCommand(GlassFishEnvironment enviroment, String target, Monitor monitor, MonitorLevel level) {
/*        configs.config.server-config.monitoring-service.module-monitoring-levels.connector-connection-pool=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.connector-service=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.ejb-container=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.http-service=HIGH
        configs.config.server-config.monitoring-service.module-monitoring-levels.jdbc-connection-pool=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.jersey=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.jms-service=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.jpa=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.jvm=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.orb=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.security=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.thread-pool=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.transaction-service=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.web-container=OFF
        configs.config.server-config.monitoring-service.module-monitoring-levels.web-services-container=OFF
*/
        super(enviroment, target + ".monitoring-service.module-monitoring-levels." + monitor.getType(), level.getLevel());
    }
}
