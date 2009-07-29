package org.pentaho.ui.database;

import java.util.List;

import org.pentaho.database.model.DatabaseConnectionPoolParameter;
import org.pentaho.database.model.IDatabaseConnection;
import org.pentaho.database.model.IDatabaseType;
import org.pentaho.database.service.IDatabaseConnectionService;
import org.pentaho.ui.database.services.IXulAsyncDatabaseConnectionService;
import org.pentaho.ui.xul.XulServiceCallback;

public class XulAsyncDatabaseConnectionService implements IXulAsyncDatabaseConnectionService {

  IDatabaseConnectionService service;
  
  public XulAsyncDatabaseConnectionService() {
  }
  
  public XulAsyncDatabaseConnectionService(IDatabaseConnectionService service) {
    this.service = service;
  }
  
  public void setDatabaseConnectionService(IDatabaseConnectionService service) {
    this.service = service;
  }
  
  public void checkParameters(IDatabaseConnection connection, XulServiceCallback<List<String>> callback) {
    callback.success(service.checkParameters(connection));
  }

  public void getPoolingParameters(XulServiceCallback<DatabaseConnectionPoolParameter[]> callback) {
    callback.success(service.getPoolingParameters());
  }

  public void testConnection(IDatabaseConnection connection, XulServiceCallback<String> callback) {
    callback.success(service.testConnection(connection));
  }

  public void getDatabaseTypes(XulServiceCallback<List<IDatabaseType>> callback) {
    callback.success(service.getDatabaseTypes());
  }

}
