import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import axios from "axios"

const Edit = () => {
    const {id}=useParams();
    const nav = useNavigate()
    const [country,setCountry]=useState({name:"",flag:"",independant:false})
    const [error,setError]=useState([])
    useEffect(()=>{
        axios.get(`http://127.0.0.1:8000/api/countries/${id}`)
        .then(res=>setCountry(res.data))
        .catch(err=>{console.log("❌❌❌",err)})
    },[])

    const editHandler = (e)=>{
        e.preventDefault();
        axios.put(`http://127.0.0.1:8000/api/countries/update/${id}`,country)
            .then(res=>{console.log(res); nav("/")})
            .catch(err=>{
                console.log("❌❌❌",err.response);
                setError(err.response.data.errors)
            })
    }
  return (
    <div>
        <h1>Add New Country</h1>
      <form onSubmit={editHandler}>
        <div className='container'>
            <label className='form-label'>Name:</label>
            <input type="text" className='form-control' id='name' onChange={e=>setCountry({...country,name:e.target.value})} value={country.name}/>
            {error.name? <h4 className='text-danger'>{error.name.message}</h4>:<p></p>}

            <label className='form-label'>Flag:</label>
            <input type="text" className='form-control' id='flag' onChange={e=>setCountry({...country,flag:e.target.value})} value={country.flag}/>

            <label className='form-label'>Independence:</label>
            <input type='checkbox' id='independant' onChange={e=>setCountry({...country,independant:e.target.checked})} checked={country.independant}/>
        </div>
        <button className='btn btn-primary'>ADD COUNTRY</button>
      </form>
    </div>
  )
}

export default Edit