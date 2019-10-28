const routes = require('express').Router();

routes.use("/", (req, res, next) => {
    res.send('Hello world!');
});

module.exports = routes;