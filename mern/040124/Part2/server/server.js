const express = require("express");
const cors = require('cors')
const app = express();
require("dotenv").config();
const port = process.env.port;
// === MIDDLEWARE ===
app.use(express.json(), express.urlencoded({ extended: true }), cors());

// grab the config
require("./config/mongoose.config");
// grab the routes
require("./routes/user.route")(app);

app.listen(port, () => {
  console.log("Listenning to port " + port);
});