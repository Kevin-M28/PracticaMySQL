package Dao;

import Models.DetalleVenta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class DetalleVentasDao implements AutoCloseable {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public DetalleVentasDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("modelocliente"); // Reemplaza con el nombre de tu unidad de persistencia
        entityManager = entityManagerFactory.createEntityManager();
    }


    public List<DetalleVenta> obtenerTodosLosDetalleVentas() {
        return entityManager.createQuery("SELECT c FROM DetalleVenta c", DetalleVenta.class).getResultList();
    }
    //obtione lista de detalle de ventas por cliente
    public List<DetalleVenta> obtenerTodosLosDetalleVentasPorCliente(int idCliente) {
        return entityManager.createQuery("SELECT c FROM DetalleVenta c WHERE c.idVenta = :idCliente", DetalleVenta.class).setParameter("idCliente", idCliente).getResultList();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
