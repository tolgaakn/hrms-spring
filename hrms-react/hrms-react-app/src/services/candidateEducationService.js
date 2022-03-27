import axios from "axios";

export default class CandidateEducationService{
    getByCurriculumVitae(curriculumVitaeId){
        return axios.get("http://localhost:8080/api/candidateEducations/getByCurriculumVitaeId?curriculumVitaeId=" + curriculumVitaeId);
    }
}