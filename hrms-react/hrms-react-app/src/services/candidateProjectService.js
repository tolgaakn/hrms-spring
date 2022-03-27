import axios from "axios";

export default class CandidateProjectService{
    getByCurriculumVitae(curriculumVitaeId){
        return axios.get("http://localhost:8080/api/candidateProjects/getByCurriculumVitae?curriculumVitaeId=" + curriculumVitaeId);
    }
}