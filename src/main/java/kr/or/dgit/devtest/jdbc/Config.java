package kr.or.dgit.devtest.jdbc;

/**
 * Created by DGIT on 2017-05-10.
 */
public class Config {
    public static final String DB_NAME = "devtest";
    public static final String USER   = "user_ncs";
    public static final String PWD    = "user_ncs";
    public static final String URL    = "jdbc:mysql://localhost:3306/"+DB_NAME;
    public static final String DRIVER = "com.mysql.jdbc.Driver";


    public static final String[] TABLE_NAME = {"title","employee", "department"};

    public static String Export_path = "";
    public static String Import_path = "";
    public static final String MYSQL_EXPORT_PATH = "C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\";

}
