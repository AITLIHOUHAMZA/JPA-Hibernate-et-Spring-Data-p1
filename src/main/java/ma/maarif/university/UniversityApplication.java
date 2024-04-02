package ma.maarif.university;

import ma.maarif.university.entities.Product;
import ma.maarif.university.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null, "Computer", 4300, 3));
        productRepository.save(new Product(null, "XBOX", 5300, 6));
        productRepository.save(new Product(null, "Ps5", 1300, 2));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
        System.out.println(p.toString());

        });
        Product product = productRepository.findById(1L).orElse(null); // Assuming 1L is the ID
        if (product != null){
            System.out.println("******");
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getQuantity());
            System.out.println("*****");
            System.out.println("-----");
        }else {
            System.out.println("Product with id 1 not found");
        } {
        List<Product>productList=productRepository.findByNameContains("C");
        productList.forEach(p->{
            System.out.println(p);
        });
        System.out.println("--------");
        List<Product>productList2=productRepository.search("%C%");
        productList2.forEach(p->{
            System.out.println(p);
        });
        System.out.println("--------");
        List<Product>productList3=productRepository.searchByPrice(4200);
        productList3.forEach(p->{
            System.out.println(p);
        });
    }


}}

