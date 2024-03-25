package org.picollo.jdbc.pool;

import org.picollo.config.api.AbstractConfigurableInterface;
import org.picollo.config.api.ConfigurationException;

public abstract class AbstractJdbcSupplierInterface extends AbstractConfigurableInterface implements JdbcSupplierInterface {
   public AbstractJdbcSupplierInterface() throws ConfigurationException {
   }
}
