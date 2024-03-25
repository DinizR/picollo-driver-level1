/*
* BackendSupplierInterface.java
 */
package org.picollo.backend.api;

import org.picollo.backend.model.EndPoint;
import org.picollo.driver.DriverInterface;

/**
 * Interface exposed to develop new drivers for backend synchronous connection using different protocols such as: SOAP, REST, CORBA, RMI-IIOP,  etc.
 * @author rod
 * @since 2018-08
 */
public interface BackendSupplierInterface extends DriverInterface {
//    String getBackendInterfaceName();
//    String getBackendInterfaceDescription();
    EndPoint[] getEndpoints();
}