import './App.css';
import 'semantic-ui-css/semantic.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from './layouts/Navbar/Navbar';
import Footer from './layouts/Footer/Footer';
import AddJobAdvertisement from './pages/JobAdvertisement/AddJobAdvertisement';
import JobAdvertisementList from './pages/JobAdvertisement/JobAdvertisementList';
import JobAdvertisementDetail from './pages/JobAdvertisement/JobAdvertisementDetail';
import HomePage from './pages/HomePage';
import { Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Navbar></Navbar>
      {/* <HomePage></HomePage> */}
      {/* <JobAdvertisementList></JobAdvertisementList> */}
      {/* <AddJobAdvertisement></AddJobAdvertisement> */}
      <Routes>
        <Route exact path='/' element={<HomePage/>} />
        <Route exact path='/job-advertisements' element={<JobAdvertisementList/>} />
        <Route exact path='/job-advertisements/:id' element={<JobAdvertisementDetail/>} />
      </Routes>
      <Footer></Footer>
    </div>
  );
}

export default App;
