package scomanagementsystem.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/05/21.
 */
@Embeddable
public class PersonalDetails implements Serializable{
    private String name;
    private String surname;
    private String cell;
    private String email;

    private PersonalDetails() {
    }

    public PersonalDetails(Builder builder) {
        name=builder.name;
        surname=builder.surname;
        cell=builder.cell;
        email=builder.email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCell() {
        return cell;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder{
        private String name;
        private String surname;
        private String cell;
        private String email;

        public Builder(String name) {
            this.name = name;
        }

        public Builder surname(String value){
            this.surname=value;
            return this;
        }

        public Builder cell(String value){
            this.cell=value;
            return this;
        }

        public Builder email(String value){
            this.email=value;
            return this;
        }

        public Builder copy(PersonalDetails value){
            this.name=value.name;
            this.surname=value.surname;
            this.cell=value.cell;
            this.email=value.email;
            return this;
        }

        public PersonalDetails build(){
            return new PersonalDetails(this);
        }
    }
}
