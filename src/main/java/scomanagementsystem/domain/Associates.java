package scomanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/05/10.
 */
@Entity
public class Associates implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String idNo;
    private String alumniStatus;

    private Associates() {
    }

    public Associates(Builder builder) {
        id=builder.id;
        idNo=builder.idNo;
        alumniStatus=builder.alumniStatus;
    }

    public Long getId() {
        return id;
    }

    public String getIdNo() {
        return idNo;
    }

    public String getAlumniStatus() {
        return alumniStatus;
    }

    public static class Builder {

        private Long id;
        private String idNo;
        private String alumniStatus;

        public Builder(String studentNo) {
            this.idNo = studentNo;
        }


        public Builder alumniStatus(String value) {
            this.alumniStatus = value;
            return this;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder copy(Associates value) {
            this.idNo = value.getIdNo();
            this.alumniStatus = value.getAlumniStatus();
            this.id = value.getId();
            return this;
        }

        public Associates build() {
            return new Associates(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Associates)) return false;

        Associates that = (Associates) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Associates{" +
                "id=" + id +
                ", idNo=" + idNo +
                ", alumniStatus='" + alumniStatus + '\'' +
                '}';
    }
}
