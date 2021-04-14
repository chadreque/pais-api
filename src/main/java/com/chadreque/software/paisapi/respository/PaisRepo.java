package com.chadreque.software.paisapi.respository;

import com.chadreque.software.paisapi.model.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("transactionManager")
public interface PaisRepo extends CrudRepository<Pais, Long> {
}
