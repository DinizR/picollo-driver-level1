/*
* ResourceSupplierInterface.java
 */
package org.picollo.resource;

import org.picollo.config.api.ConfigurableInterface;
import org.picollo.resource.model.PicolloHttpRequest;
import org.springframework.http.ResponseEntity;

/**
 * Interface exposed to develop new drivers for REST resources.
 * @author rod
 * @since 2019-03
 */
public interface ResourceSupplierInterface<T> extends ConfigurableInterface {
    ResponseEntity<T> handleGetAll(final PicolloHttpRequest httpRequest);
    ResponseEntity<T> handleGetOne(final PicolloHttpRequest httpRequest);
    ResponseEntity<T> handleGetOneRelated(final PicolloHttpRequest httpRequest);
    ResponseEntity<T> handleGetAllRelated(final PicolloHttpRequest httpRequest);
    ResponseEntity<T> handlePost(final PicolloHttpRequest httpRequest);
    ResponseEntity<T> handlePut(final PicolloHttpRequest httpRequest);
    ResponseEntity<T> handleDelete(final PicolloHttpRequest httpRequest);
}