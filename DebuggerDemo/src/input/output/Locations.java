package input.output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
	private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

	public static void main(String[] args) throws IOException {

		try (BufferedWriter locwriter = new BufferedWriter(new FileWriter("locations.txt"));
				BufferedWriter dirwriter = new BufferedWriter(new FileWriter("directions.txt"))) {
			for (Location location : locations.values()) {

				locwriter.write(location.getLocationID() + "," + location.getDescription() + "\r\n");
				for (String direction : location.getExits().keySet()) {
					if (!direction.equalsIgnoreCase("Q")) {
						dirwriter.write(location.getLocationID() + "," + direction + ","
								+ location.getExits().get(direction) + "\n");
					}
				}
			}
		}
	}

	static {
		try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {

			scanner.useDelimiter(",");
			while (scanner.hasNextLine()) {
				int loc = scanner.nextInt();
				scanner.skip(scanner.delimiter());
				String description = scanner.nextLine();
				System.out.println("Imported loc: " + loc + ": " + description);
				Map<String, Integer> tempExit = new HashMap<>();
				locations.put(loc, new Location(loc, description, tempExit));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Now read the exits
		try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")))) {

			scanner.useDelimiter(",");
			while (scanner.hasNextLine()) {
				String input = scanner.nextLine();
				String[] data = input.split(",");
				int loc = Integer.parseInt(data[0]);
				String direction = data[1];
				int destination = Integer.parseInt(data[2]);

				System.out.println(loc + ": " + direction + ": " + destination);
				Location location = locations.get(loc);
				location.addExit(direction, destination);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int size() {
		return locations.size();
	}

	@Override
	public boolean isEmpty() {
		return locations.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return locations.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return locations.containsValue(value);
	}

	@Override
	public Location get(Object key) {
		return locations.get(key);
	}

	@Override
	public Location put(Integer key, Location value) {
		return locations.put(key, value);
	}

	@Override
	public Location remove(Object key) {
		return locations.remove(key);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Location> m) {

	}

	@Override
	public void clear() {
		locations.clear();

	}

	@Override
	public Set<Integer> keySet() {
		return locations.keySet();
	}

	@Override
	public Collection<Location> values() {
		return locations.values();
	}

	@Override
	public Set<Entry<Integer, Location>> entrySet() {
		return locations.entrySet();
	}
}
