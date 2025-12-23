package com.library.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DBinit {
    private static final String URL = "jdbc:sqlite:library.db";
    public static void createTable() {

        String sql = """
            CREATE TABLE IF NOT EXISTS books (
                id TEXT PRIMARY KEY,
                title TEXT NOT NULL,
                author TEXT NOT NULL
            );
        """;

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Books table ready!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
