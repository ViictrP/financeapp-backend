const session = require('express-session');
const { ExpressOIDC } = require('@okta/oidc-middleware');
const OktaJwtVerifier = require('@okta/jwt-verifier');

const oktaJwtVerifier = new OktaJwtVerifier({
	issuer: 'https://dev-894588.okta.com/oauth2/default',
	clientId: '0oa1ph9tn79K0KLGY357'
});

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
			scope: 'openid profile',
			appBaseUrl: 'http://localhost:3000'
		});
	}

	async requireUser(req, res, next) {
		try {
			const { authorization } = req.headers;
			if (!authorization) throw new Error('You must send an Authorization header');

			const [authType, token] = authorization.split(' ');
			if (authType !== 'Bearer') throw new Error('Expected a Bearer token');

			const { claims: { sub } } = await oktaJwtVerifier.verifyAccessToken(token);
			req.userId = sub;
			next();
		} catch (error) {
			res.json({ error: error.message });
		}
	}
}

module.exports = new AuthenticationMiddleware();