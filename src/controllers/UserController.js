const { User } = require('../models');

class UserController {

    async register(req, res) {
        const user = req.body;
        const saved = await User.create(user);
        res.json(saved);
    }
}

module.exports = new UserController();