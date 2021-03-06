
package com.kth.baasio.entity.user;

import static org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL;

import com.kth.baasio.Baas;
import com.kth.baasio.callback.BaasioAsyncTask;
import com.kth.baasio.callback.BaasioCallback;
import com.kth.baasio.callback.BaasioSignInAsyncTask;
import com.kth.baasio.callback.BaasioSignInCallback;
import com.kth.baasio.callback.BaasioSignUpAsyncTask;
import com.kth.baasio.callback.BaasioSignUpCallback;
import com.kth.baasio.entity.BaasioBaseEntity;
import com.kth.baasio.entity.push.BaasioPush;
import com.kth.baasio.exception.BaasioError;
import com.kth.baasio.exception.BaasioException;
import com.kth.baasio.preferences.BaasioPreferences;
import com.kth.baasio.response.BaasioResponse;
import com.kth.baasio.utils.JsonUtils;
import com.kth.baasio.utils.ObjectUtils;
import com.kth.common.utils.LogUtils;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.http.HttpMethod;

import android.content.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaasioUser extends BaasioBaseEntity {
    private final static String TAG = LogUtils.makeLogTag(BaasioUser.class);

    public final static String ENTITY_TYPE = "user";

    public final static String PROPERTY_USERNAME = "username";

    public final static String PROPERTY_EMAIL = "email";

    public final static String PROPERTY_NAME = "name";

    public final static String PROPERTY_FIRSTNAME = "firstname";

    public final static String PROPERTY_MIDDLENAME = "middlename";

    public final static String PROPERTY_LASTNAME = "lastname";

    public final static String PROPERTY_ACTIVATED = "activated";

    public final static String PROPERTY_PICTURE = "picture";

    public final static String PROPERTY_DISABLED = "disabled";

    public final static String PROPERTY_FACEBOOK = "facebook";

    public BaasioUser() {
        super();
        setType(ENTITY_TYPE);
    }

    public BaasioUser(BaasioBaseEntity entity) {
        super(entity);
    }

    /**
     * Get predefined property names.
     * 
     * @return List of predefined property names
     */
    @Override
    @JsonIgnore
    public List<String> getPropertyNames() {
        List<String> properties = super.getPropertyNames();
        properties.add(PROPERTY_USERNAME);
        properties.add(PROPERTY_EMAIL);
        properties.add(PROPERTY_NAME);
        properties.add(PROPERTY_FIRSTNAME);
        properties.add(PROPERTY_MIDDLENAME);
        properties.add(PROPERTY_LASTNAME);
        properties.add(PROPERTY_ACTIVATED);
        properties.add(PROPERTY_PICTURE);
        properties.add(PROPERTY_DISABLED);
        properties.add(PROPERTY_FACEBOOK);
        return properties;
    }

    /**
     * Get user name.
     * 
     * @return User name
     */
    @JsonSerialize(include = NON_NULL)
    public String getUsername() {
        return JsonUtils.getStringProperty(properties, PROPERTY_USERNAME);
    }

    /**
     * Set user name.
     * 
     * @param username User name
     */
    public void setUsername(String username) {
        JsonUtils.setStringProperty(properties, PROPERTY_USERNAME, username);
    }

    /**
     * Get name.
     * 
     * @return Name
     */
    @JsonSerialize(include = NON_NULL)
    public String getName() {
        return JsonUtils.getStringProperty(properties, PROPERTY_NAME);
    }

    /**
     * Set name.
     * 
     * @param name Name
     */
    public void setName(String name) {
        JsonUtils.setStringProperty(properties, PROPERTY_NAME, name);
    }

    /**
     * Get email.
     * 
     * @return Email
     */
    @JsonSerialize(include = NON_NULL)
    public String getEmail() {
        return JsonUtils.getStringProperty(properties, PROPERTY_EMAIL);
    }

    /**
     * Set email.
     * 
     * @param email email
     */
    public void setEmail(String email) {
        JsonUtils.setStringProperty(properties, PROPERTY_EMAIL, email);
    }

    /**
     * Get activate status.
     * 
     * @return true is activated.
     */
    @JsonSerialize(include = NON_NULL)
    public Boolean isActivated() {
        return JsonUtils.getBooleanProperty(properties, PROPERTY_ACTIVATED);
    }

    /**
     * Set to activate status.
     * 
     * @param activated Activate status.
     */
    public void setActivated(Boolean activated) {
        JsonUtils.setBooleanProperty(properties, PROPERTY_ACTIVATED, activated);
    }

    /**
     * Get user status.
     * 
     * @return true is disabled.
     */
    @JsonSerialize(include = NON_NULL)
    public Boolean isDisabled() {
        return JsonUtils.getBooleanProperty(properties, PROPERTY_DISABLED);
    }

    /**
     * Set to disable user status.
     * 
     * @param disabled User status.
     */
    public void setDisabled(Boolean disabled) {
        JsonUtils.setBooleanProperty(properties, PROPERTY_DISABLED, disabled);
    }

    /**
     * Get first name.
     * 
     * @return First name
     */
    @JsonSerialize(include = NON_NULL)
    public String getFirstname() {
        return JsonUtils.getStringProperty(properties, PROPERTY_FIRSTNAME);
    }

    /**
     * Set first name.
     * 
     * @param firstname First name
     */
    public void setFirstname(String firstname) {
        JsonUtils.setStringProperty(properties, PROPERTY_FIRSTNAME, firstname);
    }

    /**
     * Get middle name.
     * 
     * @return Middle name
     */
    @JsonSerialize(include = NON_NULL)
    public String getMiddlename() {
        return JsonUtils.getStringProperty(properties, PROPERTY_MIDDLENAME);
    }

    /**
     * Set middle name.
     * 
     * @param middlename Middle name
     */
    public void setMiddlename(String middlename) {
        JsonUtils.setStringProperty(properties, PROPERTY_MIDDLENAME, middlename);
    }

    /**
     * Get last name.
     * 
     * @return Last name
     */
    @JsonSerialize(include = NON_NULL)
    public String getLastname() {
        return JsonUtils.getStringProperty(properties, PROPERTY_LASTNAME);
    }

    /**
     * Set last name.
     * 
     * @param lastname Last name
     */
    public void setLastname(String lastname) {
        JsonUtils.setStringProperty(properties, PROPERTY_LASTNAME, lastname);
    }

    /**
     * Get profile image URL.
     * 
     * @return Last name
     */
    @JsonSerialize(include = NON_NULL)
    public String getPicture() {
        return JsonUtils.getStringProperty(properties, PROPERTY_PICTURE);
    }

    /**
     * Set profile image URL.
     * 
     * @param picture Profile image URL
     */
    public void setPicture(String picture) {
        JsonUtils.setStringProperty(properties, PROPERTY_PICTURE, picture);
    }

    /**
     * Get facebook information.
     * 
     * @return Facebook information
     */
    @JsonSerialize(include = NON_NULL)
    public BaasioFacebook getFacebook() {
        return JsonUtils.getObjectProperty(properties, PROPERTY_FACEBOOK, BaasioFacebook.class);
    }

    /**
     * Set facebook information.
     * 
     * @param facebook Facebook information
     */
    public void setFacebook(BaasioFacebook facebook) {
        JsonUtils.setObjectProperty(properties, PROPERTY_FACEBOOK, facebook);
    }

    /**
     * Get user entity.
     * 
     * @return User entity
     */
    public BaasioUser get() throws BaasioException {
        BaasioBaseEntity entity = BaasioBaseEntity.get(getType(), getUniqueKey());
        return entity.toType(BaasioUser.class);
    }

    /**
     * Get user entity. Executes asynchronously in background and the callbacks
     * are called in the UI thread.
     * 
     * @param callback Result callback
     */
    public void getInBackground(final BaasioCallback<BaasioUser> callback) {
        (new BaasioAsyncTask<BaasioUser>(callback) {
            @Override
            public BaasioUser doTask() throws BaasioException {
                return BaasioUser.this.get();
            }
        }).execute();
    }

    /**
     * Sign-up.
     * 
     * @param username User name
     * @param name Name
     * @param email Email
     * @param password Password
     * @return Signed-up user
     */
    public static BaasioUser signUp(String username, String name, String email, String password)
            throws BaasioException {
        if (ObjectUtils.isEmpty(username)) {
            throw new IllegalArgumentException(BaasioError.ERROR_MISSING_USERNAME);
        }

        if (ObjectUtils.isEmpty(password)) {
            throw new IllegalArgumentException(BaasioError.ERROR_MISSING_PASSWORD);
        }

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(BaasioUser.PROPERTY_TYPE, BaasioUser.ENTITY_TYPE);
        if (username != null) {
            properties.put(BaasioUser.PROPERTY_USERNAME, username);
        }
        if (name != null) {
            properties.put(BaasioUser.PROPERTY_NAME, name);
        }
        if (email != null) {
            properties.put(BaasioUser.PROPERTY_EMAIL, email);
        }
        if (password != null) {
            properties.put("password", password);
        }

        BaasioResponse response = Baas.io().apiRequest(HttpMethod.POST, null, properties,
                BaasioUser.ENTITY_TYPE);

        if (response != null) {
            BaasioUser entity = response.getFirstEntity().toType(BaasioUser.class);
            if (!ObjectUtils.isEmpty(entity)) {
                return entity;
            }

            throw new BaasioException(BaasioError.ERROR_UNKNOWN_NORESULT_ENTITY);
        }

        throw new BaasioException(BaasioError.ERROR_UNKNOWN_NO_RESPONSE_DATA);
    }

    /**
     * Sign-up. Executes asynchronously in background and the callbacks are
     * called in the UI thread.
     * 
     * @param username User name
     * @param name Name
     * @param email Email
     * @param password Password
     * @param callback Result callback
     */
    public static void signUpInBackground(final String username, final String name,
            final String email, final String password, final BaasioSignUpCallback callback) {
        (new BaasioSignUpAsyncTask(callback) {
            @Override
            public BaasioUser doTask() throws BaasioException {
                return signUp(username, name, email, password);
            }
        }).execute();
    }

    /**
     * Sign-up via Facebook access token.
     * 
     * @param context Context
     * @param fb_access_token Facebook access token
     * @return Signed-up user
     */
    public static BaasioUser signUpViaFacebook(Context context, String fb_access_token)
            throws BaasioException {
        return signInViaFacebook(context, fb_access_token);
    }

    /**
     * Sign-up via Facebook OAuth token. Executes asynchronously in background
     * and the callbacks are called in the UI thread.
     * 
     * @param context Context
     * @param fb_access_token Facebook access token
     * @param callback Result callback
     */
    public static void signUpViaFacebookInBackground(final Context context,
            final String fb_access_token, final BaasioSignInCallback callback) {
        (new BaasioAsyncTask<BaasioUser>(callback) {
            @Override
            public BaasioUser doTask() throws BaasioException {
                return signUpViaFacebook(context, fb_access_token);
            }
        }).execute();
    }

    /**
     * Sign-in.
     * 
     * @param context Context
     * @param username User name
     * @param password Password
     * @return Signed-in user
     */
    public static BaasioUser signIn(Context context, String username, String password)
            throws BaasioException {
        if (ObjectUtils.isEmpty(username)) {
            throw new IllegalArgumentException(BaasioError.ERROR_MISSING_USERNAME);
        }

        if (ObjectUtils.isEmpty(password)) {
            throw new IllegalArgumentException(BaasioError.ERROR_MISSING_PASSWORD);
        }

        Map<String, Object> formData = new HashMap<String, Object>();
        formData.put("grant_type", "password");
        formData.put("username", username);
        formData.put("password", password);

        BaasioResponse response = Baas.io().apiRequest(HttpMethod.POST, formData, null, "token");

        if (response != null) {
            BaasioUser loggedInUser = response.getUser();
            String accessToken = response.getAccessToken();

            if (!ObjectUtils.isEmpty(loggedInUser) && !ObjectUtils.isEmpty(accessToken)) {
                Baas.io().setSignedInUser(loggedInUser);
                Baas.io().setAccessToken(accessToken);

                BaasioPreferences.setUserString(context, loggedInUser.toString());
                BaasioPreferences.setAccessToken(context, accessToken);

                BaasioPush.registerInBackground(context, null);

                return response.getUser();
            }

            throw new BaasioException(BaasioError.ERROR_UNKNOWN_NORESULT_ENTITY);
        }

        throw new BaasioException(BaasioError.ERROR_UNKNOWN_NO_RESPONSE_DATA);
    }

    /**
     * Sign-in. Executes asynchronously in background and the callbacks are
     * called in the UI thread.
     * 
     * @param context Context
     * @param username User name
     * @param password Password
     * @param callback Result callback
     */
    public static void signInInBackground(final Context context, final String username,
            final String password, final BaasioSignInCallback callback) {

        (new BaasioSignInAsyncTask(callback) {
            @Override
            public BaasioUser doTask() throws BaasioException {
                return signIn(context, username, password);
            }
        }).execute();
    }

    /**
     * Sign-in via Facebook access token.
     * 
     * @param context Context
     * @param fb_access_token Facebook access token
     * @return Signed-in user
     */
    public static BaasioUser signInViaFacebook(Context context, String fb_access_token)
            throws BaasioException {
        if (ObjectUtils.isEmpty(fb_access_token)) {
            throw new IllegalArgumentException(BaasioError.ERROR_MISSING_FACEBOOK_TOKEN);
        }

        Map<String, Object> formData = new HashMap<String, Object>();
        formData.put("fb_access_token", fb_access_token);

        BaasioResponse response = Baas.io().apiRequest(HttpMethod.POST, formData, null, "auth",
                "facebook");

        if (response != null) {
            BaasioUser loggedInUser = response.getUser();
            String accessToken = response.getAccessToken();

            if (!ObjectUtils.isEmpty(loggedInUser) && !ObjectUtils.isEmpty(accessToken)) {
                Baas.io().setSignedInUser(loggedInUser);
                Baas.io().setAccessToken(accessToken);

                BaasioPreferences.setUserString(context, loggedInUser.toString());
                BaasioPreferences.setAccessToken(context, accessToken);

                BaasioPush.registerInBackground(context, null);
                return response.getUser();
            }

            throw new BaasioException(BaasioError.ERROR_UNKNOWN_NORESULT_ENTITY);
        }

        throw new BaasioException(BaasioError.ERROR_UNKNOWN_NO_RESPONSE_DATA);
    }

    /**
     * Sign-in via Facebook access token. Executes asynchronously in background
     * and the callbacks are called in the UI thread.
     * 
     * @param context Context
     * @param fb_access_token Facebook access token
     * @param callback Result callback
     */
    public static void signInViaFacebookInBackground(final Context context,
            final String fb_access_token, final BaasioSignInCallback callback) {
        (new BaasioSignInAsyncTask(callback) {
            @Override
            public BaasioUser doTask() throws BaasioException {
                return signInViaFacebook(context, fb_access_token);
            }
        }).execute();
    }

    /**
     * Sign-out.
     * 
     * @param context Context
     */
    public static void signOut(Context context) {
        Baas.io().setSignedInUser(null);
        Baas.io().setAccessToken(null);

        BaasioPreferences.setAccessToken(context, "");
        BaasioPreferences.setUserString(context, "");

        BaasioPush.registerInBackground(context, null);
    }

    /**
     * Update entity from baas.io.
     * 
     * @return Updated entity
     */
    public BaasioUser update() throws BaasioException {
        if (ObjectUtils.isEmpty(getType())) {
            throw new IllegalArgumentException(BaasioError.ERROR_MISSING_TYPE);
        }

        if (ObjectUtils.isEmpty(getUuid()) && ObjectUtils.isEmpty(getUsername())) {
            throw new IllegalArgumentException(BaasioError.ERROR_MISSING_USER_UUID_OR_USERNAME);
        }

        BaasioResponse response = Baas.io().apiRequest(HttpMethod.PUT, null, this, getType(),
                getUuid().toString());

        if (response != null) {
            BaasioUser entity = response.getFirstEntity().toType(BaasioUser.class);
            if (!ObjectUtils.isEmpty(entity)) {
                return entity;
            }

            throw new BaasioException(BaasioError.ERROR_UNKNOWN_NORESULT_ENTITY);
        }

        throw new BaasioException(BaasioError.ERROR_UNKNOWN_NO_RESPONSE_DATA);
    }

    /**
     * Update entity from baas.io. Executes asynchronously in background and the
     * callbacks are called in the UI thread.
     * 
     * @param callback Result callback
     */
    public void updateInBackground(final BaasioCallback<BaasioUser> callback) {
        (new BaasioAsyncTask<BaasioUser>(callback) {
            @Override
            public BaasioUser doTask() throws BaasioException {
                return update();
            }
        }).execute();
    }

    /**
     * Unsubscribe.
     * 
     * @param context Context
     */
    public BaasioUser unsubscribe(Context context) throws BaasioException {
        if (ObjectUtils.isEmpty(getUsername())) {
            throw new IllegalArgumentException(BaasioError.ERROR_MISSING_USERNAME);
        }

        BaasioUser current = Baas.io().getSignedInUser();
        if (!ObjectUtils.isEmpty(current)) {
            if (!current.getUsername().equals(getUsername())) {
                LogUtils.LOGV(TAG, "Warning!! You try to delete a user who's not you.");
            }
        }

        BaasioResponse response = Baas.io().apiRequest(HttpMethod.DELETE, null, null, getType(),
                getUuid().toString());

        if (response != null) {
            BaasioUser entity = response.getFirstEntity().toType(BaasioUser.class);
            if (!ObjectUtils.isEmpty(entity)) {
                if (current.getUsername().equals(entity.getUsername())) {
                    signOut(context);
                }
                return entity;
            }

            throw new BaasioException(BaasioError.ERROR_UNKNOWN_NORESULT_ENTITY);
        }

        throw new BaasioException(BaasioError.ERROR_UNKNOWN_NO_RESPONSE_DATA);
    }

    /**
     * Unsubscribe. Executes asynchronously in background and the callbacks are
     * called in the UI thread.
     * 
     * @param context Context
     * @param callback Result callback
     */
    public void unsubscribeInBackground(final Context context,
            final BaasioCallback<BaasioUser> callback) {
        (new BaasioAsyncTask<BaasioUser>(callback) {
            @Override
            public BaasioUser doTask() throws BaasioException {
                return unsubscribe(context);
            }
        }).execute();
    }

    /**
     * Connect to a entity with relationship
     * 
     * @param relationship Relationship name
     * @param targetType Target entity type
     * @param targetUuid Target entity uuid or name
     * @return Connected user entity with class type
     */
    public BaasioUser connect(String relationship, String targetType, String targetUuid)
            throws BaasioException {

        BaasioBaseEntity entity = BaasioBaseEntity.connect(getType(), getUniqueKey(), relationship,
                targetType, targetUuid);
        return entity.toType(BaasioUser.class);
    }

    /**
     * Connect to a entity with relationship. Executes asynchronously in
     * background and the callbacks are called in the UI thread.
     * 
     * @param relationship Relationship name
     * @param targetType Target entity type
     * @param targetUuid Target entity uuid or name
     * @param callback Result callback
     */
    public void connectInBackground(final String relationship, final String targetType,
            final String targetUuid, final BaasioCallback<BaasioUser> callback) {
        (new BaasioAsyncTask<BaasioUser>(callback) {
            @Override
            public BaasioUser doTask() throws BaasioException {
                return connect(relationship, targetType, targetUuid);
            }
        }).execute();
    }

    /**
     * Connect to a entity with relationship
     * 
     * @param relationship Relationship name
     * @param target Target entity
     * @return Connected user entity with class type
     */
    public <T extends BaasioBaseEntity> BaasioUser connect(String relationship, T target)
            throws BaasioException {

        BaasioBaseEntity entity = BaasioBaseEntity.connect(getType(), getUniqueKey(), relationship,
                target.getType(), target.getUniqueKey());
        return entity.toType(BaasioUser.class);
    }

    /**
     * Connect to a entity with relationship. Executes asynchronously in
     * background and the callbacks are called in the UI thread.
     * 
     * @param relationship Relationship name
     * @param target Target entity
     * @param callback Result callback
     */
    public <T extends BaasioBaseEntity> void connectInBackground(final String relationship,
            final T target, final BaasioCallback<BaasioUser> callback) {
        (new BaasioAsyncTask<BaasioUser>(callback) {
            @Override
            public BaasioUser doTask() throws BaasioException {
                return connect(relationship, target);
            }
        }).execute();
    }

    /**
     * Disconnect to a entity with relationship
     * 
     * @param relationship Relationship name
     * @param targetType Target entity type
     * @param targetUuid Target entity uuid or name
     * @return Disconnected user entity with class type
     */
    public BaasioUser disconnect(String relationship, String targetType, String targetUuid)
            throws BaasioException {

        BaasioBaseEntity entity = BaasioBaseEntity.disconnect(getType(), getUniqueKey(),
                relationship, targetType, targetUuid);
        return entity.toType(BaasioUser.class);
    }

    /**
     * Disconnect to a entity with relationship. Executes asynchronously in
     * background and the callbacks are called in the UI thread.
     * 
     * @param relationship Relationship name
     * @param targetType Target entity type
     * @param targetUuid Target entity uuid or name
     * @param callback Result callback
     */
    public void disconnectInBackground(final String relationship, final String targetType,
            final String targetUuid, final BaasioCallback<BaasioUser> callback) {
        (new BaasioAsyncTask<BaasioUser>(callback) {
            @Override
            public BaasioUser doTask() throws BaasioException {
                return disconnect(relationship, targetType, targetUuid);
            }
        }).execute();
    }

    /**
     * Disconnect to a entity with relationship
     * 
     * @param relationship Relationship name
     * @param target Target entity
     * @return Disconnected user entity with class type
     */
    public <T extends BaasioBaseEntity> BaasioUser disconnect(String relationship, T target)
            throws BaasioException {

        BaasioBaseEntity entity = BaasioBaseEntity.disconnect(getType(), getUniqueKey(),
                relationship, target.getType(), target.getUniqueKey());
        return entity.toType(BaasioUser.class);
    }

    /**
     * Disconnect to a entity with relationship. Executes asynchronously in
     * background and the callbacks are called in the UI thread.
     * 
     * @param relationship Relationship name
     * @param target Target entity
     * @param callback Result callback
     */
    public <T extends BaasioBaseEntity> void disconnectInBackground(final String relationship,
            final T target, final BaasioCallback<BaasioUser> callback) {
        (new BaasioAsyncTask<BaasioUser>(callback) {
            @Override
            public BaasioUser doTask() throws BaasioException {
                return disconnect(relationship, target);
            }
        }).execute();
    }
}
