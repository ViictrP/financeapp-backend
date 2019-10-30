'use strict';

const UserController = require('./controllers/UserController');

const routes = require('express').Router();

routes.get("/", (req, res, next) => {
    res.send('Hello world!');
});

routes.post('/users', UserController.register);

module.exports = routes;
