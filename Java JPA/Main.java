import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        //  EntityManagerFactory e EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager em = emf.createEntityManager();

        // novo Produto
        Produto produto = new Produto();
        produto.setNome("Pizza Calabresa");
        produto.setPreco(35.00);

        // Persistindo o Produto
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();

        //  novo Pedido
        Pedido pedido = new Pedido();
        pedido.setStatus("Em andamento");
        pedido.setEndereco(new Endereco()); 
        pedido.setProdutos(List.of(produto));

        // Persistindo o Pedido
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();

        // Fechar
        em.close();
        emf.close();
    }
}
