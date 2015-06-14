package composite;

import java.util.Set;

import org.springframework.data.neo4j.annotation.Fetch;

public class Composite extends Component {
	@Fetch
	private Set<Leaf> leaf;

	public Set<Leaf> getLeaf() {
		return leaf;
	}

	public void setLeaf(Set<Leaf> leaf) {
		this.leaf = leaf;
	}
	
}
