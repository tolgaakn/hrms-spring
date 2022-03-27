import axios from "axios";

export default class CurriculumVitaeService{
    getById(id){
        return axios.get("http://localhost:8080/api/curriculumVitaes/getById?id=" + id);
    }
}