package scomanagementsystem.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/05/21.
 */
@Embeddable
public class Address implements Serializable{
    private int houseNo;
    private String streetNm;
    private String suburb;
    private String city;
    private int code;

    private Address() {
    }

    public Address(Builder builder) {
        houseNo=builder.houseNo;
        streetNm=builder.streetNm;
        suburb=builder.suburb;
        city=builder.city;
        code=builder.code;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public String getStreetNm() {
        return streetNm;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public int getCode() {
        return code;
    }

    public static class Builder{
        private int houseNo;
        private String streetNm;
        private String suburb;
        private String city;
        private int code;

        public Builder(int houseNo) {
            this.houseNo = houseNo;
        }


        public Builder streetNm(String value){
            this.streetNm=value;
            return this;
        }

        public Builder suburb(String value){
            this.suburb=value;
            return this;
        }

        public Builder city(String value){
            this.city=value;
            return this;
        }

        public Builder code(int value){
            this.code=value;
            return this;
        }

        public Builder copy(Address value){
            this.houseNo=value.houseNo;
            this.streetNm=value.streetNm;
            this.suburb=value.suburb;
            this.city=value.city;
            this.code=value.code;
            return this;
        }

        public Address build(){
            return new Address(this);
        }

    }

}
