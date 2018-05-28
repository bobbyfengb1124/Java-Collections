package music.db.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.omg.CORBA.INTERNAL;

public class Datasource {

	public static final String DB_NAME = "music.db";

	public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\bobbyfeng\\Downloads\\music\\" + DB_NAME;

	public static final String TABLE_ALBUMS = "albums";
	public static final String COLUMN_ALBUM_ID = "_id";
	public static final String COLUMN_ALBUM_NAME = "name";
	public static final String COLUMN_ALBUM_ARTIST = "artist";
	public static final int INDEX_ALBUM_ID = 1;
	public static final int INDEX_ALBUM_NAME = 2;
	public static final int INDEX_ALBUM_ARTIST = 3;

	public static final String TABLE_ARTISTS = "artists";
	public static final String COLUMN_ARTIST_ID = "_id";
	public static final String COLUMN_ARTIST_NAME = "name";
	public static final int INDEX_ARTIST_ID = 1;
	public static final int INDEX_ARTIST_NAME = 2;

	public static final String TABLE_SONGS = "songs";
	public static final String COLUMN_SONG_ID = "_id";
	public static final String COLUMN_SONG_TRACK = "track";
	public static final String COLUMN_SONG_TITLE = "title";
	public static final String COLUMN_SONG_ALBUM = "album";
	public static final int INDEX_SONG_ID = 1;
	public static final int INDEX_SONG_TRACK = 2;
	public static final int INDEX_SONG_TITLE = 3;
	public static final int INDEX_SONG_ALBUM = 4;

	public static final int ORDER_BY_NONE = 1;
	public static final int ORDER_BY_ASC = 2;
	public static final int ORDER_BY_DESC = 3;

	private Connection connection;

	public boolean open() {
		try {
			connection = DriverManager.getConnection(CONNECTION_STRING);
			return true;
		} catch (SQLException e) {
			System.out.println("Couldn't connect to database: " + e.getMessage());
			return false;
		}
	}

	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("Couldn't close connection: " + e.getMessage());
		}
	}

	public List<Artist> queryArtists(int sortOrder) {

		StringBuilder stringBuilder= new StringBuilder("SELECT * from ");
		stringBuilder.append(TABLE_ARTISTS);
		if(sortOrder!=ORDER_BY_NONE) {
			stringBuilder.append(" ORDER BY ");
			stringBuilder.append(COLUMN_ARTIST_NAME);
			stringBuilder.append(" COLLATE NOCASE ");
			if(sortOrder == ORDER_BY_DESC) {
				stringBuilder.append("DESC");
			} else {
				stringBuilder.append("ASC");
			}
		}
		
		
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(stringBuilder.toString())) {

			List<Artist> artists = new ArrayList<>();
			while (resultSet.next()) {
				Artist artist = new Artist();
				artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
				artist.setName(resultSet.getString(INDEX_ARTIST_NAME));
				artists.add(artist);
			}

			return artists;
		} catch (SQLException e) {
			System.out.println("Query failed: " + e.getMessage());
			return null;
		}
	}
}
