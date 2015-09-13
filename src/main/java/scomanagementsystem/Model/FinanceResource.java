package scomanagementsystem.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/12.
 */
public class FinanceResource extends ResourceSupport {
    private Integer transNo;
    private String transName;
    private String transDate;
    private double tithe;
    private double offering;
    private String offeringAndTitheDate;
    private Integer serviceNo;

    private FinanceResource() {
    }

    public FinanceResource(Builder builder) {
        transNo=builder.transNo;
        transName=builder.transName;
        transDate=builder.transDate;
        tithe=builder.tithe;
        offering=builder.offering;
        offeringAndTitheDate=builder.offeringAndTitheDate;
        serviceNo=builder.serviceNo;
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

        public Builder copy(FinanceResource value) {
            this.transNo = value.getTransNo();
            this.transName = value.getTransName();
            this.transDate = value.getTransDate();
            this.tithe = value.getTithe();
            this.offering = value.getOffering();
            this.offeringAndTitheDate = value.getOfferingAndTitheDate();
            this.serviceNo = value.getServiceNo();
            return this;
        }

        public FinanceResource build() {
            return new FinanceResource(this);
        }
    }
}
