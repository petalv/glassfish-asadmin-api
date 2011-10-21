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

public enum Module {


    ADMIN("admin"),
    CLASSLOADER("classloader"),
    CMP("cmp"),
    CMP_CONTAINER("cmp-container"),
    CONFIGURATION("configuration"),
    CONNECTOR("connector"),
    CORBA("corba"),
    DEPLOYMENT("deployment"),
    EJB_CONTAINER("ejb-container"),
    GMS("group-management-service"),
    MAIL("javamail"),
    JAXR("jaxr"),
    JAXRPC("jaxrpc"),
    JDO("jdo"),
    JMS("jms"),
    JTA("jta"),
    JTS("jts"),
    MANAGEMENT_EVENT("management-event"),
    MBD_CONTAINER("mdb-container"),
    NAMING("naming"),
    NODE_AGENY("node-agent"),
    RESOURCE_ADAPTER("resource-adapter"),
    ROOT("root"),
    SAAJ("saaj"),
    SECURITY("security"),
    SELF_MANAGEMENT("self-management"),
    SERVER("server"),
    SYNCHRONIZATION("synchronization"),
    UTIL("util"),
    VERIFIER("verifier"),
    WEB_CONTAINER("web-container");


    private final String type;

    Module(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
