/*
* WorkerSupplierInterface.java
 */
package org.cobra.worker.api;

import org.picollo.config.api.ConfigurableInterface;

import java.util.Map;

/**
 * Interface exposed to develop new drivers for workers, that are helper services shared with front-ends.
 * @author rod
 * @since 2018-08
 */
public interface WorkerSupplierInterface extends ConfigurableInterface {
    String call(Map<String, String> params) throws WorkerException;
    boolean checkParams(Map<String, String> params) throws IllegalArgumentException;
}