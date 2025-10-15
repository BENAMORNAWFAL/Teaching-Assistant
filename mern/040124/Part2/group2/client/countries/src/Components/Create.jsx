import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'
const Create = () => {

  const [country, setCountry] = useState({ name: "", flag: "", independent: false })
  const nav=useNavigate()
  const [errors,setErrors]=useState([])
  const onSubmitHandle = (e) => {
      e.preventDefault();
      axios.post('http://localhost:8000/api/countries/new',country)
        .then(res=>{console.log(res) ;nav('/')})
        .catch(err=>{
          // console.log("******",err.response)
          setErrors(err.response.data.errors)
        })
  }


  return (
    <div>
      <form onSubmit={onSubmitHandle}>
        <h1>Add New Country</h1>
        {/* input name of country */}
        <div>
          <label htmlFor="name" className='form-label'>Name:</label>
          <input type="text" className='form-control' id="name"
            onChange={e => setCountry({ ...country, name: e.target.value })} value={country.name} />
            {errors.name &&<p className='text-danger'>{errors.name.message}</p>}
        </div>
        {/* input flag path of country */}
        <div>
          <label htmlFor="flag" className='form-label'>Flag:</label>
          <input type="text" className='form-control' 
            onChange={e => setCountry({ ...country, flag: e.target.value })} value={country.flag} />
            {errors.flag &&<p className='text-danger'>{errors.flag.message}</p>}
        </div>
        {/* input checkbox for country isIndependent */}
        <div>
          <label htmlFor="independent" className='form-label'>Independent:</label>
          <input type="checkbox" 
            onChange={e => setCountry({ ...country, independent: e.target.checked })} />
        </div>
        <button type="submit" className='btn btn-primary'>Submit</button>
        <button className='btn btn-primary' onClick={()=>nav('/')} >Cancel</button>
      </form>
    </div>
  )
}

export default Create