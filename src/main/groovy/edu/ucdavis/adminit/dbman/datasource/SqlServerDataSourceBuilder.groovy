package edu.ucdavis.adminit.dbman.datasource

import org.apache.commons.dbcp.BasicDataSource

import javax.sql.DataSource

class SqlServerDataSourceBuilder extends DataSourceBuilder {
    final String driverClassName = net.sourceforge.jtds.jdbc.Driver.canonicalName
    final String urlFormat = 'jdbc:jtds:sqlserver://%s:%s/%s'

    SqlServerDataSourceBuilder() {
        super()
        port = '1433'
    }

    @Override
    DataSource build() {
        BasicDataSource dataSource = new BasicDataSource()
        dataSource.setDriverClassName(driverClassName)
        if (hostname && database && username && password) {
            def url = String.format(urlFormat, hostname, port, database)
            if (options) url = url + ";${options}"
            dataSource.setUrl(url)
            dataSource.setUsername(username)
            dataSource.setPassword(password)
        }
        return dataSource
    }
}
