import java.sql.*;
//pozwala na interakcje z aplikacją - wprowadzanie danych, np. która opcje wybiera użytkownik, prezentacje rezultatow)
public class Database {
    private Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/movies";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Joanna8673";
    private static final String CREATE_MOVIES_TABLE_SQL = """
                       CREATE TABLE IF NOT EXISTS movies (
                       id int AUTO_INCREMENT PRIMARY KEY,
                       title varchar(255) NOT NULL,
                       premiere_year int NOT NULL,
                        genre varchar(255) NOT NULL,
                       rate int
                       );""";


    private static final String INSERT_MOVIE_SQL = "INSERT INTO movies VALUES (0,?,?,?,?);";
    private static final String SELECT_ALL_MOVIES_SQL = "SELECT * FROM movies;";

    public Database() {
        try {
            initConnection();
            initTable();
        } catch (SQLException e) {
            System.out.println("Wysypała się baza danych :(");
        }
    }

    private void initConnection() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    private void initTable() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(CREATE_MOVIES_TABLE_SQL);
        statement.execute();
    }

    public void save(Movie movie) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_MOVIE_SQL);
        statement.setString(1, movie.getTitle());
        statement.setInt(2, movie.getPremiereYear());
        statement.setString(3, movie.getGenre());
        statement.setInt(4, movie.getRate());
        statement.execute();
    }

    public void showMovies() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_MOVIES_SQL);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("title") + " - " +
                    resultSet.getInt("premiere_year") + " - " +
                    resultSet.getString("genre") + " - " +
                    resultSet.getInt("rate"));
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Błąd przy zamykaniu połączenia z BD");
        }
    }
}

