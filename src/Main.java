import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //File file = new File("SampleData.txt");
        //File file = new File("ADVENT.txt");
        Scanner cin = null;

        FileReader file = null;
        try {

            //file = new FileReader("SampleData.txt");
            file = new FileReader("ADVENT.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(file);


/*
        try {
            cin = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        //sql.initialise();

     */
        SQLConnection sql = new SQLConnection();
        sql.createDatabase();

        String line;
        while ((line = br.readLine()) != null) {
            //System.out.println(line);
            sql.insertData(line);
        }

        /*
        while ( cin.hasNext() ){
            sql.insertData( cin.next() );
        }
        */


    }


}
