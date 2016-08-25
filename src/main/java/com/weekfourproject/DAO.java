package com.weekfourproject;

import java.sql.*;
import java.util.ArrayList;

public class DAO {

	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;

	public static void connToDB() {

		try {
			System.out.println("Trying to connect to database..");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to database.");
		} catch (SQLException e) {
			System.out.println("Failed to connect to database.");
			e.printStackTrace();
		}

	}

	public static void readFromDB() {

		connToDB();
		ArrayList<Movie> ourMovies = new ArrayList<>();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM movies.movies;");

			while (RES_SET.next()) {

				Movie movieInDB = new Movie();

				movieInDB.setMovieID(RES_SET.getString("movie_id"));
				movieInDB.setMovieTitle(RES_SET.getString("title"));
				movieInDB.setMovieRating(RES_SET.getString("rating"));
				movieInDB.setMovieGenre(RES_SET.getString("genre"));
				movieInDB.setMovieLength(RES_SET.getInt("length"));

				ourMovies.add(movieInDB);
			}

			for (Movie movie : ourMovies) {
				System.out.println(movie.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
