package com.digital.epharmacy.factory.User;
//Nicole Hawthorne - Contact Information Factory - 05 July 2020
import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.util.GenericHelper;


// still need to retrieve userId and pharmacyId from their actual classes
public class ContactInformationFactory {

    public static ContactInformation createContactInformation(UserProfile userProfile){

        ContactInformation contactInformation = new ContactInformation.Builder()
                .setUser(userProfile)
                .setPrimary_number(userProfile.getContact().getPrimary_number())
                .setSecondary_number(userProfile.getContact().getSecondary_number())
                .build();
        return contactInformation;
    }
}
