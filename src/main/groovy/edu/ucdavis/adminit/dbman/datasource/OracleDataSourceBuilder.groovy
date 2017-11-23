package edu.ucdavis.adminit.dbman.datasource

import org.apache.commons.dbcp.BasicDataSource

import javax.sql.DataSource

class OracleDataSourceBuilder extends DataSourceBuilder {
    final String driverClassName = oracle.jdbc.driver.OracleDriver.canonicalName
    final String urlFormat = 'jdbc:oracle:thin:@%s:%s:%s'

    OracleDataSourceBuilder() {
        super()
        port = '1521'
    }

    @Override
    DataSource build() {
        BasicDataSource dataSource = new BasicDataSource()
        dataSource.setDriverClassName(driverClassName)
        if (hostname && database && username && password) {
            def url = String.format(urlFormat, hostname, port, database)
            dataSource.setUrl(url)
            dataSource.setUsername(username)
            dataSource.setPassword(password)
        }
        return dataSource
    }
}
