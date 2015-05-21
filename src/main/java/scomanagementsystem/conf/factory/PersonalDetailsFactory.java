package scomanagementsystem.conf.factory;

import scomanagementsystem.domain.Address;
import scomanagementsystem.domain.PersonalDetails;

import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
public class PersonalDetailsFactory {
    public static PersonalDetails createDetails(Map<String, String> fullName, Map<String, String> values){

        PersonalDetails details = new PersonalDetails
                .Builder(fullName.get("name"))
                .surname(fullName.get("surname"))
                .cell(values.get("cell"))
                .email(values.get("email"))
                .build();
        return details;
    }
}
