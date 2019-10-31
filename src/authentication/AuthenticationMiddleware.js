const session = require('express-session');
const { ExpressOIDC } = require('@okta/oidc-middleware');

class AuthenticationMiddleware {

    constructor() {
        this.session = session({
            secret: 'this should be secure',
            resave: true,
            saveUninitialized: false
        });

        this.oidc = new ExpressOIDC({
            issuer: 'https://dev-894588.okta.com/oauth2/default',
            client_id: '0oa1ph9tn79K0KLGY357',
            client_secret: 'R7vE0-1Ec0mJivNcY-BOqSJ0Aie5E944WOqE9QYN',
            redirect_uri: 'http://localhost:3000/authorization-code/callback',
            scope: 'openid profile',
            appBaseUrl: 'http://localhost:3000'
        })
    }
}

module.exports = new AuthenticationMiddleware();