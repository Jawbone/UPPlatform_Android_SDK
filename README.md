![image](https://d3osil7svxrrgt.cloudfront.net/static/www/logos/jawbone/jawbone-logo-lowres.png)
# UP Platform Android SDK
## Overview and Requirements
The UP Platform Android SDK is released as a library to perform requests to UP Platform API from Android devices. It handles authentication using OAuth 2.0 via a WebView and also provides interfaces to make network requests to the UP platform's REST endpoints. Note that currently not all interfaces are implemented but they will be soon.  
It is assumed that the SDK users are familiar with Java programming language and Google’s Android SDK. The SDK has been developed on a MacBook Pro running OS X Mavericks and Android Studio 0.8.1 and supports all Android versions from 4.0 onwards. It is also assumed that the user has access to an existing Jawbone UP user account in order to authenticate with the UP platform. New accounts can be created at [jawbone.com/start/signup](http://jawbone.com/start/signup). Note that the user will also need to register at [Jawbone UP Developer Portal](http://jawbone.com/up/developer) and create an app in order to get the **CLIENT_ID** and **CLIENT_SECRET** constant values needed for OAuth authentication.

## Table of Contents

- [Getting Started](#getting-started)
  - [Obtain Your OAuth Credentials](#obtain-your-oauth-credentials)
  - [Download the Jawbone UP Android SDK](#download-the-jawbone-up-android-sdk)
  - [Project Setup and Usage Instructions](#project-setup-and-usage-instructions)
- [Documentation](#documentation)
  - [Authentication](#authentication)
  - [TBD](#TBD)
- [Additional Resources](#additional-resources)
- [Terms of Service](#terms-of-service)
- [API Status](#api-status)
- [Support](#support)
- [Credits](#credits)
- [License](#license)

## Getting Started

#### Obtain Your OAuth Credentials
Sign into the [Jawbone UP Developer Portal](http://jawbone.com/up/developer) using your Jawbone UP account. If you do not have an account you can create one by going to [jawbone.com/start/signup](http://jawbone.com/start/signup). Register your organization by pressing "Manage Account". Follow the instructions to create a new app and get your OAuth Client ID and App Secret keys that you will use to authenticate with the UP Platform.  
Specify your custom redirect URI in the "OAuth Redirect URI" field or use the default value up-platform://redirect. Note that for Android SDK this url is redundant, we will never leave the app and thus won't need to be redirected to it. But the OAuth specification calls for it and this architecture is also used by Jawbone for web based OAuth authentication so we leave it here. Suffice to say whatever non-null uri is entered here should be the same used in app.


#### Download the Jawbone UP Android SDK
You can download the latest Android SDK release via the link below or clone it directly from this GitHub repository:

**Option 1:** Download UP Android SDK Alpha (July 2014)  
`https://github.com/Jawbone/UPPlatform_Android_SDK/tag/v0.1-alpha`

**Option 2:** Clone this repository from GitHub  
`git clone git@github.com:Jawbone/UPPlatform_Android_SDK`

#### Project Setup and Usage Instructions
UpPlatformSdk is being distributed as an Android Library project, and thus can be imported in an existing project as a "Module" (we do this in Android Studio by "File" -> "Import Module.." in Android Studio menu). The current project structure as uploaded in Github (seen below) has the SDK already imported and the HelloUp app in Examples folder uses it. 

![Project Structure]
(Documentation/project_structure.png)

UpPlatformSdk is the main library module that provides OAuth authentication, API end points, data model and a Volley based network stack that handles the API calls. The HelloUp project in Examples folder is the test app and has UpPlatformSdk as its library dependency, and provides **CLIENT_ID** and **CLIENT_SECRET** viz. the app specific credentials generated from Jawbone UP Developer Portal. Note that even though this project structure assumes Android Studio as the IDE used, but these instructions can be modified for use in Eclipse IDE too.

There are two ways to quickly get started with using the SDK:
* Clone this repo, open the project in Android Studio and then, either modify HelloUp app to suit your needs or just create another project for your app and start using the SDK.
* Clone this repo, and then in your own project import the SDK and start using it. Another thing to note is, because we are using the __OauthWebViewActivity__ from a library project, it needs to be added to the app's manifest file (in this case HelloUp's AndroidManifest.xml)

## Documentation
#### Authentication
The developer obtains the **CLIENT_ID** and **CLIENT_SECRET** from the Developer Portal, sets them up in his app as constants (in this case in HelloUp app).   
``` Java
private static final String CLIENT_ID = "CCVLFloNu8c";  
private static final String CLIENT_SECRET = "e239462834aa6fc899f84a754f855f56";
```

We then define the permissions needed and then pass them to __UpApiWrapper__ which is a singleton class setup to handle all authentication and API requests.  
``` Java
upApiWrapper.setUserCredentials(CLIENT_ID, CLIENT_SECRET, OAUTH_CALLBACK_URL, authScope);
```

We then call get the webview intent and launch the OAuth flow.  
``` Java
Intent intent = upApiWrapper.getIntentForWebView();  
startActivityForResult(intent, UpPlatformSdkUtils.JAWBONE_AUTHORIZE_REQUEST_CODE);  
```
The user will sign in with his username/password with his UP user credentials as displayed in the Webview. When the user agrees with the permissions requested and hits okay button the response from server will contain a “code”. This is parsed out and another network call is made whose response will contain the accessToken and refreshToken, which __HelloUpActivity__ saves to shared preferences for easy access. Thus the app now has the accessToken needed to make api requests.

``` Java
public void onResponse(OauthAccessTokenResponse response, int statusCode, VolleyError error) {  
    if (response != null) {  
        mAccessTokenFromServer = response.accessToken;  
        mRefreshToken = response.refreshToken;  
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(HelloUpActivity.this);  
        SharedPreferences.Editor editor = preferences.edit();  
        editor.putString(UP_PLATFORM_ACCESS_TOKEN,mAccessTokenFromServer);  
        editor.putString(UP_PLATFORM_REFRESH_TOKEN,mRefreshToken);  
        editor.commit();  
        Intent intent = new Intent(HelloUpActivity.this, UpApiListActivity.class);  
        startActivity(intent);  
    }  
}
```

Now there are a few ways to create API requests. You can use either
the provided objects that encapsulate most of the available endpoints, or you can create custom requests. The API objects are the simplest way to create requests to the REST platform. They take care of creating requests objects, handling responses parsed out from JSON.



## Additional Resources
You can find additional Jawbone UP Platform documentation [here](http://jawbone.com/start/signup)  
We use 3 different open source libraries in this SDK, they are:  
* [Google Volley](https://android.googlesource.com/platform/frameworks/volley/) - to provide basic networking capabilities for API requests. It is included in this repo as a jar file.  
* [Jackson Parser](http://jackson.codehaus.org/) – to handle incoming and outgoing JSON objects.  
* [Volley-Jackson-Extension](https://github.com/spothero/volley-jackson-extension) – to integrate JSON objects handling with Volley.  


## Terms of Service
Key principles governing the use of the UP API:  
* The data belongs to the user. We are stewards of the data and have an obligation to protect it and use it responsibly.  
* Data can only be collected with explicit user permission. Only collect what you need and only use it as you say you will.  
* User must have a mechanism to disable access and to request that any collected data be deleted.  
* Use of the UP API is governed by the [UP API Terms Of Service](https://jawbone.com/up/developer/terms).
* By using the API, you agree to the TOS, available for your review.

## API Status

Please visit UP Platform's [status page](http://status.jawbone.com/) to see the platform status updated in real-time.

## Support

Follow us on Twitter [@JawboneDev](https://twitter.com/jawbonedev) to get the latest news and updates regarding the API.

Contact the developer support team by sending an email to apisupport@jawbone.com.

## TODO
* Complete all API calls  
* Add Javadocs
* Add Unit tests
* Setup the SDK as an AAR file

## Credits
*Omer Muhammed* – Principal Software Engineer

## License
Usage is provided under the Apache License (v2.0). The licenses for the open source libraries used are different.
