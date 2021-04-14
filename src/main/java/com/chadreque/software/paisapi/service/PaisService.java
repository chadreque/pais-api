package com.chadreque.software.paisapi.service;

import com.chadreque.software.paisapi.exception.ElementoNotFound;
import com.chadreque.software.paisapi.model.Pais;
import com.chadreque.software.paisapi.respository.PaisRepo;
import com.chadreque.software.paisapi.util.Constante;
import com.chadreque.software.paisapi.util.Ordenacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class PaisService {

    @Autowired
    private PaisRepo repository;

    public List<Pais> listar(String orderBy, String orderType) {
        List<Pais> paises = new ArrayList<>();

        repository.findAll().forEach(paises::add);

        //Caso nao for mensionado a ordenacao, mostra a lista nao ordenada
        //Se especificar o tipo de ordenacao diferente de 'asc' sem mensionar o atributo, ordena por id
        if(orderBy == null) {
            if (orderType != null && orderType.equalsIgnoreCase(Constante.DESC)) {
                Comparator<Pais> comparatorById = (Pais pais1, Pais pais2) ->
                        pais1.getId().compareTo(pais2.getId());

                paises.sort(comparatorById.reversed());
            }

            return paises;
        }

        switch (Objects.requireNonNull(orderBy).toLowerCase()) {
            case Constante.ID :
                Comparator<Pais> comparatorById = (Pais pais1, Pais pais2) ->
                        pais1.getId().compareTo(pais2.getId());

                Ordenacao.comparar(paises, comparatorById, orderType);

                return paises;

            case Constante.NOME :
                Comparator<Pais> comparatorByNome = (Pais pais1, Pais pais2) ->
                        pais1.getNome().compareTo(pais2.getNome());

                Ordenacao.comparar(paises, comparatorByNome, orderType);

                return paises;

            case Constante.CAPITAL :
                Comparator<Pais> comparatorByCapital = (Pais pais1, Pais pais2) ->
                        pais1.getCapital().compareTo(pais2.getCapital());

                Ordenacao.comparar(paises, comparatorByCapital, orderType);

                return paises;
            case Constante.REGIAO :
                Comparator<Pais> comparatorByRegiao = (Pais pais1, Pais pais2) ->
                        pais1.getRegiao().compareTo(pais2.getRegiao());

                Ordenacao.comparar(paises, comparatorByRegiao, orderType);

                return paises;

            case Constante.SUBREGIAO :
                Comparator<Pais> comparatorBySubRegiao = (Pais pais1, Pais pais2) ->
                        pais1.getSubRegiao().compareTo(pais2.getSubRegiao());

                Ordenacao.comparar(paises, comparatorBySubRegiao, orderType);

                return paises;

            case Constante.AREA :
                Comparator<Pais> comparatorByArea = (Pais pais1, Pais pais2) ->
                        pais1.getArea().compareTo(pais2.getArea());

                Ordenacao.comparar(paises, comparatorByArea, orderType);

                return paises;

            default:
                throw new ElementoNotFound();
        }
    }

    public Pais getPais(Long id) {
        if (!repository.findById(id).isPresent())
            throw new ElementoNotFound();

        return repository.findById(id).get();
    }

    //Este metodo serve para inserir e atualizar um pais na base de dados
    //Quando o objecto conter um id ele actualizara' o objecto caso contrario sera' criado um novo objecto
    public Pais merge(Pais pais)  {
        pais.setDate();

        try {
            return repository.save(pais);
        }catch (ConstraintViolationException e) {
            throw new ValidationException();
        }
    }

    public void eliminar(Long id) {
        if (!repository.findById(id).isPresent())
            throw new ElementoNotFound();

        repository.deleteById(id);
    }
}
