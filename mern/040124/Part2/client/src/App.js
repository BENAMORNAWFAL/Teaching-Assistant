
import './App.css';

import { Routes,Route } from 'react-router-dom'
import CountriesList from './components/CountriesList';
import Create from './components/Create';
import Edit from './components/Edit';
import ShowOne from './components/ShowOne';

function App() {
  
  return (
    <>
     <Routes>
       <Route path='/' element={<CountriesList/>}/>
        
        <Route path='/country/:id' element={<ShowOne/>}/>
        
        <Route path='/country/new' element={<Create/>}/>
        
        <Route path='/country/edit/:id' element={<Edit/>}/>
     </Routes>
    </>
  );
}

export default App;
