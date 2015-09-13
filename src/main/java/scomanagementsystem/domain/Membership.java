package scomanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/05/21.
 */
@Entity
public class Membership implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String studentNo;
    private String salvationStatus;
    @Embedded
    private Address address;
    private PersonalDetails personalDetails;

    private Membership() {
    }

    public Membership(Builder builder) {
        id=builder.id;
        studentNo=builder.studentNo;
        salvationStatus=builder.salvationStatus;
        address=builder.address;
        personalDetails=builder.personalDetails;
    }

    public Long getId() {
        return id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public String getSalvationStatus() {
        return salvationStatus;
    }

    public  Address getAddress() { return address; }

    public PersonalDetails getPersonalDetails() { return personalDetails; }

    public static class Builder {

        private Long id;
        private String studentNo;
        private String salvationStatus;
        private Address address;
        private PersonalDetails personalDetails;

        public Builder(String studentNo) {
            this.studentNo = studentNo;
        }


        public Builder salvationStatus(String value) {
            this.salvationStatus = value;
            return this;
        }

        public Builder address(Address value) {
            this.address = value;
            return this;
        }

        public Builder personalDetails(PersonalDetails value) {
            this.personalDetails = value;
            return this;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder copy(Membership value) {
            this.id = value.getId();
            this.studentNo = value.getStudentNo();
            this.salvationStatus = value.getSalvationStatus();
            this.address = value.getAddress();
            this.personalDetails = value.getPersonalDetails();
            return this;
        }

        public Membership build() {
            return new Membership(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Membership)) return false;

        Membership that = (Membership) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", studentNo='" + studentNo + '\'' +
                ", salvationStatus='" + salvationStatus + '\'' +
                ", address=" + address +
                ", personalDetails=" + personalDetails +
                '}';
    }
}
