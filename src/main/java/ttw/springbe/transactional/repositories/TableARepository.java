package ttw.springbe.transactional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttw.springbe.transactional.entities.TableA;

@Repository
public interface TableARepository extends JpaRepository<TableA, Integer> {
}
