import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File file = new File("SampleData.txt");
        //File file = new File("ADVENT.txt");
        Scanner cin = null;

        try {
            cin = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SQLConnection sql = new SQLConnection();

        //sql.initialise();
        sql.createDatabase();
        while ( cin.hasNext() ){
            sql.insertData( cin.next() );
        }

    }


}
