package za.co.bbd.myApp.model;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Version;
import za.co.bbd.myApp.model.Hurricane;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.ManyToMany;

@Entity
public class Continent implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private static final long serialVersionUID = 1L;
	@Version
	@Column(name = "version")
	private int version;

	@ManyToMany(mappedBy = "continents")
	private Set<Hurricane> hurricanes = new HashSet<Hurricane>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Continent)) {
			return false;
		}
		Continent other = (Continent) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<Hurricane> getHurricanes() {
		return this.hurricanes;
	}

	public void setHurricanes(final Set<Hurricane> hurricanes) {
		this.hurricanes = hurricanes;
	}
}