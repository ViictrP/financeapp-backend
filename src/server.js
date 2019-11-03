'use strict';

const app = require('./app');
const { oidc } = require('./authentication/AuthenticationMiddleware');

oidc.on('ready', () => {
	app.listen(3000, () => {
		console.log('Listening to port 3000');
	});
});

oidc.on('error', () => {
	console.log('Unable to configure ExpressOIDC', err);
});
