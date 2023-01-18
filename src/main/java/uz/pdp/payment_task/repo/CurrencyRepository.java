package uz.pdp.payment_task.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.payment_task.entity.Currency;

@RepositoryRestResource(path = "currency")
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}
