package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.domain.SalesPackage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface SalesPackageRepository extends JpaRepository<SalesPackage, Long> {
}
