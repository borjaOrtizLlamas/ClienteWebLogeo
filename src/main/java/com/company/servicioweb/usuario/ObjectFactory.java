
package com.company.servicioweb.usuario;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.company.servicioweb.usuario package. 
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

    private final static QName _Usuario_QNAME = new QName("http://com/company/servicioweb/usuario", "Usuario");
    private final static QName _RolesUsuario_QNAME = new QName("http://com/company/servicioweb/usuario", "roles_usuario");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.company.servicioweb.usuario
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link RolesUsuario }
     * 
     */
    public RolesUsuario createRolesUsuario() {
        return new RolesUsuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Usuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com/company/servicioweb/usuario", name = "Usuario")
    public JAXBElement<Usuario> createUsuario(Usuario value) {
        return new JAXBElement<Usuario>(_Usuario_QNAME, Usuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RolesUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com/company/servicioweb/usuario", name = "roles_usuario")
    public JAXBElement<RolesUsuario> createRolesUsuario(RolesUsuario value) {
        return new JAXBElement<RolesUsuario>(_RolesUsuario_QNAME, RolesUsuario.class, null, value);
    }

}
