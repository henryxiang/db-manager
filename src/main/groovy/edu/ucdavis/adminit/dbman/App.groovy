package edu.ucdavis.adminit.dbman

import org.apache.commons.dbcp.BasicDataSource

class App {
    static void main(String[] args) {
        def driverClassName = 'com.mysql.jdbc.Driver'
        def url = 'jdbc:mysql://localhost:3306/hr?useSSL=false'
        def username = 'root'
        def password = 'mysql'
        def schemaName = 'hr'
        def outputFileName = '/Users/henry/hr.xml'

        BasicDataSource dataSource = new BasicDataSource()
        dataSource.setDriverClassName(driverClassName)
        dataSource.setUrl(url)
        dataSource.setUsername(username)
        dataSource.setPassword(password)
        
        DatabaseManager databaseManager = new DatabaseManager(dataSource)
        databaseManager.extractSchema(schemaName, outputFileName)

        println 'OK'
    }
}
