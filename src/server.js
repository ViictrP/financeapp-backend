'use strict';
const { User } = require('./models');

const app = require('./app');
app.listen(3000, () => {
	console.log('Listening to port 3000');
});
