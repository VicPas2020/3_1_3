package ru.vicpas.spjs.service.roleService;

import org.springframework.stereotype.Service;
import ru.vicpas.spjs.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Service
public class RoleServiceImpl implements RoleService{

    //................. Fields and Constructors .................

    @PersistenceContext
    private EntityManager em;

    //.................  Methods .............................
    @Override
    public Role getRoleByRoleName(String roleName) {
        TypedQuery<Role> tp = em.createQuery("FROM roletable u where u.role= :roleParam", Role.class);
        return tp.setParameter("roleParam", roleName).getSingleResult();

    }


    @Override
    public boolean empty() {
       return (long) em.createQuery("SELECT COUNT(*) FROM roletable  ").getSingleResult() == 0;

    }

    @Override
    @Transactional
    public void save() {
        em.createNativeQuery("INSERT INTO roletable (id, role) VALUES (1, 'ROLE_ADMIN')" ).executeUpdate();
        em.createNativeQuery("INSERT INTO roletable (id, role) VALUES (2, 'ROLE_USER')" ).executeUpdate();

    }
}
