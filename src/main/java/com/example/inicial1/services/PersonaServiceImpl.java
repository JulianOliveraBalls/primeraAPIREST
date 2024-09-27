package com.example.inicial1.services;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;
    //Con esto puedo acceder a todos los métodos que el repositorio incluya, ya que si o si lo debo instanciar primero
    //para usarlo.

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }


    @Override
    //Implementacion del metodo search()
    public List<Persona> search(String filtro) throws Exception {
        try {
            //Metodos con listado de keywords
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //JPQL
            //List<Persona> personas = personaRepository.search(filtro);
            //SQL
            List<Persona> personas = personaRepository.searchNativo(filtro);
            return personas;

            }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    //Implementacion del metodo search()
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Metodos con listado de keywords
            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //JPQL
            //Page<Persona> personas = personaRepository.search(filtro, pageable);
            //SQL
            Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);
            return personas;

        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

