const session = require('express-session');
const { ExpressOIDC } = require('@okta/oidc-middleware');
const OktaJwtVerifier = require('@okta/jwt-verifier');

const oktaJwtVerifier = new OktaJwtVerifier({
	issuer: 'issuer',
	clientId: 'client-id'
});

class AuthenticationMiddleware {

	constructor() {
		this.session = session({
			secret: 'this should be secure',
			audience: 'this should be secure',
			resave: true,
			saveUninitialized: false
		});

		this.oidc = new ExpressOIDC({
			issuer: 'issuer',
			client_id: 'client-id',
			client_secret: 'client-secret',
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

			const { claims: { sub } } = await oktaJwtVerifier.verifyAccessToken(token, 'api://default');
			req.userId = sub;
			next();
		} catch (error) {
			res.json({ error: error.message });
		}
	}
}

module.exports = new AuthenticationMiddleware();