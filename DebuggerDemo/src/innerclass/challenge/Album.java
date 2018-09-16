package innerclass.challenge;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private SongList songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new SongList("Hehe");
	}

	public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
		Song checkedSong = this.songs.findSong(trackNumber);
		if(checkedSong != null) {
			playList.add(checkedSong);
			return true;
		}
		
		System.out.println("This album does not have a track " + trackNumber);
		return false;
	}

	public boolean addToPlayList(String title, LinkedList<Song> playList) {
		Song checkedSong = songs.findSong(title);
		if (checkedSong != null) {
			playList.add(checkedSong);
			return true;
		}
		System.out.println("The song " + title + " is not in this album");
		return false;
	}

	private class SongList {
		private String name;
		private ArrayList<Song> songList;
		
		public SongList(String name) {
			this.name = name;
			songList = new ArrayList<>();
		}

		public Song get(int index) {
			return songList.get(index);
		}

		public int size() {
			return songList.size();
		}

		public boolean addSong(String title, double duration) {
			if (findSong(title) == null) {
				this.songList.add(new Song(title, duration));
				return true;
			}
			return false;
		}
		
		private Song findSong(String title) {
			for (Song checkedSong : this.songList) {
				if (checkedSong.getTitle().equals(title)) {
					return checkedSong;
				}
			}
			return null;
		}
		
		private Song findSong(int trackNumber) {
			int index = trackNumber -1;
			if((index >0) && (index<songs.size())) {
				return songs.get(index);
			}
			return null;
		}
		
	}

	public boolean addSong(String string, double d) {
		return songs.addSong(string, d);
	}
}
