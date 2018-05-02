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
public abstract class HeavenlyBody {

	private final String name;
	private final double orbitalPeriod;
	private final Set<HeavenlyBody> satellites;
	private final BodyTypes bodyType;

	public enum BodyTypes {
		STAR, PLANET, DWARF_PLANET, MOON, COMET, ASTEROID
	}

	public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
		this.name = name;
		this.orbitalPeriod = orbitalPeriod;
		this.bodyType = bodyType;
		this.satellites = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public boolean addSatellite(HeavenlyBody moon) {
		return this.satellites.add(moon);
	}

	protected BodyTypes getBodyType() {
		return bodyType;
	}

	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<>(this.satellites);
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodyType == null) ? 0 : bodyType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeavenlyBody other = (HeavenlyBody) obj;
		if (bodyType != other.bodyType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HeavenlyBody [name=" + name + ", orbitalPeriod=" + orbitalPeriod + ", bodyType=" + bodyType + "]";
	}
	
}
