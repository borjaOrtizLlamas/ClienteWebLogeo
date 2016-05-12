
package com.company.servicioweb.serviciologeo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuarioValido" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "usuarioValido"
})
@XmlRootElement(name = "LogeoResponse")
public class LogeoResponse {

    protected boolean usuarioValido;

    /**
     * Gets the value of the usuarioValido property.
     * 
     */
    public boolean isUsuarioValido() {
        return usuarioValido;
    }

    /**
     * Sets the value of the usuarioValido property.
     * 
     */
    public void setUsuarioValido(boolean value) {
        this.usuarioValido = value;
    }

}
