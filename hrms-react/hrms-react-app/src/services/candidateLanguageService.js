import axios from "axios";

export default class CandidateLanguageService{
    getByCurriculumVitae(curriculumVitaeId){
        return axios.get("http://localhost:8080/api/candidateLanguages/getByCurriculumVitae?curriculumVitaeId=" + curriculumVitaeId);
    }
}