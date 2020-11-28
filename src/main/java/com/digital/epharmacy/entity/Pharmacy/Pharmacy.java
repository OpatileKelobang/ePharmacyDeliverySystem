package com.digital.epharmacy.entity.Pharmacy;
/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy entity store pharmacy id and pharmacy name
 * Date: 04 July 2020
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;
;

@Entity
@Table(name = "pharmacies")
public class Pharmacy {
    // all the attributes of entity
    @Id
    @GeneratedValue(generator = "PHARM-generator")
    @GenericGenerator(name = "PHARM-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "PHARM"),
            strategy = "com.digital.epharmacy.util.CustomIDGenerator")
    @Column(name = "pharmacy_id")
    private String pharmacy_id;
    @Column(unique = true)
    @NotNull
    private String pharmacy_name;
    @Embedded
    private PharmacyBankAccountInformation bank_account;

    protected Pharmacy(){}

    // builder pattern method constructor
    private Pharmacy(Builder builder)
    {
        this.pharmacy_id = builder.pharmacy_id;
        this.pharmacy_name = builder.pharmacy_name;
        this.bank_account = builder.bank_account;
    }

    // getters for all attributes of entity Pharmacy


    public String getPharmacy_id() {
        return pharmacy_id;
    }

    public String getPharmacy_name() {
        return pharmacy_name;
    }

    public PharmacyBankAccountInformation getBank_account() {
        return bank_account;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmacy_id=" + pharmacy_id +
                ", pharmacy_name='" + pharmacy_name + '\'' +
                ", bank_account=" + bank_account +
                '}';
    }

    // add setters using building pattern
    public static class Builder
    {
        private String pharmacy_id;
        private String pharmacy_name;
        private PharmacyBankAccountInformation bank_account;

        public Builder setPharmacy_id(String pharmacy_id) {
            this.pharmacy_id = pharmacy_id;
            return this;
        }

        public Builder setPharmacy_name(String pharmacy_name) {
            this.pharmacy_name = pharmacy_name;
            return this;
        }

        public Builder setBank_account(PharmacyBankAccountInformation bank_account) {
            this.bank_account = bank_account;
            return this;
        }

        // Copy method for Pharmacy entity
        public Builder copy (Pharmacy pharmacy)
        {
            this.pharmacy_id = pharmacy.pharmacy_id;
            this.pharmacy_name = pharmacy.pharmacy_name;
            this.bank_account = pharmacy.bank_account;
            return this;
        }

        // Instance for Builder Pattern
        public Pharmacy build() {
            return new Pharmacy(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return Objects.equals(pharmacy_id, pharmacy.pharmacy_id) &&
                pharmacy_name.equals(pharmacy.pharmacy_name) &&
                Objects.equals(bank_account, pharmacy.bank_account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pharmacy_id, pharmacy_name, bank_account);
    }
}

