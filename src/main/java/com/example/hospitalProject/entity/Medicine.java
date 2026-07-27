package com.example.hospitalProject.entity;

import jakarta.persistence.*;

import javax.crypto.Mac;
import java.util.List;

@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private int id;

    @Column(name = "medicine_name", length = 150, nullable = false)
    private String medicineName;

    @Column(name = "unit", length = 30)
    private String unit;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InvoiceMedicine>  invoiceMedicine;

    public Medicine() {
    }

    public Medicine(String medicineName, String unit, double price, int stockQuantity, String description, List<InvoiceMedicine> invoiceMedicine) {
        this.medicineName = medicineName;
        this.unit = unit;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.invoiceMedicine = invoiceMedicine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InvoiceMedicine> getInvoiceMedicine() {
        return invoiceMedicine;
    }

    public void setInvoiceMedicine(List<InvoiceMedicine> invoiceMedicine) {
        this.invoiceMedicine = invoiceMedicine;
    }
}
