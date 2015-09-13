package scomanagementsystem.Model;

import org.springframework.hateoas.ResourceSupport;
import scomanagementsystem.domain.Address;
import scomanagementsystem.domain.PersonalDetails;

/**
 * Created by student on 2015/09/12.
 */
public class AssociateResource extends ResourceSupport{
    private String idNo;
    private String alumniStatus;
    private Address address;
    private PersonalDetails personalDetails;

    private AssociateResource() {
    }

    public AssociateResource(Builder builder) {
        idNo=builder.idNo;
        alumniStatus=builder.alumniStatus;
        address=builder.address;
        personalDetails=builder.personalDetails;
    }

    public String getIdNo() {
        return idNo;
    }

    public String getAlumniStatus() {
        return alumniStatus;
    }

    public Address getAddress() { return address; }

    public PersonalDetails getPersonalDetails() { return personalDetails; }

    public static class Builder {

        private String idNo;
        private String alumniStatus;
        private Address address;
        private PersonalDetails personalDetails;

        public Builder(String studentNo) {
            this.idNo = studentNo;
        }


        public Builder alumniStatus(String value) {
            this.alumniStatus = value;
            return this;
        }

        public Builder address(Address value) {
            this.address= value;
            return this;
        }

        public Builder personalDetails(PersonalDetails value) {
            this.personalDetails= value;
            return this;
        }

        public Builder copy(AssociateResource value) {
            this.idNo = value.getIdNo();
            this.alumniStatus = value.getAlumniStatus();
            this.address = value.getAddress();
            this.personalDetails = value.getPersonalDetails();
            return this;
        }

        public AssociateResource build() {
            return new AssociateResource(this);
        }

    }
}
