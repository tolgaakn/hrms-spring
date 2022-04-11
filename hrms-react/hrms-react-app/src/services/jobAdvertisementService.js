import axios from "axios";

export default class JobAdvertisementService{
    getJobAdvertisements(){
        return axios.get("http://localhost:8080/api/jobAdvertisements/getall");
    }

    getByActive(){
        return axios.get("http://localhost:8080/api/jobAdvertisements/getByActive");
    }

    getByEmployerId(employerId){
        return axios.get("http://localhost:8080/api/jobAdvertisements/getByEmployerId?employerId=" + employerId);
    }

    getJobAdvertisementDetailsById(jobAdvertisementId){
        return axios.get("http://localhost:8080/api/jobAdvertisements/getJobAdvertisementDetailsById?advertisementId=" + jobAdvertisementId);
    }

    add(values){
        return axios.post("http://localhost:8080/api/jobAdvertisements/add", values);
    }
}