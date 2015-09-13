package scomanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/05/21.
 */

@Entity
public class Finances implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private Integer transNo;
    private String transName;
    private String transDate;
    private double tithe;
    private double offering;
    private String offeringAndTitheDate;
    private Integer serviceNo;

    private Finances() {
    }

    public Finances(Builder builder) {
        id=builder.id;
        transNo=builder.transNo;
        transName=builder.transName;
        transDate=builder.transDate;
        tithe=builder.tithe;
        offering=builder.offering;
        offeringAndTitheDate=builder.offeringAndTitheDate;
        serviceNo=builder.serviceNo;
    }

    public Long getId() {
        return id;
    }

    public Integer getTransNo() {
        return transNo;
    }

    public String getTransName() {return transName; }

    public String getTransDate() {
        return transDate;
    }

    public double getTithe() {
        return tithe;
    }

    public double getOffering() {
        return offering;
    }

    public String getOfferingAndTitheDate() {
        return offeringAndTitheDate;
    }

    public Integer getServiceNo() {
        return serviceNo;
    }

    public static class Builder {

        private Long id;
        private Integer transNo;
        private String transName;
        private String transDate;
        private double tithe;
        private double offering;
        private String offeringAndTitheDate;
        private Integer serviceNo;

        public Builder(Integer transNo) {
            this.transNo = transNo;
        }


        public Builder transDate(String value) {
            this.transDate = value;
            return this;
        }

        public Builder transName(String value) {
            this.transName = value;
            return this;
        }

        public Builder tithe(double value) {
            this.tithe = value;
            return this;
        }

        public Builder offering(double value) {
            this.offering = value;
            return this;
        }

        public Builder offeringAndTitheDate(String value) {
            this.offeringAndTitheDate = value;
            return this;
        }

        public Builder serviceNo(Integer value) {
            this.serviceNo = value;
            return this;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder copy(Finances value) {
            this.id = value.getId();
            this.transNo = value.getTransNo();
            this.transName = value.getTransName();
            this.transDate = value.getTransDate();
            this.tithe = value.getTithe();
            this.offering = value.getOffering();
            this.offeringAndTitheDate = value.getOfferingAndTitheDate();
            this.serviceNo = value.getServiceNo();
            return this;
        }

        public Finances build() {
            return new Finances(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Finances)) return false;

        Finances finances = (Finances) o;

        if (!id.equals(finances.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Finances{" +
                "id=" + id +
                ", transNo=" + transNo +
                ", transName=" + transName +
                ", transDate='" + transDate + '\'' +
                ", tithe=" + tithe +
                ", offering=" + offering +
                ", offeringAndTitheDate='" + offeringAndTitheDate + '\'' +
                ", serviceNo=" + serviceNo +
                '}';
    }
}
