/**
 * 
 */
package set.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bobbyfeng
 *
 */
public final class HeavenlyBody {
	
	private final String name;
	private final double orbitalPeriod;
	private final Set<HeavenlyBody> satellites;
	
	public HeavenlyBody(String name, double orbitalPeriod) {
		this.name = name;
		this.orbitalPeriod = orbitalPeriod;
		this.satellites = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}
	
	public boolean addMoon(HeavenlyBody moon) {
		return this.satellites.add(moon);
	}

	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<>(this.satellites);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + 57;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		System.out.println("obj.getClass() is " + obj.getClass());
		System.out.println("this.getClass() is " + this.getClass());
		if (getClass() != obj.getClass())
			return false;
		HeavenlyBody other = (HeavenlyBody) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	

}
