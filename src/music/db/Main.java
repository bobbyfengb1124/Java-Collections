package music.db;


import java.util.List;

import music.db.model.Artist;
import music.db.model.Datasource;

public class Main {

	public static void main(String[] args) {

		Datasource dataSource = new Datasource();
		Datasource datasource = new Datasource();
		if(!datasource.open()) {
			System.out.println("Can't open datasource");
			return;
		}
		
		List<Artist> artists = datasource.queryArtists(5);
		if(artists == null) {
			System.out.println("No artists!");
			return;
		}
		
		for(Artist artist : artists) {
			System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
		}
		
		dataSource.close();
	}

}
