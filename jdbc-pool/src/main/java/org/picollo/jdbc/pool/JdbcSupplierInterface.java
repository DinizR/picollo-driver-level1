package org.picollo.jdbc.pool;

import org.picollo.config.api.ConfigurableInterface;

import java.sql.Connection;
import java.sql.SQLException;

public interface JdbcSupplierInterface extends ConfigurableInterface {
   Connection getConnection() throws SQLException;
}
