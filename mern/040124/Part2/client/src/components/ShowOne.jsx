import React from 'react'
import { useEffect } from 'react'
import { useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { Navigate } from 'react-router-dom'
import axios from 'axios'


function ShowOne() {
    const [country, setCountry] = useState({})
    const { id } = useParams();
    const nav = useNavigate()

    useEffect(() => {
        axios.get('http://localhost:8000/api/country/' + id)
            .then(res => setCountry(res.data))
            .catch(err => console.error(err));
    }, []);
    return (
    <div class="container mt-5">
        <div class="card">
            <h3>{country.name} Details</h3>
            <div class="card-body">
                <p>Name: {country.name}</p>
                <p>Flag: <img src={country.flag} alt="" height={50}/></p>
                <p>Independent: {country.independent ? 'Yes' : 'No'}</p>
                <button className="btn btn-secondary" onClick={() => nav('/')}>Home</button>
                <button className="btn btn-sm btn-primary" style={{width:"70px",height:"38px"}} onClick={() => nav(`/country/edit/${country._id}`)}>Edit</button>
            </div>
        </div>
    </div>
    )
}

export default ShowOne