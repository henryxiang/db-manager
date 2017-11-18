package edu.ucdavis.adminit.dbman;

import org.apache.commons.dbcp.BasicDataSource;

public class App {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hr?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("mysql");
        String schemaName = "hr";
        String outputFileName = "/Users/henry/hr.xml";

        DatabaseManager databaseManager = new DatabaseManager(dataSource);
        databaseManager.extractSchema(schemaName, outputFileName);

//        Platform platform = PlatformFactory.createNewPlatformInstance(dataSource);
//        Database database = platform.readModelFromDatabase("hr");
//        new DatabaseIO().write(database, "/Users/henry/hr.xml");
//        String sql = "select dept_no, dept_name from departments";
//        List<DynaBean> depts = platform.fetch(database, sql);
//        for (DynaBean dept : depts) {
//            System.out.println(String.format("%s %s", dept.get("dept_no"), dept.get("dept_name")));
//        }
        System.out.println("ok");
    }
}
