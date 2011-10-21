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

import se.glassfish.asadmin.api.Asadmin;
import se.glassfish.asadmin.api.Version;

public class Tester {

    public static void main(String[] args) throws Exception {

        Asadmin gf = new Asadmin("/Users/patbos/glassfishv3", 16048, false, true, Version.V3);
        //gf.deleteDomain("custarddomain");
        //gf.createDomain("custarddomain", 16000, true, true, "developer");
        //gf.startDomain("custarddomain");
        gf.createDomain("custard4domain", 16100, true, true, "developer");
        //gf.deleteJvmOptions("-client");
        //gf.createJvmOptions("-XX:MaxPermSize=128m", "-server");
    }
}
