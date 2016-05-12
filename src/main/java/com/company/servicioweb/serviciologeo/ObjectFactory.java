
package com.company.servicioweb.serviciologeo;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.company.servicioweb.serviciologeo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.company.servicioweb.serviciologeo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RolesRequest }
     * 
     */
    public RolesRequest createRolesRequest() {
        return new RolesRequest();
    }

    /**
     * Create an instance of {@link LogeoResponse }
     * 
     */
    public LogeoResponse createLogeoResponse() {
        return new LogeoResponse();
    }

    /**
     * Create an instance of {@link RolesResponse }
     * 
     */
    public RolesResponse createRolesResponse() {
        return new RolesResponse();
    }

    /**
     * Create an instance of {@link LogeoRequest }
     * 
     */
    public LogeoRequest createLogeoRequest() {
        return new LogeoRequest();
    }

}
