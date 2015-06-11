package composite;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="component", path="/component")
public interface ComponentRepository extends PagingAndSortingRepository<Component, Long>{

}
