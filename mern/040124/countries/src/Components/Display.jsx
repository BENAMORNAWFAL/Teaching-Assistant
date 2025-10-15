import React ,{useState} from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'

const Display = ({country,index,deleteCountry,updateCountry}) => {
    const [thisC,setThisC]=useState(country)
  return (
    <div>
        <tr>
            <td>{country.independent ? country.name.common : <s> {country.name.common} </s>}</td>
            <td><img src={country.flags.png} alt="flag" height={50}  /></td>
            <td><input type="checkbox" checked={country.independent} onChange={()=>{updateCountry(index); setThisC({name:{common:thisC.name.common},flags:{png:thisC.flags.png}})}}/> Independent | <button onClick={()=>{deleteCountry(index)} } className='btn btn-danger'>Delete</button></td>
        </tr>

    </div>
  )
}

export default Display