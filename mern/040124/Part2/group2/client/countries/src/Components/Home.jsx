import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css'
import axios from 'axios'
const Home = () => {
  const [allCountries, setAllCountries] = useState([])
  const nav=useNavigate()
  useEffect(() => {
    axios.get('http://localhost:8000/api/countries')
      .then(res => setAllCountries(res.data))
      .catch(err => console.log("you have an error on fetch countries ", err))
  }, [])

  const deleteObj=(id)=>{
    axios.delete(`http://localhost:8000/api/countries/delete/${id}`)
    .then(res=>{setAllCountries(allCountries.filter(c=>c._id !== id))})
    .catch(err=>console.log("you have an error on deleteObj ",err))
  }

  return (
    <div>
      <h1>Countries List</h1>
      <Link to='/country/new' className='btn btn-primary mb-3'>New Country</Link>

      <table className='table table-sm table-bordered'>
        <thead>
          <tr>
            <th>Name</th>
            <th>Flag</th>
            <th>Independent</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {allCountries.map(country => (
            <tr key={country._id}>
              <td><Link to={`/country/${country._id}`}>{country.name}</Link></td>
              <td><img src={country.flag} height={50} /></td>
              <td>{country.independent ? 'Yes' : 'No'}</td>
              <td>
                <button className="btn btn-sm btn-primary" onClick={() => nav(`/country/edit/${country._id}`)}>Edit</button>
                <button className="btn btn-sm btn-danger" onClick={() => deleteObj(country._id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default Home