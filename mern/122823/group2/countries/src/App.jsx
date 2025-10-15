import { useState } from 'react'
import axios from 'axios'
import './App.css'
import Display from './Components/Display'
import 'bootstrap/dist/css/bootstrap.min.css'


function App() {
  const [countries, setCountries] = useState([])
  const [newC,setNewC]=useState("")
  const [newF,setNewF]=useState("")

  const hundleSubmit=(e)=>{
    e.preventDefault();
    setCountries([...countries,{name:{common:newC},flags:{png:newF}}])
    setNewC("")
    setNewF("")
  }
  // Function delete countries
  const deleteCountry=(idx)=>{
    setCountries(countries.filter((c,i)=> i !== idx))
  }

  //  update country from checkbox input
  const updateCountry=(id)=>{
    const  newList=countries
    newList[id].independent= !newList[id].independent
    setCountries(newList)
  }

  // fetch countries from apirest
  const fetchCountries = () => {
    axios.get("https://restcountries.com/v3.1/all").then((res) =>{ console.log(res.data); setCountries([...countries,...res.data])}).catch(err => console.log("you have an error", err))
  }
  return (
    <div className="App">
      <form onSubmit={hundleSubmit}>
        <label >Name :</label>
        <input type="text" onChange={(e)=>{setNewC(e.target.value)}} value={newC} className='form-control'></input>
        <label >Flag :</label>
        <input type="text" onChange={(e)=>{setNewF(e.target.value)}} value={newF} className='form-control'></input>
        <button className='btn btn-primary'>Add Country</button>
      </form>
      <button onClick={fetchCountries}>Fetch Countries</button>
      <table>
        <tr>
          <th>Country Name</th>
          <th>Flag</th>
          <th>Actions</th>
        </tr>
        {countries.map((country,index)=>{
          return <Display country={country} index={index} deleteCountry={deleteCountry}  updateCountry={updateCountry} />
        })}
      </table>
    </div>

  )
}

export default App
