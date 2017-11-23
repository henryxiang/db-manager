package edu.ucdavis.adminit.dbman

import org.apache.ddlutils.Platform
import org.apache.ddlutils.PlatformFactory
import org.apache.ddlutils.io.DatabaseIO
import org.apache.ddlutils.model.Database

import javax.sql.DataSource

class DatabaseManager {
    DataSource dataSource
    Database databaseModel

    DatabaseManager() {}

    DatabaseManager(DataSource dataSource) {
        this.dataSource = dataSource
    }

    void createDatabaseModel(String schema) {
         databaseModel = PlatformFactory
            .createNewPlatformInstance(dataSource)
            .readModelFromDatabase(schema)
    }

    void exportSchema(String schema, String outputFileName) {
        createDatabaseModel(schema)
        new DatabaseIO().write(databaseModel, outputFileName)
    }

    void importSchema(String inputFileName) {
        databaseModel = new DatabaseIO().read(inputFileName)
    }

    void changeDatabase(boolean alterTables) {
        Platform platform = PlatformFactory.createNewPlatformInstance(dataSource)
        if (alterTables) {
            platform.alterTables(databaseModel, alterTables)
        } else {
            platform.createTables(databaseModel, true, false)
        }
    }

    List<String> listAllTables() {
        return databaseModel
                .getTables()
                .collect {table -> table.name}
    }
}
