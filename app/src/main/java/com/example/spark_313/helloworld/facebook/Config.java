package com.example.spark_313.helloworld.facebook;

import com.facebook.BuildConfig;

import java.util.HashMap;

/**
 * Created by radu on 05.05.2015.
 */
public class Config {


    public static HashMap<Integer, String> sTypeFaceMap;
    public static boolean DEBUG = BuildConfig.DEBUG;//&&false;
    public static String URL_REDIRECT = DEBUG ? Url.DEBUG_HOST : Url.RELEASE_HOST;
    public static final String FACEBOOK_SHARE_LINK = "https://www.tablerunner.com/#weekly-menu%22";


    public static class TypeFace {
        public static final String openSansBold = "fonts/OpenSans-Bold.ttf";
        public static final String openSansBoldItalic = "fonts/OpenSans-BoldItalic.ttf";
        public static final String openSansExtraBold = "fonts/OpenSans-ExtraBold.ttf";
        public static final String openSansExtraBoldItalic = "fonts/OpenSans-ExtraBoldItalic.ttf";
        public static final String openSansItalic = "fonts/OpenSans-Italic.ttf";
        public static final String openSansLight = "fonts/OpenSans-Light.ttf";
        public static final String openSansLightItalic = "fonts/OpenSans-LightItalic.ttf";
        public static final String openSansRegular = "fonts/OpenSans-Regular.ttf";
        public static final String openSansSemiBold = "fonts/OpenSans-Semibold.ttf";
        public static final String openSansSemiBoldItalic = "fonts/OpenSans-SemiboldItalic.ttf";
        public static final int OPEN_SANS_BOLD = 0;
        public static final int OPEN_SANS_BOLD_ITALIC = 1;
        public static final int OPEN_SANS_EXTRA_BOLD = 2;
        public static final int OPEN_SANS_EXTRA_BOLD_ITALIC = 3;
        public static final int OPEN_SANS_ITALIC = 4;
        public static final int OPEN_SANS_LIGHT = 5;
        public static final int OPEN_SANS_LIGHT_ITALIC = 6;
        public static final int OPEN_SANS_REGULAR = 7;
        public static final int OPEN_SANS_SEMI_BOLD = 8;
        public static final int OPEN_SANS_SEMI_BOLD_ITALIC = 9;
    }

    public static class InputType {
        public static final int TEXT = 0;
        public static final int PHONE = 1;
        public static final int TEXT_PERSON_NAME = 2;
        public static final int NUMBER = 3;
        public static final int TEXT_CAP_WORDS = 4;
        public static final int EMAIL = 5;
    }


    static {
        sTypeFaceMap = new HashMap();
        sTypeFaceMap.put(TypeFace.OPEN_SANS_BOLD, TypeFace.openSansBold);
        sTypeFaceMap.put(TypeFace.OPEN_SANS_BOLD_ITALIC, TypeFace.openSansBoldItalic);
        sTypeFaceMap.put(TypeFace.OPEN_SANS_EXTRA_BOLD, TypeFace.openSansExtraBold);
        sTypeFaceMap.put(TypeFace.OPEN_SANS_EXTRA_BOLD_ITALIC, TypeFace.openSansExtraBoldItalic);
        sTypeFaceMap.put(TypeFace.OPEN_SANS_ITALIC, TypeFace.openSansItalic);
        sTypeFaceMap.put(TypeFace.OPEN_SANS_LIGHT, TypeFace.openSansLight);
        sTypeFaceMap.put(TypeFace.OPEN_SANS_LIGHT_ITALIC, TypeFace.openSansLightItalic);
        sTypeFaceMap.put(TypeFace.OPEN_SANS_REGULAR, TypeFace.openSansRegular);
        sTypeFaceMap.put(TypeFace.OPEN_SANS_SEMI_BOLD, TypeFace.openSansSemiBold);
        sTypeFaceMap.put(TypeFace.OPEN_SANS_SEMI_BOLD_ITALIC, TypeFace.openSansSemiBoldItalic);
    }

    public static class Key {
        public static final String EMAIL = "email";
        public static final String ID = "id";
        public static final String PASSWORD = "password";
        public static final String NAME = "name";
        public static final String PROVIDER = "provider";
        public static final String PROVIDER_UID = "provider_uid";
        public static final String PROVIDER_AUTH_TOKEN = "provider_auth_token";
        public static final String FACEBOOK = "facebook";
        public static final String FIELDS = "fields";
        public static final String HEADER_KEY = "HTTP_PASSWORD";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String APPLICATION_JSON = "application/json";
        public static final String AUTH_TOKEN = "auth_token";
        public static final String ACCOUNT_PREFS = "account_prefs";
        public static final String METHOD = "method";
        public static final String URL = "url";
        public static final String PARAMS = "params";
        public static final String MESSAGE = "message";
        public static final String USER_DETAILS = "user_details";
        public static final String RESULTS = "request_results";
        public static final String ERROR_MESSAGE = "error_message";
        public static final String USER_SUBSCRIPTIONS = "user_subscriptions";
        public static final String MEALS = "meals";
        public static final String SUBSCRIPTION_TYPE = "subscription_type";
        public static final String BUNDLE_EXTRAS = "bundle_extras";
        public static final String SUBSCRIPTION_ID = "subscription_id";
        public static final String STATES = "states";
        public static final String PROPERTY_REG_ID = "gcm_register_id";

