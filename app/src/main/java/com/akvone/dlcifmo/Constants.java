package com.akvone.dlcifmo;

/**
 * Created by 1 on 05.08.2016.
 */
public class Constants {

    //Название файла, который содержит данные залогиневшегося пользователя.
    //После выхода из аккаунта необходимо удалять.
    public static final String PREF_CURRENT_USER_DATA_FILE = "currentUserAppPreferences";

    public static final String PREF_LOGIN = "login";
    public static final String PREF_PASSWORD = "password";
    public static final String PREF_SKIP_LOGIN = "skipLoginBoolean";
    public static final String PREF_IS_FULL_MODE = "hasLoginData";

    public static final String PREF_FACULTY_NAME = "facultyName";
    public static final String PREF_COURSE_NUMBER = "courseNumber";
    public static final String PREF_POSITION_RATING_INFORMATION = "positionRatingINformation";
    public static final String PREF_FAMILY_NAME = "familyName";
    public static final String PREF_GIVEN_NAME = "givenName";
    public static final String PREF_MIDDLE_NAME = "middleName";
    public static final String PREF_GROUP_NAME = "groupName";

    public static final String PREF_MOCK_FILE = "mock_points";
    public static final String PREF_MOCK_SUBJECT_NAME = "name";
    public static final String PREF_MOCK_SUBJECT_TYPE = "type";
    public static final String PREF_MOCK_SUBJECT_POINTS = "points";
    public static final String PREF_MOCK_SUBJECTS_AMOUNT = "amount";

    public static final String CURRENT_VERSION = "0.2";
    public static final String GITHUB_URL = "https://github.com/akvone/DLCIFMO";
    //TODO: change this email to application corporative vk group
    public static final String VK_URL = "https://vk.com/overhearitmo";
    //TODO: change this email to application corporative email
    public static final String CONTACT_MAIL = "akvone@mail.ru";

    public static final int SUBJECT_TYPE_CREDIT = 1; //зачёт
    public static final int SUBJECT_TYPE_EXAM = 2;
    public static final int SUBJECT_TYPE_COURSE = 4;

//    <string name="preference_file_key">my_application_preferences</string>
//    <string name="preference_skip_login_key">skipLoginBoolean</string>
//    <string name="preference_has_login_data_key">hasLoginData</string>
//    <string name="preference_login_key">login</string>
//    <string name="preference_password_key">password</string>
}
