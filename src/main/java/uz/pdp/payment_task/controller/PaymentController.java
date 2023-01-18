package uz.pdp.payment_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.payment_task.entity.Currency;
import uz.pdp.payment_task.entity.Payment;
import uz.pdp.payment_task.entity.Product;
import uz.pdp.payment_task.entity.PurchaseDetail;
import uz.pdp.payment_task.paylod.PaymentDto;
import uz.pdp.payment_task.paylod.PurchaseDetailDto;
import uz.pdp.payment_task.repo.CurrencyRepository;
import uz.pdp.payment_task.repo.PaymentRepository;
import uz.pdp.payment_task.repo.ProductRepository;
import uz.pdp.payment_task.repo.PurchaseDetailRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PurchaseDetailRepository purchaseDetailRepository;

    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public HttpEntity<?> addPayment(@RequestBody PaymentDto paymentDto) {

        Payment payment = new Payment();
        payment.setCustomerName(paymentDto.getCustomerName());
        payment.setPhoneNumber(paymentDto.getPhoneNumber());
        payment.setEmail(paymentDto.getEmail());
        payment.setAddress(paymentDto.getAddress());

        List<PurchaseDetail> purchaseDetails = new ArrayList<>();

        for (int i = 0; i < paymentDto.getPurchaseDetails().size(); i++) {
            PurchaseDetailDto dto = paymentDto.getPurchaseDetails().get(i);
            PurchaseDetail purchaseDetail = new PurchaseDetail();

            Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
            if (optionalProduct.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            purchaseDetail.setProduct(optionalProduct.get());
            purchaseDetail.setProductAmount(dto.getProductAmount());

            PurchaseDetail saved = purchaseDetailRepository.save(purchaseDetail);

            purchaseDetails.add(saved);
        }

        payment.setPurchaseDetailList(purchaseDetails);

        Optional<Currency> optionalCurrency = currencyRepository.findById(paymentDto.getCurrencyId());
        if (optionalCurrency.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        payment.setCurrency(optionalCurrency.get());
        Payment saved = paymentRepository.save(payment);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getPaymentById(@PathVariable Integer id) {

        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        return ResponseEntity.status(optionalPayment.isPresent() ? 200 : 404).body(optionalPayment.orElse(null));

    }

    @GetMapping
    public HttpEntity<?> getPayments() {

        return ResponseEntity.ok(paymentRepository.findAll());

    }

    @PutMapping
    public HttpEntity<?> updatePayment(@PathVariable Integer id, @RequestBody PaymentDto paymentDto) {

        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Payment editingPayment = new Payment();
        editingPayment.setCustomerName(paymentDto.getCustomerName());
        editingPayment.setPhoneNumber(paymentDto.getPhoneNumber());
        editingPayment.setEmail(paymentDto.getEmail());
        editingPayment.setAddress(paymentDto.getAddress());

        List<PurchaseDetail> purchaseDetails = new ArrayList<>();

        for (int i = 0; i < paymentDto.getPurchaseDetails().size(); i++) {
            PurchaseDetailDto dto = paymentDto.getPurchaseDetails().get(i);
            PurchaseDetail purchaseDetail = new PurchaseDetail();

            Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
            if (optionalProduct.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            purchaseDetail.setProduct(optionalProduct.get());
            purchaseDetail.setProductAmount(dto.getProductAmount());

            PurchaseDetail saved = purchaseDetailRepository.save(purchaseDetail);

            purchaseDetails.add(saved);
        }

        editingPayment.setPurchaseDetailList(purchaseDetails);

        Optional<Currency> optionalCurrency = currencyRepository.findById(paymentDto.getCurrencyId());
        if (optionalCurrency.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        editingPayment.setCurrency(optionalCurrency.get());
        Payment saved = paymentRepository.save(editingPayment);
        return ResponseEntity.ok(saved);

    }

    @DeleteMapping
    public HttpEntity<?> deletePayment(@PathVariable Integer id) {

        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        paymentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
