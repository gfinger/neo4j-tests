package composite;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="leaf", path="/leaf")
public interface LeafRepository extends PagingAndSortingRepository<Leaf, Long>{

}
