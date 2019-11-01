package mz.co.gym.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
///
@Entity
@Table(name = "payment")
public class PaymentEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "payment_date", nullable = false)
	private LocalDate paymentdate = LocalDate.now();

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "initial_date", nullable = false)
	private LocalDate initialDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "last_day_of_valid_payment_date")
	private LocalDate lastDayOfValidPaymentDate;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_type", nullable = false)
	private PaymentType paymentType;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(LocalDate paymentdate) {
		this.paymentdate = paymentdate;
	}

	public LocalDate getLastDayOfValidPaymentDate() {
		return lastDayOfValidPaymentDate;
	}

	public void setLastDayOfValidPaymentDate(LocalDate lastDayOfValidPaymentDate) {
		this.lastDayOfValidPaymentDate = lastDayOfValidPaymentDate;
	}

	public String paymentdate() {
		return this.paymentdate.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
	}

	public String lastDayOfValidPaymentDate() {
		return this.lastDayOfValidPaymentDate.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public LocalDate getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
	}

}
