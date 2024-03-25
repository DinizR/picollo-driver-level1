/*
* AbstractWorkerSupplierInterface.java
 */
package org.cobra.worker.api;

import org.picollo.config.api.AbstractConfigurableInterface;
import org.picollo.config.api.ConfigurationException;

/**
 * Abstract class with high level implementation for WorkerSupplierInterface and AbstractConfigurableInterface.
 * @author rod
 * @since 2018-11
 */
public abstract class AbstractWorkerSupplierInterface extends AbstractConfigurableInterface implements WorkerSupplierInterface {

    public AbstractWorkerSupplierInterface() throws ConfigurationException {
    }
}