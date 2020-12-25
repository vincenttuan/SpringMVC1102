<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Google Login Page</title>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="889955278565-585vm9tbd9nbfnm58t609j8s64cnkui6.apps.googleusercontent.com">
        <script>
            function onSignIn(googleUser) {
                var profile = googleUser.getBasicProfile();
                console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
                console.log('Name: ' + profile.getName());
                console.log('Image URL: ' + profile.getImageUrl());
                console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
                // 將 id_token Post 到 mvc/login/check
                var id_token = googleUser.getAuthResponse().id_token;
                console.log('id_token: ' + id_token);
                window.document.getElementById('id_token').value = id_token;
                window.document.getElementById('myform').submit();
            }
            function signOut() {
                var auth2 = gapi.auth2.getAuthInstance();
                auth2.signOut().then(function () {
                    console.log('User signed out.');
                });
            }
        </script>
    </head>
    <body>
        <h1>Google Login</h1>
        <div class="g-signin2" data-onsuccess="onSignIn"></div>
        <a href="#" onclick="signOut();">Sign out</a>
        <form id="myform" name="myform" method="post" action="mvc/login/check">
            <input type="hidden" id="id_token" name="id_token" /> 
        </form>
    </body>
</html>
