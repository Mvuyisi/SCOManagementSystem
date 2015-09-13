package scomanagementsystem.Model;

import org.springframework.hateoas.ResourceSupport;
import scomanagementsystem.domain.Address;
import scomanagementsystem.domain.PersonalDetails;

/**
 * Created by student on 2015/09/12.
 */
public class MembershipResource extends ResourceSupport {
    private String studentNo;
    private String salvationStatus;
    private Address address;
    private PersonalDetails personalDetails;

    private MembershipResource() {
    }

    public MembershipResource(Builder builder) {
        studentNo=builder.studentNo;
        salvationStatus=builder.salvationStatus;
        address=builder.address;
        personalDetails=builder.personalDetails;
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

        public Builder copy(MembershipResource value) {
            this.studentNo = value.getStudentNo();
            this.salvationStatus = value.getSalvationStatus();
            this.address = value.getAddress();
            this.personalDetails = value.getPersonalDetails();
            return this;
        }

        public MembershipResource build() {
            return new MembershipResource(this);
        }
    }
}
