package composite;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="composite", path="/composite")
public interface CompositeRepository extends PagingAndSortingRepository<Composite, Long>{

}
