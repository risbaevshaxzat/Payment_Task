package uz.pdp.payment_task.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.payment_task.entity.Language;

@RepositoryRestResource(path = "language")
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
