const { User } = require('../models');

class UserController {

    async register(req, res) {
        const user = req.body;
        const saved = await User.create(user);
        res.json(saved);
    }

    async getUsers(req, res) {
        const users = await User.findAll();
        return res.json(users);
    }

    async getSelf(req, res) {
        res.send(JSON.stringify(req.userContext));
    }
}

module.exports = new UserController();