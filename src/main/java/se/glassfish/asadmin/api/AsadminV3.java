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

public class AsadminV3 extends Asadmin {

    public AsadminV3(String glassFishHome) {
        super(glassFishHome);
    }

    public AsadminV3(String glassFishHome, String adminUsername, String adminPassword, String masterAdminPassword) {
        super(glassFishHome, adminUsername, adminPassword, masterAdminPassword);
    }

    public AsadminV3(String adminUsername, String adminPassword, String masterAdminPassword, String glassFishHome, String host, int port) {
        super(adminUsername, adminPassword, masterAdminPassword, glassFishHome, host, port);
    }

    public AsadminV3(String glassFishHome, int port, boolean useLocalAuth, boolean verbose) {
        super(glassFishHome, port, useLocalAuth, verbose);
    }
}
