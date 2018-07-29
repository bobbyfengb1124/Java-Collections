package generic.challenge;

import generic.BaseballPlayer;
import generic.FootballPlayer;
import generic.Team;

public class Main {

	public static void main(String[] args) {

		Team<FootballPlayer> melbourne = new Team<>("Melbourne");
		Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
		Team<FootballPlayer> fremantle = new Team<>("Fremantle");
		Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
		
		Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
		
		League<Team<FootballPlayer>> fLeague = new League<Team<FootballPlayer>>("A") {
		};
		fLeague.addTeam(melbourne);
		fLeague.addTeam(hawthorn);
		fLeague.addTeam(fremantle);
		
		hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);

		fLeague.showLeagueTable();
	}

}
