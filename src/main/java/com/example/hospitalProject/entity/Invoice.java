package com.example.hospitalProject.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int id;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "examination_fee")
    private double examinationFee;

    @Column(name = "medicine_fee")
    private double medicineFee;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "payment_status", length = 30)
    private String paymentStatus;

//    appointment_id
    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InvoiceMedicine> invoiceMedicine;

    public Invoice() {
    }

    public Invoice(LocalDateTime issueDate, double examinationFee, double medicineFee, double totalAmount, String paymentStatus, Appointment appointment, List<InvoiceMedicine> invoiceMedicine) {
        this.issueDate = issueDate;
        this.examinationFee = examinationFee;
        this.medicineFee = medicineFee;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.appointment = appointment;
        this.invoiceMedicine = invoiceMedicine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public double getExaminationFee() {
        return examinationFee;
    }

    public void setExaminationFee(double examinationFee) {
        this.examinationFee = examinationFee;
    }

    public double getMedicineFee() {
        return medicineFee;
    }

    public void setMedicineFee(double medicineFee) {
        this.medicineFee = medicineFee;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public List<InvoiceMedicine> getInvoiceMedicine() {
        return invoiceMedicine;
    }

    public void setInvoiceMedicine(List<InvoiceMedicine> invoiceMedicine) {
        this.invoiceMedicine = invoiceMedicine;
    }
}
