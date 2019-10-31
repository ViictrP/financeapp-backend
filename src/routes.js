'use strict';

const UserController = require('./controllers/UserController');
const { requireUser, oidc } = require('./authentication/AuthenticationMiddleware');
const routes = require('express').Router();

routes.get("/", oidc.ensureAuthenticated(),  (req, res, next) => {
    res.send(req.userContext.tokens.access_token);
});

routes.post('/users', requireUser, UserController.register);
routes.get('/users', requireUser, UserController.getUsers);
routes.get('/users/self', requireUser, UserController.getSelf);

module.exports = routes;
