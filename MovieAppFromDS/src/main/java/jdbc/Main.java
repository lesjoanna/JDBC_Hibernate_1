package jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "Joanna8673");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "Joanna8673");


        String createTableSql = """
        CREATE TABLE books (
        id int,
        title VARCHAR(255) NOT NULL,
        author VARCHAR(255) NOT NULL,
        pages int NOT NULL
                       
                       
        );
                       
                       
        """;

        Book book = new Book("Ubik", "Philip Dick", 250);
        Statement statement = connection.createStatement();
        //formatowany String - patrz reminder
        String insertBookSql = String.format(" INSERT INTO books VALUES (0,'%s','%s',%d);",
                book.getTitle(), book.getAuthor(), book.getPages());

        System.out.println(insertBookSql);
        statement.execute(insertBookSql);


        // update

        String updateBookSql = """
        UPDATE books
        SET author='Philip K.Dick'
        WHERE title='Ubik'
        """;

    //statement.execute(updateBook);

    //Read
        String selectAllSql = "SELECT * FROM books ";

        ResultSet resultSet = statement.executeQuery(selectAllSql);
      while  ( resultSet.next()) {
       int id = resultSet.getInt("id");
       String title = resultSet.getString("title");
      //  System.out.println(id);
        String author = resultSet.getString("author");
      //  System.out.println(author);
        int pages = resultSet.getInt("pages");
      //  System.out.println(pages);

          Book dbBook = new Book(id, title, author, pages);
          System.out.println(dbBook);
    }}}



//Baza danych:
//SQL /NoSQL (np. MongoDB)

//1, Samodzielny SQL
//2. JDBC - java wysyła zapytania SQL
    //zainstalowana i odpalona baza
    //sterownik (maven)
    //

//3. Hibernate - zapisujemy OBIEKTY w bazie danych (ORM)
//4. Spring JPA - sutomatyzacja pracy z Hibernate przy Spring
