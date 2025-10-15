import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'
import 'bootstrap/dist/css/bootstrap.min.css'

const Create = () => {
    const [name,setName]=useState("")
    const [flag,setFlag]=useState("")
    const [independent,setIndependent]=useState(false)
    const [erros,sertErrors]=useState([])
    const nav = useNavigate()
    const onSubmitHandle=(e)=>{
        e.preventDefault();
        axios.post('http://localhost:8000/api/country',{name,flag,independent})
        .then(res=>{console.log(res);nav('/')})
        .catch(err=>{
            const errorResponse=err.response.data.errors
            sertErrors(errorResponse)
        })
    }


  return (
    <div>
        <form className="container" onSubmit={onSubmitHandle}>
            <h1>Add New Country</h1>
            <div>
                <label htmlFor="name" className='form-label'>Name:</label>
                <input type="text" className='form-control' id="name" 
                onChange={e=>setName(e.target.value)} value={name} />
                {erros.name &&<p className='text-danger'>{erros.name.message}</p>}
            </div>
            <div>
                <label htmlFor="flag" className='form-label'>Flag:</label>
                <input type="text" className='form-control' id="flag" 
                onChange={e=>setFlag(e.target.value)} value={flag} />
                {erros.flag &&<p className='text-danger'>{erros.flag.message}</p>}
            </div>
            <div>
                <label htmlFor="independent" className='form-label'>Independent:</label>
                <input type="checkbox" checked={independent}   
                onChange={e=>setIndependent(e.target.checked)} />
            </div>
        <div className='d-flex justify-content-between'>
            <button type='submit' className='btn btn-primary'>Submit</button>
            <button className='btn btn-secondary' onClick={()=>nav('/')}>Cancel</button>
        </div>
        </form>
    </div>
  )
}

export default Create