        //JSON PARAMS FOR REQUESTS
        public static final String PAYLOAD = "payload";
        public static final String USER_SUBSCRIPTION = "user_subscription";
        public static final String USER_SUBSCRIPTION_DETAILS_ATTRIBUTES = "user_subscription_details_attributes";
        public static final String MEALS_COUNT = "meals_count";
        public static final String CATEGORY_ID = "category_id";
        public static final String MEAL_ID = "meal_id";
        public static final String BOX_INDEX = "box_index";
        public static final String AUTH_EMAIL = "auth_email";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String CITY = "city";
        public static final String STATE = "state";
        public static final String STREET = "street";
        public static final String ADDRESS2 = "address_line_2";
        public static final String COMPANY_NAME = "company_name";
        public static final String DELIVERY_INSTRUCTIONS = "delivery_instructions";
        public static final String DATES = "dates";
        public static final String NOTIFICATION_PREFERENCES = "notification_preferences";
        public static final String DEVICE_TYPE = "device_type";
        public static final String DEVICE_TOKEN = "device_token";
        public static final String PUSH_NOTIFICATION_TOKEN = "push_notification_token";
    }


    public static class Url {
        public static final String DEBUG_HOST = "http://tr.sparktechsoft.net";
        public static final String RELEASE_HOST = "https://tablerunner.com";
        public static final String API = "/api";
        public static final String API_VERSION = "/v1";
        public static final String HOST_URL = DEBUG ? DEBUG_HOST : RELEASE_HOST;
        public static final String BASE_URL = HOST_URL + API + API_VERSION;
        public static final String SIGN_IN = BASE_URL + "/sessions";
        public static final String RESET_PASSWORD = BASE_URL + "/passwords/reset";
        public static final String GET_MEALS = BASE_URL + "/meals";
        public static final String GET_USER_INFO = BASE_URL + "/users?auth_email=%s&auth_token=%s";
        public static final String GET_USER_SUBSCRIPTION = BASE_URL + "/subscriptions/%s?auth_email=%s&auth_token=%s";
        public static final String GET_SUBSCRIPTION_TYPES = BASE_URL + "/subscriptions/types";
        public static final String UPDATE_SUBSCRIPTION = BASE_URL + "/subscriptions/%s/update_meals";
        public static final String DONATE = BASE_URL + "/orders/donate";
        public static final String REDIRECT = BASE_URL + "/orders/redirect";
        public static final String GET_STATES = BASE_URL + "/states";
        public static final String HOLD_SUBSCRIPTION = BASE_URL + "/subscriptions/%s/hold";
        public static final String LOOK_UP_ZIP_CODE = BASE_URL + "/zipcodes/?zipcode=%s";
        public static final String LOOK_UP_CITY_AND_STATE = BASE_URL + "/zipcodes/?city=%1$s&state=%2$s";
        public static final String CREATE_GIFT = BASE_URL + "/gifts";
        public static final String NOTIFICATION_PREFERENCES = BASE_URL + "/users/notification_preferences";
        public static final String REGISTER_GCM = BASE_URL + "/devices";
    }

    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_NOT_FOUND = 404;
    public static final int HTTP_CONFLICT = 409;


    public static class Action {
        public static final String SEND_RESULT = "com.mobile.table.runner.BROADCAST_RESULT";
        public static final String SEND_ERROR = "com.mobile.table.runner.BROADCAST_ERROR";
        public static final String SYNC_SUCCESS = "com.mobile.table.runner.BROADCAST_SYNC_SUCCESS";
        public static final String SYNC_ERROR = "com.mobile.table.runner.BROADCAST_SYNC_ERROR";
    }

    public static class RequestId {
        public static final int SIGN_IN_ID = 1;
        public static final int SIGN_IN_SOCIAL_ID = 2;
        public static final int RESET_PASSWORD = 3;
        public static final int GET_MEALS = 4;
        public static final int UPDATE_SUBSCRIPTION = 5;
        public static final int DONATE = 6;
        public static final int REDIRECT = 7;
        public static final int STATES = 8;
        public static final int HOLD = 9;
        public static final int LOOK_UP_ZIP_CODE = 10;
        public static final int LOOK_UP_CITY_AND_STATE = 11;
        public static final int CREATE_GIFT = 12;
        public static final int NOTIFICATION_PREFERENCES = 13;
        public static final int REGISTER_TO_GCM = 14;
    }


}
