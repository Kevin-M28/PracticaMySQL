package Dao;

import Models.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class ClientesDao implements AutoCloseable {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public ClientesDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("modelocliente"); // Reemplaza con el nombre de tu unidad de persistencia
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void guardarCliente(Cliente cliente) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Cliente obtenerClientePorId(int idCliente) {
        return entityManager.find(Cliente.class, idCliente);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    public void actualizarCliente(Cliente cliente) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void eliminarCliente(int idCliente) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Cliente cliente = entityManager.find(Cliente.class, idCliente);
            entityManager.remove(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
