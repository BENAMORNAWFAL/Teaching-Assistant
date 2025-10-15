import React from 'react'
import axios from 'axios'
import { useState } from 'react'
import { useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { Link } from 'react-router-dom'

function CountriesList() {
    const [countries, setCountries] = useState([]);
    const nav = useNavigate();
    useEffect(() => {
        axios.get('http://localhost:8000/api/countries')
            .then(res => {
                setCountries(res.data);
            })
            .catch(err => console.error(err));
    }, []);
    const deleteObj = (id) => {
        axios.delete(`http://localhost:8000/api/country/delete/${id}`)
            .then(res => {
                setCountries(countries.filter(c => c._id !== id));
            })
            .catch(err => console.error(err));
    };

    return (
        <>
            <div className="container mt-5">
                <h1>Countries List</h1>
                <Link to="/country/new" className="btn btn-primary mb-3">New Country</Link>
                <table className="table table-sm table-bordered">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Flag</th>
                            <th>Independent</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {countries.map(c => (
                            <tr key={c._id}>
                                <td>
                                    <Link to={`/country/${c._id}`}>
                                        {c.name}
                                    </Link>
                                </td>
                                <td> <img src={c.flag} alt="" height={50}/> </td>
                                <td>{c.independent ? 'Yes' : 'No'}</td>
                                <td>
                                    <button className="btn btn-sm btn-primary" onClick={() => nav(`/country/edit/${c._id}`)}>Edit</button>
                                    <button className="btn btn-sm btn-danger" onClick={() => deleteObj(c._id)}>Delete</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>

        </>
    )
}

export default CountriesList