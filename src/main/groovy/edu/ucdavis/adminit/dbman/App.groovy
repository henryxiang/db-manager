package edu.ucdavis.adminit.dbman

import edu.ucdavis.adminit.dbman.datasource.DataSourceBuilderFactory

import javax.sql.DataSource

class App {
    static void main(String[] args) {
        def hostname = 'localhost'
        def database = 'hr'
        def schema = 'hr'
        def username = 'root'
        def password = 'mysql'
        def outputFileName = '/Users/henry/hr.xml'

        DataSource dataSource = DataSourceBuilderFactory
                .newInstance(DataSourceBuilderFactory.Type.mysql)
                .hostname(hostname)
                .database(database)
                .username(username)
                .password(password)
                .options("useSSL=false")
                .build()
        
        DatabaseManager databaseManager = new DatabaseManager(dataSource)
        databaseManager.createDatabaseModel(schema)
        databaseManager.listAllTables().each {println it}
        databaseManager.exportSchema(schema, outputFileName)

        println 'OK'
    }
}
