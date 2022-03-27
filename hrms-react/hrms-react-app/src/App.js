import './App.css';
import 'semantic-ui-css/semantic.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from './layouts/Navbar/Navbar';
import HomePage from './pages/HomePage';
import Footer from './layouts/Footer/Footer';
import JobAdvertisementList from './pages/JobAdvertisement/JobAdvertisementList';
import AddJobAdvertisement from './pages/JobAdvertisement/AddJobAdvertisement';

function App() {
  return (
    <div className="App">
      <Navbar></Navbar>
      {/* <HomePage></HomePage> */}
      {/* <JobAdvertisementList></JobAdvertisementList> */}
      <AddJobAdvertisement></AddJobAdvertisement>
      <Footer></Footer>
    </div>
  );
}

export default App;
