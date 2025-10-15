// import the mongoose lib
const mongoose = require("mongoose");

// the model

const CountriesSchema = new mongoose.Schema(
  {
    name: {
      type: String,
      required: [true, "{PATH} is required"],
      minLength: [3, "{PATH} must be at least 3 characters"],
    },
    flag: {
      type: String,
      required: [true, "{PATH} is required"],
    },
    independent: {
      type: Boolean,
    }
  },
  { timestamps: true }
);

const Country = mongoose.model("Movie", CountriesSchema);

module.exports = Country;