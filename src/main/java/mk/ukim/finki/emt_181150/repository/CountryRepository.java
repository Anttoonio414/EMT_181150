package mk.ukim.finki.emt_181150.repository;

import mk.ukim.finki.emt_181150.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
