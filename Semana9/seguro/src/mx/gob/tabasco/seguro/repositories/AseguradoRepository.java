package mx.gob.tabasco.seguro.repositories;

import mx.gob.tabasco.seguro.entities.Asegurado;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AseguradoRepository extends PagingAndSortingRepository<Asegurado, Integer> {

}
