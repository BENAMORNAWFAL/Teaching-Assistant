import logo from './logo.svg';
import './App.css';
import {Routes,Route} from 'react-router-dom'
import Home from './Components/Home';
import Create from './Components/Create'
import ShowOne from './Components/ShowOne';
import Edit from './Components/Edit';

function App() {
  return (
    <>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path="/country/new" element={<Create/>} />
        <Route path="/country/:id" element={<ShowOne/>}/>
        <Route path='/country/edit/:id' element={<Edit/>}/>
      </Routes>

    </>
  );
}

export default App;
