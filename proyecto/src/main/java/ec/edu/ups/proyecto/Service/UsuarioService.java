package ec.edu.ups.proyecto.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.ups.proyecto.entity.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class UsuarioService {
    @PersistenceContext
    private EntityManager entityManager;
    private final RestTemplate restTemplate;

    public UsuarioService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Usuario> getListaTodo() {
        String jpql = "SELECT c FROM Usuario c";
        Query query = entityManager.createQuery(jpql, Usuario.class);
        List<Usuario> lista = query.getResultList();
        return lista;
    }

    public void insertarRegistro(Usuario recurso) {
        entityManager.persist(recurso);

    }
}

