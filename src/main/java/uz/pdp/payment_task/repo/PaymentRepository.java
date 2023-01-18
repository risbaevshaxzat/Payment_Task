package uz.pdp.payment_task.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.payment_task.entity.Payment;
@RepositoryRestResource(path = "payment")
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
