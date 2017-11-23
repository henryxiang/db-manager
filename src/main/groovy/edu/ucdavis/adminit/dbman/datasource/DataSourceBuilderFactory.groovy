package edu.ucdavis.adminit.dbman.datasource

class DataSourceBuilderFactory {
    static final enum Type {
        oracle, mysql, sqlserver
    }
    static DataSourceBuilder newInstance(DataSourceBuilderFactory.Type databaseType) {
        DataSourceBuilder builder
        switch (databaseType) {
            case Type.oracle:
                builder = new OracleDataSourceBuilder()
                break
            case Type.mysql:
                builder = new MySqlDataSourceBuilder()
                break
            case Type.sqlserver:
                builder = new SqlServerDataSourceBuilder()
                break
        }
        return builder
    }
}
