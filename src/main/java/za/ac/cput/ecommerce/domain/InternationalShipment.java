package za.ac.cput.ecommerce.domain;

import jakarta.persistence.*;
import za.ac.cput.ecommerce.domain.enums.DeliveryStatus;

import java.time.LocalDate;

@Entity
@Table(name = "international_shipments")
@PrimaryKeyJoinColumn(name = "shipment_id", referencedColumnName = "shipment_id")
public class InternationalShipment extends Shipment {

    @Column(name = "customs_declaration_number")
    private String customsDeclarationNumber;

    @Column(name = "international_carrier_contact")
    private String internationalCarrierContact;

    @Column(name = "international_carrier_code")
    private String internationalCarrierCode;

    protected InternationalShipment() {}

    private InternationalShipment(Builder builder) {
        super(builder);
        this.customsDeclarationNumber = builder.customsDeclarationNumber;
        this.internationalCarrierContact = builder.internationalCarrierContact;
        this.internationalCarrierCode = builder.internationalCarrierCode;
    }

    public String getCustomsDeclarationNumber() {
        return customsDeclarationNumber;
    }

    public String getInternationalCarrierContact() {
        return internationalCarrierContact;
    }

    public String getInternationalCarrierCode() {
        return internationalCarrierCode;
    }

    @Override
    public String toString() {
        return "InternationalShipment{" +
                "customsDeclarationNumber='" + customsDeclarationNumber + '\'' +
                ", internationalCarrierContact='" + internationalCarrierContact + '\'' +
                ", internationalCarrierCode='" + internationalCarrierCode + '\'' +
                '}';
    }

    public static class Builder extends Shipment.Builder {
        private String customsDeclarationNumber;
        private String internationalCarrierContact;
        private String internationalCarrierCode;

        public Builder() {
            super();
        }

        public Builder setCustomsDeclarationNumber(String customsDeclarationNumber) {
            this.customsDeclarationNumber = customsDeclarationNumber;
            return this;
        }

        public Builder setInternationalCarrierContact(String internationalCarrierContact) {
            this.internationalCarrierContact = internationalCarrierContact;
            return this;
        }

        public Builder setInternationalCarrierCode(String internationalCarrierCode) {
            this.internationalCarrierCode = internationalCarrierCode;
            return this;
        }

        public Builder copy(InternationalShipment shipment) {
            super.copy(shipment);
            this.customsDeclarationNumber = shipment.customsDeclarationNumber;
            this.internationalCarrierContact = shipment.internationalCarrierContact;
            this.internationalCarrierCode = shipment.internationalCarrierCode;
            return this;
        }


        @Override
        public Builder setUser(User user) {
            super.setUser(user);
            return this;
        }

        @Override
        public Builder setShipmentId(String shipmentId) {
            super.setShipmentId(shipmentId);
            return this;
        }

        @Override
        public Builder setOrderId(String orderId) {
            super.setOrderId(orderId);
            return this;
        }

        @Override
        public Builder setShipmentDate(LocalDate shipmentDate) {
            super.setShipmentDate(shipmentDate);
            return this;
        }

        @Override
        public Builder setDeliveryAddress(String deliveryAddress) {
            super.setDeliveryAddress(deliveryAddress);
            return this;
        }

        @Override
        public Builder setDeliveryStatus(DeliveryStatus deliveryStatus) {
            super.setDeliveryStatus(deliveryStatus);
            return this;
        }

        @Override
        public Builder setCarrierName(String carrierName) {
            super.setCarrierName(carrierName);
            return this;
        }

        @Override
        public Builder setTrackingNumber(String trackingNumber) {
            super.setTrackingNumber(trackingNumber);
            return this;
        }

        @Override
        public Builder setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
            super.setEstimatedDeliveryDate(estimatedDeliveryDate);
            return this;
        }

        @Override
        public Builder setReceivedDate(LocalDate receivedDate) {
            super.setReceivedDate(receivedDate);
            return this;
        }

        @Override
        public Builder setRecipientName(String recipientName) {
            super.setRecipientName(recipientName);
            return this;
        }

        @Override
        public Builder setContactNumber(String contactNumber) {
            super.setContactNumber(contactNumber);
            return this;
        }

        @Override
        public InternationalShipment build() {
            return new InternationalShipment(this);
        }
    }
}
