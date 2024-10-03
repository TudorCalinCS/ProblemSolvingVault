require('dotenv').config();

const { name } = require('body-parser');
const mongoose = require('mongoose');
mongoose.connect(process.env.MONGO_URI)
  .then(() => console.log("Connected to MongoDB"))
  .catch((err) => console.log(`DB connection error - ${err}`));

var Schema = mongoose.Schema;
const personSchema = new Schema({
  name: { type: String, required: true },
  age: Number,
  favoriteFoods: [String]
});

const Person = mongoose.model("Person", personSchema);



const createAndSavePerson = async (done) => {
  const data = new Person({
    name: "theName",
    age: 20,
    favouriteFoods: ["Sushi"]
  });
  const createdPerson = await data.save()
  done(null, createdPerson);
};

const createManyPeople = async (arrayOfPeople, done) => {
  let newPerson = await Person.create(arrayOfPeople)

  done(null, newPerson)
};

const findPeopleByName = async (personName, done) => {

  let searched = await Person.find({ name: personName });

  done(null, searched);
};

const findOneByFood = async (food, done) => {

  let searched = await Person.findOne({ favoriteFoods: food })

  done(null, searched);
};

const findPersonById = async (personId, done) => {

  let searched = await Person.findById({ _id: personId });

  done(null, searched);
};

const findEditThenSave = async (personId, done) => {
  const foodToAdd = "hamburger";
  let searched = await Person.findById({ _id: personId });
  searched.favoriteFoods.push(foodToAdd);
  let updatedPerson = await searched.save();
  done(null, updatedPerson);
};

const findAndUpdate = async (personName, done) => {
  const ageToSet = 20;
  let searched = await Person.findOneAndUpdate({ name: personName }, { age: ageToSet }, { new: true });
  done(null, searched);
};

const removeById = async (personId, done) => {
  let removed = await Person.findByIdAndDelete({ _id: personId });
  done(null, removed);
};

const removeManyPeople = async (done) => {
  const nameToRemove = "Mary";
  /*
  try {
    const response = await Person.deleteMany({ name: nameToRemove }); // Use deleteMany
    console.log(response); // Log the response object
    
    // Call done with a structured object
    done(null, { message: "Deletion successful", deletedCount: response.deletedCount });
  } catch (error) {
    console.error("Error occurred while deleting:", error);
    done(error); // Pass the error to the callback
  }
    */
   Person.deleteMany({name: nameToRemove},(error, removalInfo)=>{
    if(error) return console.log(error);
    done(null, {n: removalInfo.deletedCount, ok:1});
   })
};

const queryChain = async (done) => {
  const foodToSearch = "burrito";
  Person.find({ favoriteFoods: foodToSearch })
  .sort({name: 1})
  .limit(2)
  .select({age:false})
  .exec(function(error, people){
    done(null,people);
  });
};

/** **Well Done !!**
/* You completed these challenges, let's go celebrate !
 */

//----- **DO NOT EDIT BELOW THIS LINE** ----------------------------------

exports.PersonModel = Person;
exports.createAndSavePerson = createAndSavePerson;
exports.findPeopleByName = findPeopleByName;
exports.findOneByFood = findOneByFood;
exports.findPersonById = findPersonById;
exports.findEditThenSave = findEditThenSave;
exports.findAndUpdate = findAndUpdate;
exports.createManyPeople = createManyPeople;
exports.removeById = removeById;
exports.removeManyPeople = removeManyPeople;
exports.queryChain = queryChain;
