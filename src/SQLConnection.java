import java.sql.*;

public class SQLConnection {

    public static Connection connection;
    private static boolean hasData = false;

    public ResultSet displayData() {

        if (connection == null) {
            getConnection();
        }

        //Implement the Return Here -->
        try {
            Statement state = connection.createStatement();
            ResultSet result = state.executeQuery("");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void getConnection() {

        try {

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:resource/database/ConsolidatedList.sqlite");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void createDatabase() {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:resource/database/ConsolidatedList.sqlite";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("A new database has been created");
                Statement state = conn.createStatement();
                state.executeQuery(" CREATE TABLE Consolidated_ApplicationList (  Security_ID  INT  NOT NULL ON CONFLICT IGNORE , AppNo CHAR NOT NULL ON CONFLICT IGNORE, Type CHAR  NOT NULL ON CONFLICT IGNORE )\n");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void initialise() {
    }

    public void insertData(String line){
        //line = line.replace("~", ", ");

        String[] qTest = line.split("~");
        //System.out.println(qTest[0]);
        //System.out.println(qTest[qTest.length - 1]);
        /*

        //replacing RB with RBD for proper formatting
        line = line.replace("RB", "RBD");
        StringBuilder str = new StringBuilder(line);

        //padding uneven length numbers

        if(str.length() < 37){
            //System.out.println("Error  !" + str.length()  + " "+ str);
            while (str.length() < 37) {
                str.insert(28, '0');
            }

        }

        //Adding " for String
        str.insert(18, '"');
        str.insert(22, '"');
        str.insert(36, '"');
        str.append('"');
*/
        String query = "INSERT INTO Consolidated_ApplicationList ( Security_ID, AppNo, Type) VALUES ( " + qTest[2]  + ", \"" + qTest[3] + "\"" + ", \"" + qTest[4] + "\"" + " )";
        //System.out.println(query);


        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection("jdbc:sqlite:resource/database/ConsolidatedList.sqlite");
            Statement state = connection.createStatement();
            state.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
