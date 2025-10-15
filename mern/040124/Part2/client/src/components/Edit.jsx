import React from 'react'
import { useState } from 'react'
import { useEffect } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'
import { useParams } from 'react-router-dom'


function Edit() {
    const { id } = useParams();
    const nav = useNavigate();
    const [name, setName] = useState("")
    const [flag, setFlag] = useState("")
    const [independent, setIndependent] = useState(false)
    const [errors, setErrors] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8000/api/country/' + id)
            .then(res => {
                setName(res.data.name);
                setFlag(res.data.flag);
                setIndependent(res.data.independent);
            });
    }, [id]);


    const update = (e) => {
        e.preventDefault();
        axios.put('http://localhost:8000/api/country/update/' + id, {
            name, flag, independent
        })
            .then(res => {
                console.log(res);
                nav('/');
            })
            .catch(err => {
                const errorResponse = err.response.data.errors;
                // const errorArr = [];
                // for (const key of Object.keys(errorResponse)) {
                //     errorArr.push(errorResponse[key].message);
                // }
                setErrors(errorResponse);
            });
    };

    return (
        <>
            <form className="container" onSubmit={update}>
                {/* {errors.map((err, index) => (
                    <p key={index} className="text-danger">{err}</p>
                ))} */}
                <p>Edit this Country:</p>
                <div className="mb-3">
                    <label htmlFor="name" className="form-label">Name:</label>
                    <input
                        type="text"
                        className="form-control"
                        id="name"
                        onChange={(e) => setName(e.target.value)}
                        value={name}
                    />
                    {errors.name && <p className="text-danger">{errors.name.message}</p>}
                    <label htmlFor="name" className="form-label">Flag:</label>
                    <input
                        type="text"
                        className="form-control"
                        id="flag"
                        onChange={(e) => setFlag(e.target.value)}
                        value={flag}
                    />
                    {errors.flag && <p className="text-danger">{errors.flag.message}</p>}
                    <label htmlFor="name" className="form-label"> Independent :</label>

                    <input type="checkbox" checked={independent} onChange={(e) => setIndependent(e.target.checked)} />




                </div>
                <div className="d-flex justify-content-between">
                    <button type="submit" className="btn btn-primary">Submit</button>
                    <button className="btn btn-secondary" onClick={() => { nav('/'); }}>Cancel</button>
                </div>
            </form>
        </>
    )
}

export default Edit