'use strict';

const express = require('express');
const authMiddleware = require('./authentication/AuthenticationMiddleware');

class AppController {
    
    constructor() {
        this.express = express();
        this.middleware();
        this.routes();
    }

    middleware() {
        this.express.use(authMiddleware.session);
        this.express.use(authMiddleware.oidc.router);
        this.express.use(express.json());
    }

    routes() {
        this.express.use(require('./routes'));
    }
}

module.exports = new AppController().express;
