package uz.pdp.payment_task.repo;


import org.hibernate.boot.archive.scan.spi.PackageDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "packageDescriptor")
public interface PurchaseDetailRepository extends JpaRepository<PackageDescriptor, Integer> {

}
