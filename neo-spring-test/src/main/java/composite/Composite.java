package composite;

import java.util.Set;

public class Composite extends Component {
	private Set<Leaf> leaf;

	public Set<Leaf> getLeaf() {
		return leaf;
	}

	public void setLeaf(Set<Leaf> leaf) {
		this.leaf = leaf;
	}
	
}
