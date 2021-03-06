package composite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    CompositeRepository refererRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        Composite composite = new Composite();
        composite.setName("Senat");
        HashSet<Leaf> children = new HashSet<>();
        Leaf leaf = new Leaf();
        leaf.setDescription("Ceterum Censeo");
        leaf.setName("Cato");
        leaf.setCreationDate(LocalDateTime.parse("2011-12-03T10:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        children.add(leaf);
        composite.setLeaf(children);
        refererRepo.save(composite);
    }
}
