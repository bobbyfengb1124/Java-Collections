package generic.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import generic.Player;
import generic.Team;

public abstract class League<T extends Team> {
	private String name;
	private List<T> teams = new ArrayList<T>();

	public League(String name) {
		this.name = name;
	}

	public boolean addTeam(T team) {
		if (team != null && !teams.contains(team)) {
			teams.add(team);
			System.out.println((team).getName() + " picked for team " + this.name);
			return true;
		}
		else {
			System.out.println((team).getName() + " is already on this team");
			return false;
		}
	}
	
	public void showLeagueTable() {

		Collections.sort(teams);
		for (T team : teams) {
			System.out.println(team.getName() + ": " + team.ranking() );
		}
	}
	

}
