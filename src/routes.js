'use strict';

const UserController = require('./controllers/UserController');
const { oidc } = require('./authentication/AuthenticationMiddleware');
const routes = require('express').Router();

routes.get("/", (req, res, next) => {
    res.send('Hello world!');
});

routes.post('/users', oidc.ensureAuthenticated(), UserController.register);
routes.get('/users', oidc.ensureAuthenticated(), UserController.getUsers);
routes.get('/users/self', oidc.ensureAuthenticated(), UserController.getSelf);

module.exports = routes;
