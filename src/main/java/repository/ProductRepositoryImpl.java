package repository;

import model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProduct() {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Product.class);
        cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return cr.list();
    }

    @Override
    public Product getProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Product) session.get(Product.class, id);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, id);
        if(null!=product)session.delete(product);
    }

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }
}
