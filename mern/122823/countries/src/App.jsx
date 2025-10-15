import { useState } from 'react'
import './App.css'
import axios from "axios"
import Display from './Components/Display'
import 'bootstrap/dist/css/bootstrap.min.css'
function App() {
  const [countries,setCountries]=useState([])
  const [newC,setNewC]=useState("")
  const [newF,setNewF]=useState("")
  const fetchCountries=()=>{
    axios.get("https://restcountries.com/v3.1/all")
      .then(res=>{console.log("******",res.data);setCountries(res.data)})
      .catch(err=>console.log("you have an error",err))
  }
  const handleInput=(e)=>{
    e.preventDefault();
    setCountries([...countries,{name:{common:newC},flags:{png:newF}}])
    setNewC("")
    setNewF("")
  }

  const updateCountry = (id) => {
   const newList= countries
   newList[id].independent= !newList[id].independent
   setCountries(newList)
  }


  const deleteCountry=(id)=>{
    setCountries(countries.filter((c,i)=> i !== id))
    console.log(countries)
  }

  return (
    <div className='App'>
      <form onSubmit={(e)=>{handleInput(e)}}>
          <label >Name: </label>
          <input type="text"  className='form-control' onChange={(e)=>{setNewC(e.target.value)}} value={newC}/>
          <label>Flag: </label>
          <input type="text"  className='form-control' onChange={(e)=>{setNewF(e.target.value)}} value={newF}/>
          <button className='btn btn-primary'>Add</button>
      </form>
      <button onClick={fetchCountries}>Fetch Countries</button>
      <table className='table table-bordered'>
            <tr>
                <th>Country Name</th>
                <th>Flag</th>
                <th>Actions</th>
            </tr>
        {countries.map((country,index)=>{
          return <Display country={country} index={index} deleteCountry={deleteCountry} updateCountry={updateCountry} />
        })}
        </table>
    
    </div>
  )
}

export default App
