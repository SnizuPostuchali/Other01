package jdbc.exec;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Scanner;

public class ExecSQL {
    public static void main(String[] args)
            throws IOException
    {
        try(Scanner in =
//                    args.length==0
//                ? new Scanner(System.in) :
                new Scanner(Paths.get("K:\\java_projects\\IdeaProjects\\japaneseDictionaryMinnaNoNihonGo\\Test1.txt"), StandardCharsets.UTF_8)){
            try(Connection connection =
                        DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jap_dic", "dictionary", "dictionary");
                        Statement stat = connection.createStatement())
            {
                while (true){
                    if(args.length==0){
                        System.out.println("Enter command or EXIT to exit: ");
                    }
                    if(!in.hasNextLine())  return;

                    String line = in.nextLine().trim();
                    if(line.equalsIgnoreCase("EXIT"))  return;
//                    if(line.endsWith(";")){
//                        line = line.substring(0, line.length()-1);
//                    }

                    try{
                       boolean isResult = stat.execute(line);
                       if(isResult){
                           try(ResultSet rs = stat.getResultSet())
                           {
                               showResultSet(rs);
                           }
                       } else {
                           int updateCount = stat.getUpdateCount();
                           System.out.println(updateCount + " rows updated");
                       }
                    } catch (SQLException e) {
                        for(Throwable t: e){
                            t.printStackTrace();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            for(Throwable t: e){
                t.printStackTrace();
            }
        }
    }

    public static void showResultSet(ResultSet result)
            throws SQLException
    {
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();

        for(int i=1; i<=columnCount; i++){
            if(i>1){
                System.out.print(", ");
            }
            System.out.print(metaData.getColumnLabel(i));
        }
        System.out.println();

        while (result.next()){
            for(int i=1; i<=columnCount; i++){
                if(i>1){
                    System.out.print(", ");
                }
                System.out.print(result.getString(i));
            }
            System.out.println();
        }
    }
}
