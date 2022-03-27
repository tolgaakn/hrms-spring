import axios from "axios";

export default class candidateCertificateService{
    getByCurriculumVitae(curriculumVitaeId){
        return axios.get("http://localhost:8080/api/candidateCertificates/getByCurriculumVitaeId?curriculumVitaeId=" + curriculumVitaeId);
    }
}