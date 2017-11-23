package edu.ucdavis.adminit.dbman.datasource

import javax.sql.DataSource

abstract class DataSourceBuilder {
    String hostname
    String port
    String database
    String username
    String password
    String options

    def hostname(hostname) {
        this.hostname = hostname
        return this
    }

    def port(port) {
        this.port = port
        return this
    }

    def database(database) {
        this.database = database
        return this
    }

    def username(username) {
        this.username = username
        return this
    }

    def password(password) {
        this.password = password
        return this
    }

    def options(options) {
        this.options = options
        return this
    }

    abstract DataSource build()
}
