package edu.ucdavis.adminit.dbman.datasource

import org.apache.commons.dbcp.BasicDataSource

import javax.sql.DataSource

class MySqlDataSourceBuilder extends DataSourceBuilder {
    final String driverClassName = com.mysql.jdbc.Driver.canonicalName
    final String urlFormat = 'jdbc:mysql://%s:%s/%s'

    MySqlDataSourceBuilder() {
        super()
        port = '3306'
    }

    @Override
    DataSource build() {
        BasicDataSource dataSource = new BasicDataSource()
        dataSource.setDriverClassName(driverClassName)
        if (hostname && database && username && password) {
            def url = String.format(urlFormat, hostname, port, database)
            if (options) url = url + "?${options}"
            dataSource.setUrl(url)
            dataSource.setUsername(username)
            dataSource.setPassword(password)
        }
        return dataSource
    }
}
