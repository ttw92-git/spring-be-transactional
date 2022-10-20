package ttw.springbe.transactional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttw.springbe.transactional.entities.TableB;

@Repository
public interface TableBRepository extends JpaRepository<TableB, Integer> {
}
