package org.picollo.resource;

import org.picollo.config.api.AbstractConfigurableInterface;
import org.picollo.config.api.ConfigurationException;
import org.picollo.resource.model.PicolloHttpRequest;
import org.springframework.http.ResponseEntity;

public abstract class AbstractResourceSupplierInterface extends AbstractConfigurableInterface implements ResourceSupplierInterface {
    public AbstractResourceSupplierInterface() throws ConfigurationException {
    }

    @Override
    public ResponseEntity handleGetAll(PicolloHttpRequest httpRequest) {
        return null;
    }

    @Override
    public ResponseEntity handleGetOne(PicolloHttpRequest httpRequest) {
        return null;
    }

    @Override
    public ResponseEntity handleGetOneRelated(PicolloHttpRequest httpRequest) {
        return null;
    }

    @Override
    public ResponseEntity handleGetAllRelated(PicolloHttpRequest httpRequest) {
        return null;
    }

    @Override
    public ResponseEntity handlePost(PicolloHttpRequest httpRequest) {
        return null;
    }

    @Override
    public ResponseEntity handlePut(PicolloHttpRequest httpRequest) {
        return null;
    }

    @Override
    public ResponseEntity handleDelete(PicolloHttpRequest httpRequest) {
        return null;
    }
}