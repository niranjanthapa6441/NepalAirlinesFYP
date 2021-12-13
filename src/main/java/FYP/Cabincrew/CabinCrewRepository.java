package FYP.Cabincrew;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinCrewRepository extends CrudRepository<CabinCrew,String> {
}
