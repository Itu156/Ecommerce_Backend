package za.ac.cput.ecommerce.domain;

import jakarta.persistence.*;
import za.ac.cput.ecommerce.domain.enums.DeliveryStatus;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "shipments")
@Inheritance(strategy = InheritanceType.JOINED)
public class Shipment {

    @Id
    @Column(name = "shipment_id")
    private String shipmentId;

    // This is the new relationship to the User
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "shipment_date")
    private LocalDate shipmentDate;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status")
    private DeliveryStatus deliveryStatus;

    @Column(name = "carrier_name")
    private String carrierName;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "estimated_delivery_date")
    private LocalDate estimatedDeliveryDate;

    @Column(name = "received_date")
    private LocalDate receivedDate;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "contact_number")
    private String contactNumber;

    protected Shipment() {
    }

    protected Shipment(Builder builder) {
        this.shipmentId = builder.shipmentId;
        this.user = builder.user;
        this.orderId = builder.orderId;
        this.shipmentDate = builder.shipmentDate;
        this.deliveryAddress = builder.deliveryAddress;
        this.deliveryStatus = builder.deliveryStatus;
        this.carrierName = builder.carrierName;
        this.trackingNumber = builder.trackingNumber;
        this.estimatedDeliveryDate = builder.estimatedDeliveryDate;
        this.receivedDate = builder.receivedDate;
        this.recipientName = builder.recipientName;
        this.contactNumber = builder.contactNumber;
    }

    // Getters
    public String getShipmentId() { return shipmentId; }
    public User getUser() { return user; }
    public String getOrderId() { return orderId; }
    public LocalDate getShipmentDate() { return shipmentDate; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public DeliveryStatus getDeliveryStatus() { return deliveryStatus; }
    public String getCarrierName() { return carrierName; }
    public String getTrackingNumber() { return trackingNumber; }
    public LocalDate getEstimatedDeliveryDate() { return estimatedDeliveryDate; }
    public LocalDate getReceivedDate() { return receivedDate; }
    public String getRecipientName() { return recipientName; }
    public String getContactNumber() { return contactNumber; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return Objects.equals(shipmentId, shipment.shipmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipmentId);
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId='" + shipmentId + '\'' +
                ", userId=" + (user != null ? user.getUserId() : null) +
                ", orderId='" + orderId + '\'' +
                // ... other fields
                '}';
    }

    public static class Builder {
        private String shipmentId;
        private User user;
        private String orderId;
        private LocalDate shipmentDate;
        private String deliveryAddress;
        private DeliveryStatus deliveryStatus;
        private String carrierName;
        private String trackingNumber;
        private LocalDate estimatedDeliveryDate;
        private LocalDate receivedDate;
        private String recipientName;
        private String contactNumber;

        public Builder setShipmentId(String shipmentId) { this.shipmentId = shipmentId; return this; }
        public Builder setUser(User user) { this.user = user; return this; }
        public Builder setOrderId(String orderId) { this.orderId = orderId; return this; }
        public Builder setShipmentDate(LocalDate shipmentDate) { this.shipmentDate = shipmentDate; return this; }
        public Builder setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; return this; }
        public Builder setDeliveryStatus(DeliveryStatus deliveryStatus) { this.deliveryStatus = deliveryStatus; return this; }
        public Builder setCarrierName(String carrierName) { this.carrierName = carrierName; return this; }
        public Builder setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; return this; }
        public Builder setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) { this.estimatedDeliveryDate = estimatedDeliveryDate; return this; }
        public Builder setReceivedDate(LocalDate receivedDate) { this.receivedDate = receivedDate; return this; }
        public Builder setRecipientName(String recipientName) { this.recipientName = recipientName; return this; }
        public Builder setContactNumber(String contactNumber) { this.contactNumber = contactNumber; return this; }

        public Builder copy(Shipment shipment) {
            this.shipmentId = shipment.shipmentId;
            this.user = shipment.user;
            this.orderId = shipment.orderId;
            this.shipmentDate = shipment.shipmentDate;
            this.deliveryAddress = shipment.deliveryAddress;
            this.deliveryStatus = shipment.deliveryStatus;
            this.carrierName = shipment.carrierName;
            this.trackingNumber = shipment.trackingNumber;
            this.estimatedDeliveryDate = shipment.estimatedDeliveryDate;
            this.receivedDate = shipment.receivedDate;
            this.recipientName = shipment.recipientName;
            this.contactNumber = shipment.contactNumber;
            return this;
        }

        public Shipment build() {
            return new Shipment(this);
        }
    }
}

