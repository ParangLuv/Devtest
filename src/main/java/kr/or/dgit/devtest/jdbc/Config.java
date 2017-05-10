package kr.or.dgit.devtest.jdbc;

// DB 정보
public class Config {
    public static final String DB_NAME = "ncs_erp_";
    public static final String USER   = "root";
    public static final String PWD    = "rootroot";
    public static final String URL    = "jdbc:mysql://localhost:3306/";
    public static final String DRIVER = "com.mysql.jdbc.Driver";


    public static final String[] TABLE_NAME = {"title","employee", "department"};

    public static String Export_path = "";
    public static String Import_path = "";
    public static final String MYSQL_EXPORT_PATH = "C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\";

}
