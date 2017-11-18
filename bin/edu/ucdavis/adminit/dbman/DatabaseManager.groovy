package edu.ucdavis.adminit.dbman

import org.apache.ddlutils.PlatformFactory
import org.apache.ddlutils.io.DatabaseIO
import org.apache.ddlutils.model.Database

import javax.sql.DataSource

class DatabaseManager {
    DataSource dataSource

    DatabaseManager(DataSource dataSource) {
        this.dataSource = dataSource
    }

    Database getDatabaseModel(String schema) {
         PlatformFactory
            .createNewPlatformInstance(dataSource)
            .readModelFromDatabase(schema)
    }

    void extractSchema(String schema, String outputFileName) {
        new DatabaseIO().write(getDatabaseModel(schema), outputFileName)
    }
}
