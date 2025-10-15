const mongoose = require('mongoose');
const CountrySchema = new mongoose.Schema({
    name: { type: String,
        required: [true,"{PATH} is required"],
        minlength: [3, "{PATH} must be at least 3 chars"]
    },
    flag: { type: String,
        required: [true,"{PATH} is required"],
        minlength: [8, "{PATH} must be at least 8 chars"]
    },
    independent: { type: Boolean,
        required: [true,"{PATH} is required"]
    }
}, { timestamps: true });
module.exports.Country = mongoose.model('Country', CountrySchema);