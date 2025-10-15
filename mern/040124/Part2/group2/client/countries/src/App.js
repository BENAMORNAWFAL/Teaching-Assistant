
import './App.css';
import { Routes, Route } from 'react-router-dom'
import Home from './Components/Home'
import Create from './Components/Create'
import Edit from './Components/Edit'
import ShowOne from './Components/ShowOne'

function App() {
  return (
    <div>
      
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/country/new' element={<Create />} />
        <Route path='/country/:id' element={<ShowOne />} />
        <Route path='/country/edit/:id' element={<Edit />} />
      </Routes>
    </div>
  );
}

export default App;
