package application;

import application.model.Album;
import application.model.Artist;
import application.model.Datasource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;

public class Controller {
	
	@FXML
	private TableView artistTable;
	
	@FXML
	private ProgressBar progressBar;
	
	@FXML
	public void listArtists() {
		Task<ObservableList<Artist>> task = new GetAllArtistTask();
		artistTable.itemsProperty().bind(task.valueProperty());
		progressBar.progressProperty().bind(task.progressProperty());
		
		progressBar.setVisible(true);
		task.setOnSucceeded(EventHandler -> progressBar.setVisible(false));
		
		new Thread(task).start();
	}
	
	@FXML
	public void listAlbumsForArtist() {
		final Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();
		if(artist == null) {
			System.out.println("NO ARTIST SELECTED");
			return;
		}
		Task<ObservableList<Album>> task = new Task<ObservableList<Album>>() {

			@Override
			protected ObservableList<Album> call() throws Exception {
				return FXCollections.observableArrayList(Datasource.getInstance().queryAlbumsForArtistId(artist.getId()));
			}
		};
		
		artistTable.itemsProperty().bind(task.valueProperty());
		new Thread(task).start();
		
	}
	@FXML
	public void updateArtist() {
		final Artist artitst = (Artist) artistTable.getItems().get(2);
		
		Task<Boolean> task = new Task<Boolean>() {

			@Override
			protected Boolean call() throws Exception {
				return Datasource.getInstance().updateArtistName(artitst.getId(), "AC/DC");
			}
			
		};
		
		task.setOnSucceeded(e -> {
			if(task.valueProperty().get()) {
				artitst.setName("AC/DC");
				artistTable.refresh();
			}
		});
		
		new Thread(task).start();
	}
}

class GetAllArtistTask extends Task {

	@Override
	protected Object call() throws Exception {
		
		return FXCollections.observableArrayList(Datasource.getInstance().queryArtists(Datasource.ORDER_BY_ASC));
	}}
