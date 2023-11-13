package Dao;

import Models.Venta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class VentasDao implements AutoCloseable {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public VentasDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("modelocliente"); // Reemplaza con el nombre de tu unidad de persistencia
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Venta> obtenerTodosLasVentas() {
        return entityManager.createQuery("SELECT c FROM Venta c", Venta.class).getResultList();
    }

    public List<Venta> obtenerTodosLasVentasPorCliente(int idCliente) {
        return entityManager.createQuery("SELECT c FROM Venta c WHERE c.idCliente = :idCliente", Venta.class).setParameter("idCliente", idCliente).getResultList();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

}
